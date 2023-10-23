package core.page_object;

import core.customized.Form;
import core.customized.question.Question;
import core.wrapper.driver.DriverWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class HomePage extends BasePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    // Locators



    // Web Elements
    private Form formList = new Form(this._formList);

    // Methods
    public List<Question> getQuestionList() {
        return formList.getAllQuestion();
    }

    public void randomFillAllResult(List<Question> questionList) {
        logger.info("Automatic fill result for all question");
        for (Question question: questionList) {
            if (question != null) {
                question.scrollIntoView();
                ramdomFillResult(question);
            }
        }
    }

    public void ramdomFillResult(Question question) {
//        question.performFillResult(); --no longer used
    }

}
