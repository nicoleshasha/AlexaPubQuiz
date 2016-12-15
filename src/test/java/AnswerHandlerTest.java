// package triviasmack;
//
// import org.junit.Test;
// import java.util.ArrayList;
// import java.lang.Object;
// import java.lang.String;
// import static org.junit.Assert.*;
// import static org.mockito.Mockito.*;
// import org.mockito.Mock;
// import org.junit.Before;
// import org.mockito.MockitoAnnotations;
//
// import static org.hamcrest.CoreMatchers.*;
//
// public class AnswerHandlerTest {
//
//   @Before
//   public void init() {
//     MockitoAnnotations.initMocks(this);
//   }
//
//   @Mock AnswerHandler answerhandlermock = spy(new AnswerHandler());
//   @Mock QuestionHash questionmock = new QuestionHash();
//   @Mock String mockquestion = ("What is the capital of England?");
//   @Mock String mockanswer = ("London");
//
// //   @Test
// //   public void testSetQuestion() {
// //     questionmock.getQuestionArray();
// //     when(questionmock.randomQuestion()).thenReturn(mockquestion);
// //     questionmock.randomQuestion();
// //     answermock.setQuestion();
// //     String result = "<speak>What is the capital of England?<break time='50ms'/> 10<break time='50ms'/> 9<break time='50ms'/> 8<break time='50ms'/> 7<break time='50ms'/> 6<break time='50ms'/> 5<break time='50ms'/> 4<break time='50ms'/> 3<break time='50ms'/> 2<break time='50ms'/> 1<break time='50ms'/> TIME'S UP!</speak>";
// //     assertEquals("<speak>What is the capital of England?<break time='50ms'/> 10<break time='50ms'/> 9<break time='50ms'/> 8<break time='50ms'/> 7<break time='50ms'/> 6<break time='50ms'/> 5<break time='50ms'/> 4<break time='50ms'/> 3<break time='50ms'/> 2<break time='50ms'/> 1<break time='50ms'/> TIME'S UP!</speak>", result);
// //   }
// // }
//
//
// // // code for testing
// // // ------------------
// // public String checkIfCorrect(final String answer, String teamOneName, String teamTwoName, String teamOneScore, String teamTwoScore, String currentTeamAttribute) {
// //   randomAnswer = questionHash.getAnswer(chosenQuestion);
// //   String correctAnswer = randomAnswer.toLowerCase();
// //   String answerText = teamOneName + " has " + teamOneScore +". "+ teamTwoName + " has " + teamTwoScore+ ". " + currentTeamAttribute+ " is up next.";
// //   if (answer.equals(correctAnswer)) {
// //         return "The answer is " + randomAnswer + ". You are correct! " + answerText;
// //        } else {
// //         return "The answer is " + randomAnswer + ". You are incorrect! " + answerText;
// //     }
// // }
// // // -------------------
// //
