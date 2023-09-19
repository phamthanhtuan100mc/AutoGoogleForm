package core.model.question.item;

import core.model.question.Question;
import core.model.question.item.behavior.FillResultLinearScale;
import org.openqa.selenium.WebElement;

public class LinearScaleQuestion extends Question {

    public LinearScaleQuestion(WebElement element) {
        super(element);
        setFillResultBehavior(new FillResultLinearScale());
    }

    public LinearScaleQuestion(String locator, Object... args) {
        super(locator, args);
        setFillResultBehavior(new FillResultLinearScale());
    }
}
