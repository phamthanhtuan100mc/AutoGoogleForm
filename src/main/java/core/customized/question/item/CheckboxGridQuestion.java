package core.customized.question.item;

import core.customized.question.Question;
import org.openqa.selenium.WebElement;

public class CheckboxGridQuestion extends Question {
    public CheckboxGridQuestion(WebElement element) {
        super(element);
    }

    public CheckboxGridQuestion(String locator, Object... args) {
        super(locator, args);
    }
}
