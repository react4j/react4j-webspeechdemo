package akasha;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Object"
)
public interface EventListenerOptions {
  @JsOverlay
  @Nonnull
  static EventListenerOptions create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "capture"
  )
  boolean capture();

  @JsProperty
  void setCapture(boolean capture);

  @JsOverlay
  @Nonnull
  default EventListenerOptions capture(final boolean capture) {
    setCapture( capture );
    return this;
  }
}
