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
    name = "SpeechRecognition"
)
public class SpeechRecognition extends EventTarget {
  public boolean continuous;

  @Nonnull
  public SpeechGrammarList grammars;

  public boolean interimResults;

  @Nonnull
  public String lang;

  public int maxAlternatives;

  @Nullable
  public EventHandlerNonNull onaudioend;

  @Nullable
  public EventHandlerNonNull onaudiostart;

  @Nullable
  public EventHandlerNonNull onend;

  @Nullable
  public EventHandlerNonNull onerror;

  @Nullable
  public EventHandlerNonNull onnomatch;

  @Nullable
  public EventHandlerNonNull onresult;

  @Nullable
  public EventHandlerNonNull onsoundend;

  @Nullable
  public EventHandlerNonNull onsoundstart;

  @Nullable
  public EventHandlerNonNull onspeechend;

  @Nullable
  public EventHandlerNonNull onspeechstart;

  @Nullable
  public EventHandlerNonNull onstart;

  public SpeechRecognition() {
    super(  );
  }

  public native void abort();

  public native void start();

  public native void stop();
}
