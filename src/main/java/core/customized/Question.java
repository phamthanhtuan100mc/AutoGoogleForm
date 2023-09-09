package core.customized;

import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class Question {

    private String _locator;
    private WebElement _element;

    public Question(String locator) {
        this._locator = locator;
    }

    public Question(WebElement element) {
        this._element = element;
    }

    public void fillAnswer() {

    }
}
