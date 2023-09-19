package core.model.question.item;

import core.model.question.Question;
import org.openqa.selenium.WebElement;

public class DateQuestion extends Question {

    public DateQuestion(WebElement element) {
        super(element);
    }

    public DateQuestion(String locator, Object... args) {
        super(locator, args);
    }
}
