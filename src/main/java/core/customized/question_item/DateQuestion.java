package core.customized.question_item;

import core.customized.Question;
import org.openqa.selenium.WebElement;

public class DateQuestion extends Question {
    public DateQuestion(String locator) {
        super(locator);
    }

    public DateQuestion(WebElement element) {
        super(element);
    }
}
