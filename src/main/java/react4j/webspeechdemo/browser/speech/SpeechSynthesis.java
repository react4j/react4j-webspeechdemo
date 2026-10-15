package react4j.webspeechdemo.browser.speech;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.JsArrayLike;
import react4j.webspeechdemo.browser.EventHandler;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "SpeechSynthesis" )
public final class SpeechSynthesis
{
  private SpeechSynthesis()
  {
  }

  @JsProperty( name = "speaking" )
  public native boolean speaking();

  @JsProperty( name = "paused" )
  public native boolean paused();

  @Nonnull
  public native JsArrayLike<SpeechSynthesisVoice> getVoices();

  public native void addEventListener( @Nonnull String type, @Nonnull EventHandler listener );

  public native void removeEventListener( @Nonnull String type, @Nonnull EventHandler listener );

  public native void speak( @Nonnull SpeechSynthesisUtterance utterance );

  public native void cancel();

  public native void pause();

  public native void resume();
}
