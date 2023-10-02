package core.page_object;

import core.customized.Form;
import core.customized.question.Question;

import java.util.List;

public class HomePage extends BasePage {

    // Locators



    // Web Elements
    private Form formList = new Form(this._formList);

    // Methods
    public List<Question> getQuestionList() {
        return formList.getAllQuestion();
    }

    public void randomFillAllResult(List<Question> questionList) {
        for (Question question: questionList) {
            if (question != null) {
                ramdomFillResult(question);
            }
        }
    }

    public void ramdomFillResult(Question question) {
        question.performFillResult();
    }

}
