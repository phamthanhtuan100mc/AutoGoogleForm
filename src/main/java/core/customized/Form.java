package core.customized;

import core.wrappers.ElementWrapper;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Form {

    private String _locator;

    public Form(String locator) {
        this._locator = locator;
    }

    public List<Question> getAllQuestion() {
        List<WebElement> webElementList = new ArrayList<>();
        List<Question> questionList = new ArrayList<>();
        ElementWrapper question = new ElementWrapper(this._locator + "/div[@role='listitem']");
        webElementList = question.getElementList();

        for(WebElement element: webElementList) {
            questionList.add(new Question(element));
        }

        return questionList;
    }
}
