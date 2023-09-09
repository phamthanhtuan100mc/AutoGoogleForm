package core.customized.question_item;

import core.customized.Question;
import org.openqa.selenium.WebElement;

public class DropdownQuestion extends Question {
    public DropdownQuestion(String locator) {
        super(locator);
    }

    public DropdownQuestion(WebElement element) {
        super(element);
    }
}
