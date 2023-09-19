package core.model.question.item;

import core.model.question.Question;
import core.model.question.item.behavior.FillResultDropdown;
import org.openqa.selenium.WebElement;

public class DropdownQuestion extends Question {

    public DropdownQuestion(WebElement element) {
        super(element);
        setFillResultBehavior(new FillResultDropdown());
    }

    public DropdownQuestion(String locator, Object... args) {
        super(locator, args);
        setFillResultBehavior(new FillResultDropdown());
    }
}
