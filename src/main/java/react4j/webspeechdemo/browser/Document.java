package react4j.webspeechdemo.browser;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Document" )
public final class Document
{
  @Nullable
  public Element body;

  private Document()
  {
  }

  @Nullable
  public native Element getElementById( @Nonnull String elementId );

  @Nonnull
  public native Range createRange();
}
