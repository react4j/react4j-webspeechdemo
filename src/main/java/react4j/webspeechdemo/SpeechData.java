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

  @Observable( readOutsideTransaction = Feature.ENABLE, writeOutsideTransaction = Feature.ENABLE )
  abstract boolean isSpeaking();

  abstract void setSpeaking( boolean speaking );

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
    final JsArray<SpeechSynthesisVoice> voices = getSpeechSynthesis().getVoices();
    return Arrays.asList( voices.asArray( new SpeechSynthesisVoice[ voices.length ] ) );
  }

  @ComputableValueRef
  abstract ComputableValue<?> getVoicesComputableValue();

  @OnActivate
  void onVoicesActivate()
  {
    getSpeechSynthesis().addEventListener( "voiceschanged", _eventListener );
  }

  @OnDeactivate
  void onVoicesDeactivate()
  {
    getSpeechSynthesis().removeEventListener( "voiceschanged", _eventListener );
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
  SpeechSynthesis getSpeechSynthesis()
  {
    return WebSpeechWindow.of( DomGlobal.window ).speechSynthesis();
  }

  void stopSpeaking()
  {
    getSpeechSynthesis().cancel();
    setSpeaking( false );
  }

  void startSpeaking()
  {
  }

  void togglePause()
  {
    final SpeechSynthesis speechSynthesis = getSpeechSynthesis();
    if ( speechSynthesis.paused() )
    {
      speechSynthesis.resume();
    }
    else
    {
      speechSynthesis.pause();
    }
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
