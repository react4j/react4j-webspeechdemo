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
public interface SpeechRecognitionErrorEventInit extends EventInit {
  @JsOverlay
  @Nonnull
  static SpeechRecognitionErrorEventInit create(@Nonnull final String error) {
    final SpeechRecognitionErrorEventInit $instance$ = Js.uncheckedCast( JsPropertyMap.of() );
    $instance$.setError( error );
    return $instance$;
  }

  @JsProperty
  @Nonnull
  String getError();

  @JsProperty
  void setError(@Nonnull String error);

  @JsProperty
  String getMessage();

  @JsProperty
  void setMessage(@Nonnull String message);
}
