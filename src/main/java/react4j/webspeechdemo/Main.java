package react4j.webspeechdemo;

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
    final Element element = WindowGlobal.document().getElementById( "app" );
    assert null != element;
    ReactDOM.render( ApplicationBuilder.build(), element );
  }
}
