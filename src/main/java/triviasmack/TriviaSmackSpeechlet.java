
package triviasmack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.SsmlOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

public class TriviaSmackSpeechlet implements Speechlet {
    private static final Logger log = LoggerFactory.getLogger(TriviaSmackSpeechlet.class);

    @Override
    public void onSessionStarted(final SessionStartedRequest request, final Session session)
            throws SpeechletException {
        log.info("onSessionStarted requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
    }

    @Override
    public SpeechletResponse onLaunch(final LaunchRequest request, final Session session)
            throws SpeechletException {
        log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
        return getWelcomeResponse();
    }

    @Override
    public SpeechletResponse onIntent(final IntentRequest request, final Session session)
            throws SpeechletException {
        log.info("onIntent requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());

        Intent intent = request.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;

        if ("TriviaSmackIntent".equals(intentName)) {
            return getQuizResponse(session);
        } else if ("AMAZON.HelpIntent".equals(intentName)) {
            return getHelpResponse();
        } else if ("AMAZON.RepeatIntent".equals(intentName)) {
            return getRepeatResponse(intent, session);
        } else {
            throw new SpeechletException("Invalid Intent");
        }
    }

    @Override
    public void onSessionEnded(final SessionEndedRequest request, final Session session)
            throws SpeechletException {
        log.info("onSessionEnded requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
    }

    public String concatenate(String one, String two){
      return one + two;
    }

    private SpeechletResponse getWelcomeResponse() {
        String speechText = "Welcome to Trivia Smack, your gateway quiz!";


        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt);
    }


    /**
     * Creates a {@code SpeechletResponse} for the hello intent.
     *
     * @return SpeechletResponse spoken and visual response for the given intent
     */

     private SpeechletResponse getQuizResponse(final Session session) {
       SsmlOutputSpeech speech = new SsmlOutputSpeech();
       speech.setSsml("<speak>What is the capital of the UK?<break time='50ms'/> 10<break time='50ms'/> 9<break time='50ms'/> 8<break time='50ms'/> 7<break time='50ms'/> 6<break time='50ms'/> 5<break time='50ms'/> 4<break time='50ms'/> 3<break time='50ms'/> 2<break time='50ms'/> 1<break time='50ms'/> TIME'S UP! <break time='50ms'/> The answer is London</speak>");

       session.setAttribute("question", speech);

       Reprompt reprompt = new Reprompt();
       reprompt.setOutputSpeech(speech);

       return SpeechletResponse.newAskResponse(speech, reprompt);
   }

    private SpeechletResponse getRepeatResponse(Intent intent, Session session) {
      System.out.println("TEST TEST TEST");
    //  SsmlOutputSpeech speech = new SsmlOutputSpeech();
    //  speech.setSsml("<speak>What is the capital of the UK?<break time='50ms'/> 10<break time='50ms'/> 9<break time='50ms'/> 8<break time='50ms'/> 7<break time='50ms'/> 6<break time='50ms'/> 5<break time='50ms'/> 4<break time='50ms'/> 3<break time='50ms'/> 2<break time='50ms'/> 1<break time='50ms'/> TIME'S UP! <break time='50ms'/> The answer is London</speak>");
    //
    //  SsmlOutputSpeech speech = new SsmlOutputSpeech();
    //  speech.setSsml(session);
     SsmlOutputSpeech speech = (SsmlOutputSpeech) session.getAttribute("question");

     Reprompt reprompt = new Reprompt();
     reprompt.setOutputSpeech(speech);

     return SpeechletResponse.newAskResponse(speech, reprompt);
 }

    private SpeechletResponse getHelpResponse() {
        String speechText = "You can ask me to start a quiz!";


        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt);
    }
}
