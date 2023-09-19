package core.model.question.item;

import core.model.question.Question;
import org.openqa.selenium.WebElement;

public class CheckboxQuestion extends Question {


    public CheckboxQuestion(WebElement element) {
        super(element);
    }

    public CheckboxQuestion(String locator, Object... args) {
        super(locator, args);
    }
}
