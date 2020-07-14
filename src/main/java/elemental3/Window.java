package elemental3;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

// TODO: This should be generated. It is also unclear why webtack did not generate an error
//  when it found un processed partial
@JsType( isNative = true, name = "Window", namespace = JsPackage.GLOBAL )
public final class Window
{
  @JsOverlay
  @Nonnull
  public static Window of( @Nonnull final Object o )
  {
    return Js.cast( o );
  }

  // Constructor is only present to support the java compiler
  @Deprecated
  private Window()
  {
  }

  @JsProperty( name = "speechSynthesis" )
  @Nonnull
  public native SpeechSynthesis speechSynthesis();
}
