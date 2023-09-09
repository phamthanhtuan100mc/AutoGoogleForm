package core.customized.question_item;

import core.customized.Question;
import org.openqa.selenium.WebElement;

public class CheckboxQuestion extends Question {
    public CheckboxQuestion(String locator) {
        super(locator);
    }

    public CheckboxQuestion(WebElement element) {
        super(element);
    }
}
