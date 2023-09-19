package core.customized.question.item;

import core.customized.question.Question;
import org.openqa.selenium.WebElement;

public class DateQuestion extends Question {

    public DateQuestion(WebElement element) {
        super(element);
    }

    public DateQuestion(String locator, Object... args) {
        super(locator, args);
    }
}
