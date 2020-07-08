package react4j.webspeechdemos;

import javax.annotation.Nonnull;
import jsinterop.base.Js;
import react4j.ReactNode;
import react4j.annotations.Render;
import react4j.annotations.View;
import react4j.dom.proptypes.html.BtnProps;
import react4j.dom.proptypes.html.HtmlProps;
import react4j.dom.proptypes.html.ImgProps;
import react4j.dom.proptypes.html.InputProps;
import react4j.dom.proptypes.html.LabelProps;
import react4j.dom.proptypes.html.attributeTypes.ButtonType;
import react4j.dom.proptypes.html.attributeTypes.InputType;
import static react4j.dom.DOM.*;

@View
abstract class Application
{
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
                        .value( "0.5" )
                        .min( "0" )
                        .max( "1" )
                        .step( "0.05" ) ),
               button( new BtnProps()
                         .type( ButtonType.button )
                         .prop( "aria-label", Js.asAny( "Reset pitch" ) )
                         .title( "Reset pitch" )
                         .onClick( e -> onResetPitchClick() ),
                       "\u21b6" )
          ),
          div( new HtmlProps().className( "speecharg" ),
               label( new LabelProps().htmlFor( "rate" ), "Rate" ),
               input( new InputProps().id( "rate" )
                        .type( InputType.range )
                        .value( "0" )
                        .min( "-3" )
                        .max( "3" )
                        .step( "0.25" ) ),
               button( new BtnProps()
                         .type( ButtonType.button )
                         .prop( "aria-label", Js.asAny( "Reset rate" ) )
                         .title( "Reset rate" )
                         .onClick( e -> onResetRateClick() ),
                       "\u21b6" )
          ),
          div( new HtmlProps().className( "speecharg" ),
               label( new LabelProps().htmlFor( "volume" ), "Volume" ),
               input( new InputProps().id( "volume" )
                        .type( InputType.range )
                        .value( "1" )
                        .min( "0" )
                        .max( "1" )
                        .step( "0.05" ) ),
               button( new BtnProps()
                         .type( ButtonType.button )
                         .prop( "aria-label", Js.asAny( "Reset volume" ) )
                         .title( "Reset volume" )
                         .onClick( e -> onResetVolumeClick() ),
                       "\u21b6" )
          ),
          div( new HtmlProps().className( "speecharg" ),
               label( new LabelProps().htmlFor( "voice" ), "Voice" ),
               select(),
               button( new BtnProps()
                         .type( ButtonType.button )
                         .prop( "aria-label", Js.asAny( "Reset voice" ) )
                         .title( "Reset voice" )
                         .onClick( e -> onResetVoiceClick() ),
                       "\u21b6" )
          ),
          div( new HtmlProps().className( "bottom" ),
               div( new HtmlProps().className( "widebutton" ),
                    button( new BtnProps()
                              .type( ButtonType.button )
                              .prop( "aria-label", Js.asAny( "Speak" ) )
                              .title( "Speak" )
                              .onClick( e -> onSpeakClick() ),
                            strong( "Speak it" ) ),
                    button( new BtnProps()
                              .type( ButtonType.button )
                              .prop( "aria-label", Js.asAny( "Interrupt" ) )
                              .title( "Interrupt" )
                              .onClick( e -> onInterruptClick() ),
                            "Interrupt" )
               ),
               button( new BtnProps()
                         .type( ButtonType.button )
                         .className( "small" )
                         .prop( "aria-label", Js.asAny( "Pause/Resume" ) )
                         .title( "Pause/Resume" )
                         .onClick( e -> onPlayPauseClick() ),
                       img( new ImgProps().src( "img/play_pause.svg" ) ) ),
               button( new BtnProps()
                         .type( ButtonType.button )
                         .className( "small" )
                         .prop( "aria-label", Js.asAny( "Cancel" ) )
                         .title( "Cancel" )
                         .onClick( e -> onCancelClick() ),
                       img( new ImgProps().src( "img/stop.svg" ) ) )
          )
        ),
        div( new HtmlProps().className( "bottom" ) )
      );
  }

  private void onCancelClick()
  {
  }

  private void onPlayPauseClick()
  {
  }

  private void onInterruptClick()
  {
  }

  private void onSpeakClick()
  {
  }

  private void onResetVoiceClick()
  {
  }

  private void onResetVolumeClick()
  {
  }

  private void onResetRateClick()
  {
  }

  private void onResetPitchClick()
  {
  }
}
