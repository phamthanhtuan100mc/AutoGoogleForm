package core.customized.question_item;

import core.customized.Question;
import org.openqa.selenium.WebElement;

public class LinearScaleQuestion extends Question {
    public LinearScaleQuestion(String locator) {
        super(locator);
    }

    public LinearScaleQuestion(WebElement element) {
        super(element);
    }
}
