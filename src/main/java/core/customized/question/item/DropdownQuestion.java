package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.old.behavior.fill_result.FillResultDropdown;
import org.openqa.selenium.WebElement;

public class DropdownQuestion extends Question {

    public DropdownQuestion(WebElement element) {
        super(element);
//        setFillResultBehavior(new FillResultDropdown()); --no longer used
    }

    public DropdownQuestion(String locator, Object... args) {
        super(locator, args);
//        setFillResultBehavior(new FillResultDropdown()); --no longer used
    }

    @Override
    public void fillResult() {

    }
}
