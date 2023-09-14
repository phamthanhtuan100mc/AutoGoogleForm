package core.customized.question_item;

import core.customized.Question;
import org.openqa.selenium.WebElement;

public class TimeQuestion extends Question {

    public TimeQuestion(WebElement element) {
        super(element);
    }

    public TimeQuestion(String locator, Object... args) {
        super(locator, args);
    }
}
