package react4j.webspeechdemo.browser.speech;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "SpeechSynthesisUtterance" )
public final class SpeechSynthesisUtterance
{
  @Nullable
  public SpeechSynthesisVoice voice;
  public float volume;
  public float pitch;
  public float rate;
  @Nullable
  public SpeechSynthesisEventHandler onstart;
  @Nullable
  public SpeechSynthesisEventHandler onend;
  @Nullable
  public SpeechSynthesisEventHandler onerror;
  @Nullable
  public SpeechSynthesisEventHandler onboundary;
  @Nullable
  public SpeechSynthesisEventHandler onpause;
  @Nullable
  public SpeechSynthesisEventHandler onresume;

  public SpeechSynthesisUtterance( @Nonnull final String text )
  {
  }
}
