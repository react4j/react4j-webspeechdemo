package react4j.webspeechdemo.browser.speech;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsFunction;

@FunctionalInterface
@JsFunction
public interface SpeechSynthesisEventHandler
{
  void onInvoke( @Nonnull SpeechSynthesisEvent event );
}
