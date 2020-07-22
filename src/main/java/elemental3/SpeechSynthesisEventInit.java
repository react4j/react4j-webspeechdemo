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
public interface SpeechSynthesisEventInit extends EventInit {
  @JsOverlay
  @Nonnull
  static SpeechSynthesisEventInit create(@Nonnull final SpeechSynthesisUtterance utterance) {
    return Js.<SpeechSynthesisEventInit>uncheckedCast( JsPropertyMap.of() ).utterance( utterance );
  }

  @JsProperty
  int getCharIndex();

  @JsProperty
  void setCharIndex(int charIndex);

  @JsOverlay
  @Nonnull
  default SpeechSynthesisEventInit charIndex(int charIndex) {
    setCharIndex( charIndex );
    return this;
  }

  @JsProperty
  int getCharLength();

  @JsProperty
  void setCharLength(int charLength);

  @JsOverlay
  @Nonnull
  default SpeechSynthesisEventInit charLength(int charLength) {
    setCharLength( charLength );
    return this;
  }

  @JsProperty
  float getElapsedTime();

  @JsProperty
  void setElapsedTime(float elapsedTime);

  @JsOverlay
  @Nonnull
  default SpeechSynthesisEventInit elapsedTime(float elapsedTime) {
    setElapsedTime( elapsedTime );
    return this;
  }

  @JsProperty
  String getName();

  @JsProperty
  void setName(@Nonnull String name);

  @JsOverlay
  @Nonnull
  default SpeechSynthesisEventInit name(@Nonnull String name) {
    setName( name );
    return this;
  }

  @JsProperty
  @Nonnull
  SpeechSynthesisUtterance getUtterance();

  @JsProperty
  void setUtterance(@Nonnull SpeechSynthesisUtterance utterance);

  @JsOverlay
  @Nonnull
  default SpeechSynthesisEventInit utterance(@Nonnull SpeechSynthesisUtterance utterance) {
    setUtterance( utterance );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default SpeechSynthesisEventInit bubbles(boolean bubbles) {
    setBubbles( bubbles );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default SpeechSynthesisEventInit cancelable(boolean cancelable) {
    setCancelable( cancelable );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default SpeechSynthesisEventInit composed(boolean composed) {
    setComposed( composed );
    return this;
  }
}
