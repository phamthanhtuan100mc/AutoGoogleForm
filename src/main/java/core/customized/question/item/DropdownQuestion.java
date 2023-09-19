package core.customized.question.item;

import core.customized.question.Question;
import org.openqa.selenium.WebElement;

public class DropdownQuestion extends Question {

    public DropdownQuestion(WebElement element) {
        super(element);
    }

    public DropdownQuestion(String locator, Object... args) {
        super(locator, args);
    }
}
