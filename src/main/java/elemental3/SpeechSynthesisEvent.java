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
    name = "SpeechSynthesisEvent"
)
public class SpeechSynthesisEvent extends Event {
  public SpeechSynthesisEvent(@Nonnull final String type,
      @Nonnull final SpeechSynthesisEventInit eventInitDict) {
    super( null );
  }

  @JsProperty(
      name = "charIndex"
  )
  public native int charIndex();

  @JsProperty(
      name = "charLength"
  )
  public native int charLength();

  @JsProperty(
      name = "elapsedTime"
  )
  public native float elapsedTime();

  @JsProperty(
      name = "name"
  )
  @Nonnull
  public native String name();

  @JsProperty(
      name = "utterance"
  )
  @Nonnull
  public native SpeechSynthesisUtterance utterance();
}
