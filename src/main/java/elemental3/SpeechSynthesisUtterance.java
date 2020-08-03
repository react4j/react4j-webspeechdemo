package elemental3;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * The SpeechSynthesisUtterance interface of the Web Speech API represents a speech request. It contains the content the speech service should read and information about how to read it (e.g. language, pitch and volume.)
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/SpeechSynthesisUtterance">SpeechSynthesisUtterance - MDN</a>
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SpeechSynthesisUtterance"
)
public class SpeechSynthesisUtterance extends EventTarget {
  /**
   * The lang property of the SpeechSynthesisUtterance interface gets and sets the language of the utterance.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/SpeechSynthesisUtterance/lang">SpeechSynthesisUtterance.lang - MDN</a>
   */
  @Nonnull
  public String lang;

  @Nullable
  public EventHandler onboundary;

  @Nullable
  public EventHandler onend;

  @Nullable
  public EventHandler onerror;

  @Nullable
  public EventHandler onmark;

  @Nullable
  public EventHandler onpause;

  @Nullable
  public EventHandler onresume;

  @Nullable
  public EventHandler onstart;

  /**
   * The pitch property of the SpeechSynthesisUtterance interface gets and sets the pitch at which the utterance will be spoken at.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/SpeechSynthesisUtterance/pitch">SpeechSynthesisUtterance.pitch - MDN</a>
   */
  public float pitch;

  /**
   * The rate property of the SpeechSynthesisUtterance interface gets and sets the speed at which the utterance will be spoken at.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/SpeechSynthesisUtterance/rate">SpeechSynthesisUtterance.rate - MDN</a>
   */
  public float rate;

  /**
   * The text property of the SpeechSynthesisUtterance interface gets and sets the text that will be synthesised when the utterance is spoken.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/SpeechSynthesisUtterance/text">SpeechSynthesisUtterance.text - MDN</a>
   */
  @Nonnull
  public String text;

  /**
   * The voice property of the SpeechSynthesisUtterance interface gets and sets the voice that will be used to speak the utterance.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/SpeechSynthesisUtterance/voice">SpeechSynthesisUtterance.voice - MDN</a>
   */
  @Nullable
  public SpeechSynthesisVoice voice;

  /**
   * The volume property of the SpeechSynthesisUtterance interface gets and sets the volume that the utterance will be spoken at.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/SpeechSynthesisUtterance/volume">SpeechSynthesisUtterance.volume - MDN</a>
   */
  public float volume;

  public SpeechSynthesisUtterance(@Nonnull final String text) {
  }

  public SpeechSynthesisUtterance() {
  }
}
