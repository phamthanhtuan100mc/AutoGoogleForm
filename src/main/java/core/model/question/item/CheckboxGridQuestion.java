package core.model.question.item;

import core.model.question.Question;
import core.model.question.item.behavior.FillResultCheckboxGrid;
import org.openqa.selenium.WebElement;

public class CheckboxGridQuestion extends Question {
    public CheckboxGridQuestion(WebElement element) {
        super(element);
        setFillResultBehavior(new FillResultCheckboxGrid());
    }

    public CheckboxGridQuestion(String locator, Object... args) {
        super(locator, args);
        setFillResultBehavior(new FillResultCheckboxGrid());
    }
}
