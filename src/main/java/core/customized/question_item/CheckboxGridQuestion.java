package core.customized.question_item;

import core.customized.Question;
import org.openqa.selenium.WebElement;

public class CheckboxGridQuestion extends Question {
    public CheckboxGridQuestion(String locator) {
        super(locator);
    }

    public CheckboxGridQuestion(WebElement element) {
        super(element);
    }
}
