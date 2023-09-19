package core.customized.question.item;

import core.customized.question.Question;
import org.openqa.selenium.WebElement;

public class TimeQuestion extends Question {

    public TimeQuestion(WebElement element) {
        super(element);
    }

    public TimeQuestion(String locator, Object... args) {
        super(locator, args);
    }
}
