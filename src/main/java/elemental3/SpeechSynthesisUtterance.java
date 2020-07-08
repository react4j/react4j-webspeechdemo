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
  public EventHandlerNonNull onboundary;

  @Nullable
  public EventHandlerNonNull onend;

  @Nullable
  public EventHandlerNonNull onerror;

  @Nullable
  public EventHandlerNonNull onmark;

  @Nullable
  public EventHandlerNonNull onpause;

  @Nullable
  public EventHandlerNonNull onresume;

  @Nullable
  public EventHandlerNonNull onstart;

  public float pitch;

  public float rate;

  @Nonnull
  public String text;

  @Nullable
  public SpeechSynthesisVoice voice;

  public float volume;

  public SpeechSynthesisUtterance(@Nonnull final String text) {
    super(  );
  }

  public SpeechSynthesisUtterance() {
    super(  );
  }
}
