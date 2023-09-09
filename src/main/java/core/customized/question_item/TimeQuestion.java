package core.customized.question_item;

import core.customized.Question;
import org.openqa.selenium.WebElement;

public class TimeQuestion extends Question {
    public TimeQuestion(String locator) {
        super(locator);
    }

    public TimeQuestion(WebElement element) {
        super(element);
    }
}
