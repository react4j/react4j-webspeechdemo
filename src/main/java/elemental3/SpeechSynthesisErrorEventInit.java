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
    final SpeechSynthesisErrorEventInit $instance$ = Js.uncheckedCast( JsPropertyMap.of() );
    $instance$.setUtterance( utterance );
    $instance$.setError( error );
    return $instance$;
  }

  @JsProperty
  @Nonnull
  String getError();

  @JsProperty
  void setError(@Nonnull String error);
}
