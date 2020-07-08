package elemental3;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SpeechRecognitionErrorEvent"
)
public class SpeechRecognitionErrorEvent extends Event {
  public SpeechRecognitionErrorEvent(@Nonnull final String type,
      @Nonnull final SpeechRecognitionErrorEventInit eventInitDict) {
    super( null );
  }

  @JsProperty(
      name = "error"
  )
  @Nonnull
  public native String error();

  @JsProperty(
      name = "message"
  )
  @Nonnull
  public native String message();
}
