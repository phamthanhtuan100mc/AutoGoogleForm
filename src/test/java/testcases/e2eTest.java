package testcases;

import core.customized.Question;
import core.page_objects.HomePage;
import org.testng.annotations.Test;

import java.util.List;

public class e2eTest extends BaseTest {

    HomePage homePage;

    @Test()
    public void TC_E2E() {
        homePage = new HomePage();

        homePage.openPage();
        List<Question> questionList = homePage.getQuestionList();

    }
}
