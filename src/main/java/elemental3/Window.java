package elemental3;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

/**
 * The Window interface represents a window containing a DOM document; the document property points to the DOM document loaded in that window.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window">Window - MDN</a>
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Window"
)
public final class Window {
  private Window() {
  }

  @JsOverlay
  @Nonnull
  public static Window of(@Nonnull final Object object) {
    return Js.cast( object );
  }

  @JsProperty(
      name = "speechSynthesis"
  )
  @Nonnull
  public native SpeechSynthesis speechSynthesis();
}
