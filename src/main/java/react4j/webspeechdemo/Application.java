package react4j.webspeechdemo;

import arez.annotations.CascadeDispose;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLSelectElement;
import elemental2.dom.HTMLTextAreaElement;
import elemental3.SpeechSynthesisVoice;
import javax.annotation.Nonnull;
import jsinterop.base.Js;
import react4j.ReactNode;
import react4j.annotations.PostMount;
import react4j.annotations.Render;
import react4j.annotations.View;
import react4j.dom.events.FormEvent;
import react4j.dom.proptypes.html.BtnProps;
import react4j.dom.proptypes.html.HtmlProps;
import react4j.dom.proptypes.html.ImgProps;
import react4j.dom.proptypes.html.InputProps;
import react4j.dom.proptypes.html.LabelProps;
import react4j.dom.proptypes.html.OptionProps;
import react4j.dom.proptypes.html.SelectProps;
import react4j.dom.proptypes.html.TextAreaProps;
import react4j.dom.proptypes.html.attributeTypes.ButtonType;
import react4j.dom.proptypes.html.attributeTypes.InputType;
import static react4j.dom.DOM.*;

@View( type = View.Type.TRACKING )
abstract class Application
{
  private static final float DEFAULT_PITCH = 0.5F;
  private static final float DEFAULT_RATE = 0.0F;
  private static final float DEFAULT_VOLUME = 1.0F;
  @Nonnull
  private static final String DEFAULT_TEXT =
    "Call me Ishmael. Some years ago—never mind how long precisely—having " +
    "little or no money in my purse, and nothing particular to interest me on shore, I thought " +
    "I would sail about a little and see the watery part of the world.";
  @CascadeDispose
  final SpeechData _speechData = SpeechData.create( DEFAULT_PITCH, DEFAULT_RATE, DEFAULT_VOLUME, DEFAULT_TEXT );

  @PostMount
  void postMount()
  {
    // In case speech synthesis is still running from a previous run of the application
    _speechData.stopSpeaking();
  }

  @Nonnull
  @Render
  ReactNode render()
  {
    final SpeechSynthesisVoice voice = _speechData.getVoice();
    return
      fragment(
        h1( "Web Speech Synthesis Demo" ),
        form(
          div( new HtmlProps().id( "textarea" ),
               textarea( new TextAreaProps()
                           .value( _speechData.getText() )
                           .disabled( _speechData.isSpeaking() )
                           .onChange( e -> _speechData.setText( ( (HTMLTextAreaElement) e.getTarget() ).value ) ) )
          ),
          div( new HtmlProps().className( "speecharg" ),
               label( new LabelProps().htmlFor( "pitch" ), "Pitch" ),
               input( new InputProps().id( "pitch" )
                        .type( InputType.range )
                        .value( String.valueOf( _speechData.getPitch() ) )
                        .min( "0" )
                        .max( "1" )
                        .step( "0.05" )
                        .disabled( _speechData.isSpeaking() )
                        .onChange( e -> _speechData.setPitch( Float.parseFloat( ( (HTMLInputElement) e.getTarget() ).value ) ) ) ),
               button( new BtnProps()
                         .type( ButtonType.button )
                         .prop( "aria-label", Js.asAny( "Reset pitch" ) )
                         .title( "Reset pitch" )
                         .disabled( _speechData.isSpeaking() )
                         .onClick( e -> _speechData.setPitch( DEFAULT_PITCH ) ),
                       "\u21b6" )
          ),
          div( new HtmlProps().className( "speecharg" ),
               label( new LabelProps().htmlFor( "rate" ), "Rate" ),
               input( new InputProps().id( "rate" )
                        .type( InputType.range )
                        .value( String.valueOf( _speechData.getRate() ) )
                        .min( "-3" )
                        .max( "3" )
                        .step( "0.25" )
                        .disabled( _speechData.isSpeaking() )
                        .onChange( e -> _speechData.setRate( Float.parseFloat( ( (HTMLInputElement) e.getTarget() ).value ) ) ) ),
               button( new BtnProps()
                         .type( ButtonType.button )
                         .prop( "aria-label", Js.asAny( "Reset rate" ) )
                         .title( "Reset rate" )
                         .disabled( _speechData.isSpeaking() )
                         .onClick( e -> _speechData.setRate( DEFAULT_RATE ) ),
                       "\u21b6" )
          ),
          div( new HtmlProps().className( "speecharg" ),
               label( new LabelProps().htmlFor( "volume" ), "Volume" ),
               input( new InputProps().id( "volume" )
                        .type( InputType.range )
                        .value( String.valueOf( _speechData.getVolume() ) )
                        .min( "0" )
                        .max( "1" )
                        .step( "0.05" )
                        .disabled( _speechData.isSpeaking() )
                        .onChange( e -> _speechData.setVolume( Float.parseFloat( ( (HTMLInputElement) e.getTarget() ).value ) ) )
               ),
               button( new BtnProps()
                         .type( ButtonType.button )
                         .prop( "aria-label", Js.asAny( "Reset volume" ) )
                         .title( "Reset volume" )
                         .disabled( _speechData.isSpeaking() )
                         .onClick( e -> _speechData.setVolume( DEFAULT_VOLUME ) ),
                       "\u21b6" )
          ),
          div( new HtmlProps().className( "speecharg" ),
               label( new LabelProps().htmlFor( "voice" ), "Voice" ),
               select(
                 new SelectProps()
                   .onChange( this::onVoiceChange )
                   .disabled( _speechData.isSpeaking() )
                   .value( null == voice ? "" : voice.voiceURI() ),
                 _speechData.getVoices().stream().map( this::renderVoiceOption )
               ),
               button( new BtnProps()
                         .type( ButtonType.button )
                         .prop( "aria-label", Js.asAny( "Reset voice" ) )
                         .title( "Reset voice" )
                         .disabled( _speechData.isSpeaking() )
                         .onClick( e -> _speechData.resetVoice() ),
                       "\u21b6" )
          ),
          div( new HtmlProps().className( "bottom" ),
               div( new HtmlProps().className( "widebutton" ),
                    button( new BtnProps()
                              .type( ButtonType.button )
                              .prop( "aria-label", Js.asAny( "Speak" ) )
                              .title( "Speak" )
                              .disabled( _speechData.isSpeaking() )
                              .onClick( e -> _speechData.startSpeaking() ),
                            strong( "Speak it" ) ),
                    button( new BtnProps()
                              .type( ButtonType.button )
                              .prop( "aria-label", Js.asAny( "Interrupt" ) )
                              .title( "Interrupt" )
                              .disabled( !_speechData.isSpeaking() )
                              .onClick( e -> _speechData.restartSpeaking() ),
                            "Interrupt" )
               ),
               button( new BtnProps()
                         .type( ButtonType.button )
                         .className( "small" )
                         .prop( "aria-label", Js.asAny( "Pause/Resume" ) )
                         .title( "Pause/Resume" )
                         .disabled( !_speechData.isSpeaking() )
                         .onClick( e -> _speechData.togglePause() ),
                       img( new ImgProps().src( "img/play_pause.svg" ) ) ),
               button( new BtnProps()
                         .type( ButtonType.button )
                         .className( "small" )
                         .prop( "aria-label", Js.asAny( "Cancel" ) )
                         .title( "Cancel" )
                         .disabled( _speechData.isSpeaking() )
                         .onClick( e -> _speechData.stopSpeaking() ),
                       img( new ImgProps().src( "img/stop.svg" ) ) )
          )
        ),
        div( new HtmlProps().className( "bottom" ) )
      );
  }

  @Nonnull
  private ReactNode renderVoiceOption( @Nonnull final SpeechSynthesisVoice voice )
  {
    return option( new OptionProps().value( voice.voiceURI() ), voice.name() + " (" + voice.lang() + ")" );
  }

  void onVoiceChange( @Nonnull final FormEvent e )
  {
    _speechData.setVoiceByVoiceURI( ( (HTMLSelectElement) e.getTarget() ).value );
  }
}
