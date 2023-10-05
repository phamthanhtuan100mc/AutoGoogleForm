package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.behavior.fill_result.FillResultDropdown;
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
