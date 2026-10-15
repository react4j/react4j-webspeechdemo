package react4j.webspeechdemo.browser;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "HTMLSelectElement" )
public final class HTMLSelectElement
{
  @Nonnull
  public String value;

  private HTMLSelectElement()
  {
  }
}
