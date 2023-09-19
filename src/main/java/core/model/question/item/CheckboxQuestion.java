package core.model.question.item;

import core.model.question.Question;
import core.model.question.item.behavior.FillResultCheckbox;
import org.openqa.selenium.WebElement;

public class CheckboxQuestion extends Question {


    public CheckboxQuestion(WebElement element) {
        super(element);
        setFillResultBehavior(new FillResultCheckbox());
    }

    public CheckboxQuestion(String locator, Object... args) {
        super(locator, args);
        setFillResultBehavior(new FillResultCheckbox());
    }
}
