package core.model.question.item;

import core.model.question.Question;
import org.openqa.selenium.WebElement;

public class CheckboxGridQuestion extends Question {
    public CheckboxGridQuestion(WebElement element) {
        super(element);
    }

    public CheckboxGridQuestion(String locator, Object... args) {
        super(locator, args);
    }
}
