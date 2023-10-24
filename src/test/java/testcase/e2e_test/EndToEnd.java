package testcase.e2e_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import core.customized.question.Question;
import core.page_object.HomePage;
import testcase.BaseTest;

import java.util.List;

public class EndToEnd extends BaseTest {

    private static final Logger logger = LogManager.getLogger(EndToEnd.class);
    HomePage homePage;
    List<Question> questionList;

    @Test()
    public void TC_E2E() {
        homePage = new HomePage();

        logger.info("Open google form");
        homePage.openPage();

        logger.info("Get list of question");
        questionList = homePage.getQuestionList();

        logger.info("Random fill answer for all question");
        homePage.randomFillAllResult(questionList);

    }
}
