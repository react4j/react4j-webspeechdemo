package react4j.webspeechdemo;

import com.google.gwt.core.client.EntryPoint;
import elemental2.dom.DomGlobal;
import react4j.dom.ReactDOM;

public final class Main
  implements EntryPoint
{
  @Override
  public void onModuleLoad()
  {
    ReactDOM.render( ApplicationBuilder.build(), DomGlobal.document.getElementById( "app" ) );
  }
}
