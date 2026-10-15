package react4j.webspeechdemo;

import com.google.gwt.core.client.EntryPoint;
import react4j.dom.ReactDOM;
import react4j.webspeechdemo.browser.Console;
import react4j.webspeechdemo.browser.Element;
import react4j.webspeechdemo.browser.WindowGlobal;

public final class Main
  implements EntryPoint
{
  @Override
  public void onModuleLoad()
  {
    if ( WindowGlobal.isSpeechSynthesisSupported() )
    {
      final Element element = WindowGlobal.document().getElementById( "app" );
      assert null != element;
      ReactDOM.render( ApplicationBuilder.build(), element );
    }
    else
    {
      Console.log( "Speech API not present" );
    }
  }
}
