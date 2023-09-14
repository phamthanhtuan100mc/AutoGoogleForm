package core.customized;

import core.wrapper.ElementWrapper;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class Question extends ElementWrapper {

    private String _locator;
    private WebElement _element;

    public Question(WebElement element) {
        super(element);
    }

    public Question(String locator, Object... args) {
        super(locator, args);
    }

    public void fillAnswer() {

    }
}
