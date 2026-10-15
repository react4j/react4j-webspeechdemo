package react4j.webspeechdemo.browser;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "HTMLTextAreaElement" )
public final class HTMLTextAreaElement
{
  @Nonnull
  public String value;

  private HTMLTextAreaElement()
  {
  }
}
