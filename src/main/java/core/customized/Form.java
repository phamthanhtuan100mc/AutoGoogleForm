package core.customized;

import core.customized.question_item.TimeQuestion;
import core.wrapper.ElementWrapper;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
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
