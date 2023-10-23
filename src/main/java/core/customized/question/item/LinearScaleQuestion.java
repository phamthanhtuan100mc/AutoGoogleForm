package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.old.behavior.fill_result.FillResultLinearScale;
import org.openqa.selenium.WebElement;

public class LinearScaleQuestion extends Question {

    public LinearScaleQuestion(WebElement element) {
        super(element);
//        setFillResultBehavior(new FillResultLinearScale()); --no longer used
    }

    public LinearScaleQuestion(String locator, Object... args) {
        super(locator, args);
//        setFillResultBehavior(new FillResultLinearScale()); --no longer used
    }

    @Override
    public void fillResult() {

    }
}
