package elemental3;

import elemental2.core.JsArray;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The SpeechSynthesis interface of the Web Speech API is the controller interface for the speech service; this can be used to retrieve information about the synthesis voices available on the device, start and pause speech, and other commands besides.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/SpeechSynthesis">SpeechSynthesis - MDN</a>
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Object"
)
public class SpeechSynthesis extends EventTarget {
  @Nullable
  public EventHandler onvoiceschanged;

  SpeechSynthesis() {
  }

  /**
   * The paused read-only property of the SpeechSynthesis interface is a Boolean that returns true if the SpeechSynthesis object is in a paused state, or false if not.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/SpeechSynthesis/paused">SpeechSynthesis.paused - MDN</a>
   */
  @JsProperty(
      name = "paused"
  )
  public native boolean paused();

  /**
   * The pending read-only property of the SpeechSynthesis interface is a Boolean that returns true if the utterance queue contains as-yet-unspoken utterances.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/SpeechSynthesis/pending">SpeechSynthesis.pending - MDN</a>
   */
  @JsProperty(
      name = "pending"
  )
  public native boolean pending();

  /**
   * The speaking read-only property of the SpeechSynthesis interface is a Boolean that returns true if an utterance is currently in the process of being spoken — even if SpeechSynthesis is in a paused state.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/SpeechSynthesis/speaking">SpeechSynthesis.speaking - MDN</a>
   */
  @JsProperty(
      name = "speaking"
  )
  public native boolean speaking();

  /**
   * The cancel() method of the SpeechSynthesis interface removes all utterances from the utterance queue.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/SpeechSynthesis/cancel">SpeechSynthesis.cancel - MDN</a>
   */
  public native void cancel();

  /**
   * The getVoices() method of the SpeechSynthesis interface returns a list of SpeechSynthesisVoice objects representing all the available voices on the current device.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/SpeechSynthesis/getVoices">SpeechSynthesis.getVoices - MDN</a>
   */
  @Nonnull
  public native JsArray<SpeechSynthesisVoice> getVoices();

  /**
   * The pause() method of the SpeechSynthesis interface puts the SpeechSynthesis object into a paused state.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/SpeechSynthesis/pause">SpeechSynthesis.pause - MDN</a>
   */
  public native void pause();

  /**
   * The resume() method of the SpeechSynthesis interface puts the SpeechSynthesis object into a non-paused state: resumes it if it was already paused.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/SpeechSynthesis/resume">SpeechSynthesis.resume - MDN</a>
   */
  public native void resume();

  /**
   * The speak() method of the SpeechSynthesis interface adds an utterance to the utterance queue; it will be spoken when any other utterances queued before it have been spoken.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/SpeechSynthesis/speak">SpeechSynthesis.speak - MDN</a>
   */
  public native void speak(@Nonnull SpeechSynthesisUtterance utterance);
}
