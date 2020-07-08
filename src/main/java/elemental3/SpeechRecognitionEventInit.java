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
public interface SpeechRecognitionEventInit extends EventInit {
  @JsOverlay
  @Nonnull
  static SpeechRecognitionEventInit create(@Nonnull final SpeechRecognitionResultList results) {
    final SpeechRecognitionEventInit $instance$ = Js.uncheckedCast( JsPropertyMap.of() );
    $instance$.setResults( results );
    return $instance$;
  }

  @JsProperty
  int getResultIndex();

  @JsProperty
  void setResultIndex(int resultIndex);

  @JsProperty
  @Nonnull
  SpeechRecognitionResultList getResults();

  @JsProperty
  void setResults(@Nonnull SpeechRecognitionResultList results);
}
