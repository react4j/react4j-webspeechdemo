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
    name = "SpeechRecognitionAlternative"
)
public class SpeechRecognitionAlternative {
  @JsProperty(
      name = "confidence"
  )
  public native float confidence();

  @JsProperty(
      name = "transcript"
  )
  @Nonnull
  public native String transcript();
}
