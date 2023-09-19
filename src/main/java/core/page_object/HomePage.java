package core.page_object;

import core.customized.Form;
import core.customized.Question;
import core.factory.QuestionFactory;

import java.util.List;

public class HomePage extends BasePage {

    // Locators



    // Web Elements
    private Form formList = new Form(this._formList);

    // Methods

    public List<Question> getQuestionList() {
        return formList.getAllQuestion();
    }

    public void randomFillResult(List<Question> questionList) {
        for (Question question: questionList) {
            if (question != null) {

            }
        }
    }

}
