package react4j.webspeechdemo;

import akasha.Console;
import akasha.Element;
import akasha.WindowGlobal;
import com.google.gwt.core.client.EntryPoint;
import react4j.dom.ReactDOM;

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
