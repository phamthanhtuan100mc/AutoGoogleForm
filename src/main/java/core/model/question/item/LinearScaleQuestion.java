package core.model.question.item;

import core.model.question.Question;
import org.openqa.selenium.WebElement;

public class LinearScaleQuestion extends Question {

    public LinearScaleQuestion(WebElement element) {
        super(element);
    }

    public LinearScaleQuestion(String locator, Object... args) {
        super(locator, args);
    }
}
