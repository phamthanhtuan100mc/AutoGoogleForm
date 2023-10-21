package core.customized;

import core.customized.question.Question;
import core.wrapper.element.ElementWrapper;

import java.util.List;

public class Form {

    private String _locator;

    public Form(String locator) {
        this._locator = locator;
    }

    public List<Question> getAllQuestion() {
        List<ElementWrapper> webElementList;
        List<Question> questionList;

        ElementWrapper question = new ElementWrapper(this._locator + "/div[@role='listitem']");
        webElementList = question.getElementList();

        questionList = Question.identifyQuestionList(webElementList);

        return questionList;
    }
}
