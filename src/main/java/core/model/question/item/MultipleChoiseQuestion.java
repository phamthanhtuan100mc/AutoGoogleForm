package core.model.question.item;

import core.model.question.Question;
import org.openqa.selenium.WebElement;

public class MultipleChoiseQuestion extends Question {

    public MultipleChoiseQuestion(WebElement element) {
        super(element);
    }

    public MultipleChoiseQuestion(String locator, Object... args) {
        super(locator, args);
    }
}
