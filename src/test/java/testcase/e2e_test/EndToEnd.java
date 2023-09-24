package testcase.e2e_test;

import core.customized.question.Question;
import core.page_object.HomePage;
import core.util.Log;
import org.testng.annotations.Test;
import testcase.BaseTest;

import java.util.List;

public class EndToEnd extends BaseTest {

    HomePage homePage;
    List<Question> questionList;
    @Test()
    public void TC_E2E() {
        homePage = new HomePage();

        Log.INFO("Open google form");
        homePage.openPage();

        Log.INFO("Get list of question");
        questionList = homePage.getQuestionList();

        Log.INFO("Random fill answer for all question");
        homePage.randomFillAllResult(questionList);

    }
}
