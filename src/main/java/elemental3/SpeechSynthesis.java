package elemental3;

import elemental2.core.JsArray;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SpeechSynthesis"
)
public class SpeechSynthesis extends EventTarget {
  @Nullable
  public EventHandlerNonNull onvoiceschanged;

  @JsProperty(
      name = "paused"
  )
  public native boolean paused();

  @JsProperty(
      name = "pending"
  )
  public native boolean pending();

  @JsProperty(
      name = "speaking"
  )
  public native boolean speaking();

  public native void cancel();

  @Nonnull
  public native JsArray<SpeechSynthesisVoice> getVoices();

  public native void pause();

  public native void resume();

  public native void speak(@Nonnull SpeechSynthesisUtterance utterance);
}
