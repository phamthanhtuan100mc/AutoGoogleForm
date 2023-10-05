package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.behavior.fill_result.FillResultLinearScale;
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
