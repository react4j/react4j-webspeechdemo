package elemental3;

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
    name = "?"
)
public interface AddEventListenerOptions extends EventListenerOptions {
  @JsOverlay
  @Nonnull
  static AddEventListenerOptions create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty
  boolean isOnce();

  @JsProperty
  void setOnce(boolean once);

  @JsOverlay
  @Nonnull
  default AddEventListenerOptions once(boolean once) {
    setOnce( once );
    return this;
  }

  @JsProperty
  boolean isPassive();

  @JsProperty
  void setPassive(boolean passive);

  @JsOverlay
  @Nonnull
  default AddEventListenerOptions passive(boolean passive) {
    setPassive( passive );
    return this;
  }
}
