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
    name = "SpeechRecognitionEvent"
)
public class SpeechRecognitionEvent extends Event {
  public SpeechRecognitionEvent(@Nonnull final String type,
      @Nonnull final SpeechRecognitionEventInit eventInitDict) {
    super( null );
  }

  @JsProperty(
      name = "resultIndex"
  )
  public native int resultIndex();

  @JsProperty(
      name = "results"
  )
  @Nonnull
  public native SpeechRecognitionResultList results();
}
