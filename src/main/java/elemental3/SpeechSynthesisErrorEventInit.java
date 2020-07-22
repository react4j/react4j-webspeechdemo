package elemental3;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public interface SpeechSynthesisErrorEventInit extends SpeechSynthesisEventInit {
  @JsOverlay
  @Nonnull
  static SpeechSynthesisErrorEventInit create(@Nonnull final SpeechSynthesisUtterance utterance,
      @Nonnull final String error) {
    return Js.<SpeechSynthesisErrorEventInit>uncheckedCast( JsPropertyMap.of() ).utterance( utterance ).error( error );
  }

  @JsProperty
  @Nonnull
  String getError();

  @JsProperty
  void setError(@Nonnull String error);

  @JsOverlay
  @Nonnull
  default SpeechSynthesisErrorEventInit error(@Nonnull String error) {
    setError( error );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default SpeechSynthesisErrorEventInit charIndex(int charIndex) {
    setCharIndex( charIndex );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default SpeechSynthesisErrorEventInit charLength(int charLength) {
    setCharLength( charLength );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default SpeechSynthesisErrorEventInit elapsedTime(float elapsedTime) {
    setElapsedTime( elapsedTime );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default SpeechSynthesisErrorEventInit name(@Nonnull String name) {
    setName( name );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default SpeechSynthesisErrorEventInit utterance(@Nonnull SpeechSynthesisUtterance utterance) {
    setUtterance( utterance );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default SpeechSynthesisErrorEventInit bubbles(boolean bubbles) {
    setBubbles( bubbles );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default SpeechSynthesisErrorEventInit cancelable(boolean cancelable) {
    setCancelable( cancelable );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default SpeechSynthesisErrorEventInit composed(boolean composed) {
    setComposed( composed );
    return this;
  }
}
