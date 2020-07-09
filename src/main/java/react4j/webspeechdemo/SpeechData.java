package react4j.webspeechdemo;

import arez.ComputableValue;
import arez.annotations.Action;
import arez.annotations.ArezComponent;
import arez.annotations.ComputableValueRef;
import arez.annotations.DepType;
import arez.annotations.Feature;
import arez.annotations.Memoize;
import arez.annotations.Observable;
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

@ArezComponent
abstract class SpeechData
{
  @Nonnull
  private final EventListener _eventListener = e -> triggerRecalculation( getVoicesComputableValue() );

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  static SpeechData create( final double pitch, final double rate, final double volume )
  {
    return new Arez_SpeechData( pitch, rate, volume );
  }

  @Observable( readOutsideTransaction = Feature.ENABLE, writeOutsideTransaction = Feature.ENABLE, initializer = Feature.ENABLE )
  abstract double getPitch();

  abstract void setPitch( double pitch );

  @Observable( readOutsideTransaction = Feature.ENABLE, writeOutsideTransaction = Feature.ENABLE, initializer = Feature.ENABLE )
  abstract double getRate();

  abstract void setRate( double rate );

  @Observable( readOutsideTransaction = Feature.ENABLE, writeOutsideTransaction = Feature.ENABLE, initializer = Feature.ENABLE )
  abstract double getVolume();

  abstract void setVolume( double volume );

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

  @Nonnull
  private SpeechSynthesis getSpeechSynthesis()
  {
    return WebSpeechWindow.of( DomGlobal.window ).speechSynthesis();
  }
}
