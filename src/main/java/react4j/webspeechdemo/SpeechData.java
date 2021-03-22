package react4j.webspeechdemo;

import akasha.EventListener;
import akasha.Global;
import akasha.speech.SpeechSynthesis;
import akasha.speech.SpeechSynthesisEvent;
import akasha.speech.SpeechSynthesisUtterance;
import akasha.speech.SpeechSynthesisVoice;
import arez.ComputableValue;
import arez.annotations.Action;
import arez.annotations.ArezComponent;
import arez.annotations.ComputableValueRef;
import arez.annotations.DepType;
import arez.annotations.Feature;
import arez.annotations.Memoize;
import arez.annotations.Observable;
import arez.annotations.Observe;
import arez.annotations.OnActivate;
import arez.annotations.OnDeactivate;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@ArezComponent
abstract class SpeechData
{
  @Nonnull
  private final EventListener _eventListener = e -> triggerRecalculation( getVoicesComputableValue() );

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  static SpeechData create( final float pitch, final float rate, final float volume, @Nonnull final String text )
  {
    return new Arez_SpeechData( pitch, rate, volume, text );
  }

  @Memoize( name = "speaking", readOutsideTransaction = Feature.ENABLE, depType = DepType.AREZ_OR_EXTERNAL )
  boolean isSpeaking()
  {
    return speechSynthesis().speaking();
  }

  @ComputableValueRef
  abstract ComputableValue<?> getSpeakingComputableValue();

  @Memoize( name = "paused", readOutsideTransaction = Feature.ENABLE, depType = DepType.AREZ_OR_EXTERNAL )
  boolean isPaused()
  {
    return speechSynthesis().paused();
  }

  @ComputableValueRef
  abstract ComputableValue<?> getPausedComputableValue();

  @Observable( readOutsideTransaction = Feature.ENABLE, writeOutsideTransaction = Feature.ENABLE )
  abstract int utteredWordOffset();

  abstract void setUtteredWordOffset( int utteredWordOffset );

  @Observable( readOutsideTransaction = Feature.ENABLE, writeOutsideTransaction = Feature.ENABLE )
  abstract int utteredWordLength();

  abstract void setUtteredWordLength( int utteredWordLength );

  @Observable( readOutsideTransaction = Feature.ENABLE, writeOutsideTransaction = Feature.ENABLE, initializer = Feature.ENABLE )
  abstract float getPitch();

  abstract void setPitch( float pitch );

  @Observable( readOutsideTransaction = Feature.ENABLE, writeOutsideTransaction = Feature.ENABLE, initializer = Feature.ENABLE )
  abstract float getRate();

  abstract void setRate( float rate );

  @Observable( readOutsideTransaction = Feature.ENABLE, writeOutsideTransaction = Feature.ENABLE, initializer = Feature.ENABLE )
  abstract float getVolume();

  abstract void setVolume( float volume );

  @Observable( readOutsideTransaction = Feature.ENABLE, writeOutsideTransaction = Feature.ENABLE )
  @Nullable
  abstract SpeechSynthesisVoice getVoice();

  abstract void setVoice( @Nullable SpeechSynthesisVoice voice );

  @Observable( readOutsideTransaction = Feature.ENABLE, writeOutsideTransaction = Feature.ENABLE )
  @Nonnull
  abstract String getText();

  abstract void setText( @Nonnull String text );

  @Memoize( depType = DepType.AREZ_OR_EXTERNAL )
  List<SpeechSynthesisVoice> getVoices()
  {
    return speechSynthesis().getVoices().asList();
  }

  @ComputableValueRef
  abstract ComputableValue<?> getVoicesComputableValue();

  @OnActivate
  void onVoicesActivate()
  {
    speechSynthesis().addVoiceschangedListener( _eventListener );
  }

  @OnDeactivate
  void onVoicesDeactivate()
  {
    speechSynthesis().removeVoiceschangedListener( _eventListener );
  }

  @Action
  void triggerRecalculation( @Nonnull final ComputableValue<?> computableValue )
  {
    computableValue.reportPossiblyChanged();
  }

  @Observe( mutation = true )
  void maintainCurrentVoice()
  {
    final List<SpeechSynthesisVoice> voices = getVoices();
    final SpeechSynthesisVoice voice = getVoice();
    if ( null == voice || !voices.contains( voice ) )
    {
      setVoice( getDefaultVoice() );
    }
  }

  @Nonnull
  private SpeechSynthesis speechSynthesis()
  {
    return Global.speechSynthesis();
  }

  void stopSpeaking()
  {
    speechSynthesis().cancel();
  }

  void startSpeaking()
  {
    setUtteredWordOffset( 0 );
    setUtteredWordLength( 0 );
    final SpeechSynthesisUtterance utterance = new SpeechSynthesisUtterance( getText() );
    utterance.voice = getVoice();
    utterance.volume = getVolume();
    utterance.pitch = getPitch();
    final float rate = getRate();
    utterance.rate = (float) Math.pow( Math.abs( rate ) + 1, rate < 0 ? -1 : 1 );
    utterance.onstart = this::onSpeechEvent;
    utterance.onend = this::onSpeechEvent;
    utterance.onerror = this::onSpeechEvent;
    utterance.onboundary = this::onSpeechEvent;
    utterance.onpause = this::onSpeechEvent;
    utterance.onresume = this::onSpeechEvent;
    speechSynthesis().speak( utterance );
  }

  @Action( verifyRequired = false )
  void onSpeechEvent( @Nonnull final SpeechSynthesisEvent event )
  {
    final String type = event.type();
    if ( !"boundary".equals( type ) )
    {
      getSpeakingComputableValue().reportPossiblyChanged();
      getPausedComputableValue().reportPossiblyChanged();
    }
    if ( ( "error".equals( type ) || "end".equals( type ) ) && speechSynthesis().paused() )
    {
      // After a period of time paused a speech utterance will be stopped
      // by the speech synthesis engine. If we do not explicitly cancel then
      // the next time we try to start synthesis it will start paused and unable
      // to resume the existing utterance. (i.e. invoking resume is insufficient)
      // Cancelling here seems to reset the state of the synthesis engine but it does
      // lead to odd UI as can not resume from where last left off without a lot
      // more effort.
      speechSynthesis().cancel();
    }
    else if ( "boundary".equals( type ) && event.name().equals( "word" ) )
    {
      setUtteredWordOffset( event.charIndex() );
      setUtteredWordLength( event.charLength() );
    }
  }

  void pause()
  {
    speechSynthesis().pause();
  }

  void resume()
  {
    speechSynthesis().resume();
  }

  @Action
  void resetVoice()
  {
    setVoice( getDefaultVoice() );
  }

  @Action
  void setVoiceByVoiceURI( @Nonnull final String voiceURI )
  {
    setVoice( getVoices().stream().filter( v -> v.voiceURI().equals( voiceURI ) ).findFirst().orElse( null ) );
  }

  @Nullable
  SpeechSynthesisVoice getDefaultVoice()
  {
    return getVoices().stream().filter( SpeechSynthesisVoice::default_ ).findAny().orElse( null );
  }
}
