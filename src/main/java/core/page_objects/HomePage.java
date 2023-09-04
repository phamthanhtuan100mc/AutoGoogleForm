package core.page_objects;

import core.customized.Form;
import core.customized.Question;

import java.util.List;

public class HomePage extends BasePage {

    // Locators



    // Web Elements
    private Form formList = new Form(this._formList);

    // Methods

    public List<Question> getQuestionList() {
        List<Question> questionList = null;
        questionList = formList.getAllQuestion();
        return questionList;
    }

    public void randomFillResult() {
        
    }

}
