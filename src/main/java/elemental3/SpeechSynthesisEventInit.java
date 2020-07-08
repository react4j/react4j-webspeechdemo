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
    final SpeechSynthesisEventInit $instance$ = Js.uncheckedCast( JsPropertyMap.of() );
    $instance$.setUtterance( utterance );
    return $instance$;
  }

  @JsProperty
  int getCharIndex();

  @JsProperty
  void setCharIndex(int charIndex);

  @JsProperty
  int getCharLength();

  @JsProperty
  void setCharLength(int charLength);

  @JsProperty
  float getElapsedTime();

  @JsProperty
  void setElapsedTime(float elapsedTime);

  @JsProperty
  String getName();

  @JsProperty
  void setName(@Nonnull String name);

  @JsProperty
  @Nonnull
  SpeechSynthesisUtterance getUtterance();

  @JsProperty
  void setUtterance(@Nonnull SpeechSynthesisUtterance utterance);
}
