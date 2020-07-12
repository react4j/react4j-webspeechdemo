package react4j.webspeechdemo;

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
import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental3.EventListener;
import elemental3.SpeechSynthesis;
import elemental3.SpeechSynthesisEvent;
import elemental3.SpeechSynthesisUtterance;
import elemental3.SpeechSynthesisVoice;
import java.util.Arrays;
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
  abstract boolean isSpeaking();

  abstract void setSpeaking( boolean speaking );

  @Observable( readOutsideTransaction = Feature.ENABLE, writeOutsideTransaction = Feature.ENABLE )
  abstract boolean isPaused();

  abstract void setPaused( boolean paused );

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
    final JsArray<SpeechSynthesisVoice> voices = speechSynthesis().getVoices();
    return Arrays.asList( voices.asArray( new SpeechSynthesisVoice[ voices.length ] ) );
  }

  @ComputableValueRef
  abstract ComputableValue<?> getVoicesComputableValue();

  @OnActivate
  void onVoicesActivate()
  {
    speechSynthesis().addEventListener( "voiceschanged", _eventListener );
  }

  @OnDeactivate
  void onVoicesDeactivate()
  {
    speechSynthesis().removeEventListener( "voiceschanged", _eventListener );
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
    return WebSpeechWindow.of( DomGlobal.window ).speechSynthesis();
  }

  void stopSpeaking()
  {
    speechSynthesis().cancel();
  }

  void startSpeaking()
  {
    final SpeechSynthesisUtterance utterance = new SpeechSynthesisUtterance( getText() );
    utterance.voice = getVoice();
    utterance.volume = getVolume();
    utterance.pitch = getPitch();
    final float rate = getRate();
    utterance.rate = (float) Math.pow( Math.abs( rate ) + 1, rate < 0 ? -1 : 1 );
    utterance.addEventListener( "start", e -> onSpeechEvent( (SpeechSynthesisEvent) e ) );
    utterance.addEventListener( "end", e -> onSpeechEvent( (SpeechSynthesisEvent) e ) );
    utterance.addEventListener( "error", e -> onSpeechEvent( (SpeechSynthesisEvent) e ) );
    utterance.addEventListener( "boundary", e -> onSpeechEvent( (SpeechSynthesisEvent) e ) );
    utterance.addEventListener( "pause", e -> onSpeechEvent( (SpeechSynthesisEvent) e ) );
    utterance.addEventListener( "resume", e -> onSpeechEvent( (SpeechSynthesisEvent) e ) );
    speechSynthesis().speak( utterance );
  }

  @Action( verifyRequired = false )
  void onSpeechEvent( @Nonnull final SpeechSynthesisEvent event )
  {
    switch ( event.type() )
    {
      case "start":
        getSpeakingComputableValue().reportPossiblyChanged();
        getPausedComputableValue().reportPossiblyChanged();
        break;
      case "error":
      case "end":
        getSpeakingComputableValue().reportPossiblyChanged();
        getPausedComputableValue().reportPossiblyChanged();
        break;
      case "pause":
      case "resume":
        getSpeakingComputableValue().reportPossiblyChanged();
        getPausedComputableValue().reportPossiblyChanged();
        break;
      case "boundary":
        break;
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
    return getVoices().stream().filter( SpeechSynthesisVoice::_default ).findAny().orElse( null );
  }
}
