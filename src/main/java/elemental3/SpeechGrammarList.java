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
    name = "SpeechGrammarList"
)
public class SpeechGrammarList {
  public SpeechGrammarList() {
  }

  @JsProperty(
      name = "length"
  )
  public native int length();

  public native void addFromString(@Nonnull String string, float weight);

  public native void addFromString(@Nonnull String string);

  public native void addFromURI(@Nonnull String src, float weight);

  public native void addFromURI(@Nonnull String src);
}
