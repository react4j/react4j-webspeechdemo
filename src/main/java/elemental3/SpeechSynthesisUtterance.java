package elemental3;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SpeechSynthesisUtterance"
)
public class SpeechSynthesisUtterance extends EventTarget {
  @Nonnull
  public String lang;

  @Nullable
  public EventHandler onboundary;

  @Nullable
  public EventHandler onend;

  @Nullable
  public EventHandler onerror;

  @Nullable
  public EventHandler onmark;

  @Nullable
  public EventHandler onpause;

  @Nullable
  public EventHandler onresume;

  @Nullable
  public EventHandler onstart;

  public float pitch;

  public float rate;

  @Nonnull
  public String text;

  @Nullable
  public SpeechSynthesisVoice voice;

  public float volume;

  public SpeechSynthesisUtterance(@Nonnull final String text) {
  }

  public SpeechSynthesisUtterance() {
  }
}
