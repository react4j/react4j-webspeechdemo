package elemental3;

import javax.annotation.Generated;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Object"
)
public class SpeechRecognitionResult {
  /**
   * Type is instantiated by the runtime no attempt should be made to instantiate type by application code.
   */
  @Deprecated
  SpeechRecognitionResult() {
  }

  @JsProperty(
      name = "isFinal"
  )
  public native boolean isFinal();

  @JsProperty(
      name = "length"
  )
  public native int length();
}
