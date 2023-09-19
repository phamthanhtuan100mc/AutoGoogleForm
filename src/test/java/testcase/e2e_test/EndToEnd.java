package testcase.e2e_test;

import core.model.question.Question;
import core.page_object.HomePage;
import org.testng.annotations.Test;
import testcase.BaseTest;

import java.util.List;

public class EndToEnd extends BaseTest {

    HomePage homePage;

    @Test()
    public void TC_E2E() {
        homePage = new HomePage();

        homePage.openPage();

        List<Question> questionList = homePage.getQuestionList();
        homePage.randomFillAllResult(questionList);

    }
}
