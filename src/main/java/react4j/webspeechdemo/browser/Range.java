package react4j.webspeechdemo.browser;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Range" )
public final class Range
{
  private Range()
  {
  }

  public native void setStart( @Nonnull Node node, int offset );

  public native void setEnd( @Nonnull Node node, int offset );

  @Nonnull
  public native DOMRect getBoundingClientRect();
}
