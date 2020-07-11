package react4j.webspeechdemo;

import arez.annotations.CascadeDispose;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLSelectElement;
import elemental3.SpeechSynthesisVoice;
import javax.annotation.Nonnull;
import jsinterop.base.Js;
import react4j.ReactNode;
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
import react4j.dom.proptypes.html.attributeTypes.ButtonType;
import react4j.dom.proptypes.html.attributeTypes.InputType;
import static react4j.dom.DOM.*;

@View( type = View.Type.TRACKING )
abstract class Application
{
  private static final double DEFAULT_PITCH = 0.5;
  private static final double DEFAULT_RATE = 0.0;
  private static final double DEFAULT_VOLUME = 1.0;
  @CascadeDispose
  final SpeechData _speechData = SpeechData.create( DEFAULT_PITCH, DEFAULT_RATE, DEFAULT_VOLUME );

  @Nonnull
  @Render
  ReactNode render()
  {
    return
      fragment(
        h1( "Web Speech Synthesis Demo" ),
        form(
          div( new HtmlProps().id( "textarea" ),
               textarea( "Call me Ishmael. Some years ago—never mind how long precisely—having " +
                         "little or no money in my purse, and nothing particular to interest me on shore, I thought " +
                         "I would sail about a little and see the watery part of the world." )
          ),
          div( new HtmlProps().className( "speecharg" ),
               label( new LabelProps().htmlFor( "pitch" ), "Pitch" ),
               input( new InputProps().id( "pitch" )
                        .type( InputType.range )
                        .value( String.valueOf( _speechData.getPitch() ) )
                        .min( "0" )
                        .max( "1" )
                        .step( "0.05" )
                        .onChange( e -> _speechData.setPitch( Double.parseDouble( ( (HTMLInputElement) e.getTarget() ).value ) ) ) ),
               button( new BtnProps()
                         .type( ButtonType.button )
                         .prop( "aria-label", Js.asAny( "Reset pitch" ) )
                         .title( "Reset pitch" )
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
                        .onChange( e -> _speechData.setRate( Double.parseDouble( ( (HTMLInputElement) e.getTarget() ).value ) ) ) ),
               button( new BtnProps()
                         .type( ButtonType.button )
                         .prop( "aria-label", Js.asAny( "Reset rate" ) )
                         .title( "Reset rate" )
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
                        .onChange( e -> _speechData.setVolume( Double.parseDouble( ( (HTMLInputElement) e.getTarget() ).value ) ) )
               ),
               button( new BtnProps()
                         .type( ButtonType.button )
                         .prop( "aria-label", Js.asAny( "Reset volume" ) )
                         .title( "Reset volume" )
                         .onClick( e -> _speechData.setVolume( DEFAULT_VOLUME ) ),
                       "\u21b6" )
          ),
          div( new HtmlProps().className( "speecharg" ),
               label( new LabelProps().htmlFor( "voice" ), "Voice" ),
               select(
                 new SelectProps().onChange( this::onVoiceChange ),
                 _speechData.getVoices().stream().map( this::renderVoiceOption )
               ),
               button( new BtnProps()
                         .type( ButtonType.button )
                         .prop( "aria-label", Js.asAny( "Reset voice" ) )
                         .title( "Reset voice" )
                         .onClick( e -> _speechData.resetVoice() ),
                       "\u21b6" )
          ),
          div( new HtmlProps().className( "bottom" ),
               div( new HtmlProps().className( "widebutton" ),
                    button( new BtnProps()
                              .type( ButtonType.button )
                              .prop( "aria-label", Js.asAny( "Speak" ) )
                              .title( "Speak" )
                              .onClick( e -> _speechData.startSpeaking() ),
                            strong( "Speak it" ) ),
                    button( new BtnProps()
                              .type( ButtonType.button )
                              .prop( "aria-label", Js.asAny( "Interrupt" ) )
                              .title( "Interrupt" )
                              .onClick( e -> _speechData.restartSpeaking() ),
                            "Interrupt" )
               ),
               button( new BtnProps()
                         .type( ButtonType.button )
                         .className( "small" )
                         .prop( "aria-label", Js.asAny( "Pause/Resume" ) )
                         .title( "Pause/Resume" )
                         .onClick( e -> _speechData.togglePause() ),
                       img( new ImgProps().src( "img/play_pause.svg" ) ) ),
               button( new BtnProps()
                         .type( ButtonType.button )
                         .className( "small" )
                         .prop( "aria-label", Js.asAny( "Cancel" ) )
                         .title( "Cancel" )
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
    final SpeechSynthesisVoice currentVoice = _speechData.getVoice();
    return option( new OptionProps()
                     .value( voice.voiceURI() )
                     .selected( ( null == currentVoice && voice._default() ) || currentVoice == voice ),
                   voice.name() + " (" + voice.lang() + ")" );
  }

  void onVoiceChange( @Nonnull final FormEvent e )
  {
    _speechData.setVoiceByVoiceURI( ( (HTMLSelectElement) e.getTarget() ).value );
  }
}
