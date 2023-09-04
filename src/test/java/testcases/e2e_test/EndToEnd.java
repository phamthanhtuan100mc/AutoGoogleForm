package testcases.e2e_test;

import core.customized.Question;
import core.page_objects.HomePage;
import org.testng.annotations.Test;
import testcases.BaseTest;

import java.util.List;

public class EndToEnd extends BaseTest {

    HomePage homePage;

    @Test()
    public void TC_E2E() {
        homePage = new HomePage();

        homePage.openPage();
        List<Question> questionList = homePage.getQuestionList();
        homePage.randomFillResult();

    }
}
