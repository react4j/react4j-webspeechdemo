package react4j.webspeechdemo;

import elemental3.SpeechSynthesis;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

// TODO: This should be generated. It is also unclear why webtack did not generate an error
//  when it found un processed partial
@JsType( isNative = true, name = "Window", namespace = JsPackage.GLOBAL )
public final class WebSpeechWindow
{
  @JsOverlay
  @Nonnull
  public static WebSpeechWindow of( @Nonnull final Object o )
  {
    return Js.cast( o );
  }

  // Constructor is only present to support the java compiler
  private WebSpeechWindow()
  {
  }

  @JsProperty( name = "speechSynthesis" )
  @Nonnull
  public native SpeechSynthesis speechSynthesis();
}
