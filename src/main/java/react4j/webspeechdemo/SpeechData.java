package react4j.webspeechdemo;

import arez.annotations.ArezComponent;
import arez.annotations.Feature;
import arez.annotations.Observable;
import javax.annotation.Nonnull;

@ArezComponent
abstract class SpeechData
{
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
}
