package react4j.webspeechdemo.browser;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "HTMLInputElement" )
public final class HTMLInputElement
{
  @Nonnull
  public String value;

  private HTMLInputElement()
  {
  }
}
