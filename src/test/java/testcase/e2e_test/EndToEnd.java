package testcase.e2e_test;

import core.customized.question.Question;
import core.page_object.HomePage;
import core.wrapper.DriverWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import testcase.BaseTest;

import java.util.List;

public class EndToEnd extends BaseTest {

    private static final Logger log = LogManager.getLogger(EndToEnd.class);
    HomePage homePage;
    List<Question> questionList;
    @Test()
    public void TC_E2E() {
        homePage = new HomePage();

        log.info("Open google form");
        homePage.openPage();

        log.info("Get list of question");
        questionList = homePage.getQuestionList();

        log.info("Random fill answer for all question");
        homePage.randomFillAllResult(questionList);

    }
}
