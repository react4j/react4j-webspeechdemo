package react4j.webspeechdemo.browser;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsFunction;

@FunctionalInterface
@JsFunction
public interface EventHandler
{
  void onInvoke( @Nonnull Object event );
}
