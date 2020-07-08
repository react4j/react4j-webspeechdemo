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
    name = "SpeechSynthesisErrorEvent"
)
public class SpeechSynthesisErrorEvent extends SpeechSynthesisEvent {
  public SpeechSynthesisErrorEvent(@Nonnull final String type,
      @Nonnull final SpeechSynthesisErrorEventInit eventInitDict) {
    super( null, null );
  }

  @JsProperty(
      name = "error"
  )
  @Nonnull
  public native String error();
}
