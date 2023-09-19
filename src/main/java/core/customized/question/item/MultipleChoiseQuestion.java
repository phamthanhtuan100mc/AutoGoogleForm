package core.customized.question.item;

import core.customized.question.Question;
import org.openqa.selenium.WebElement;

public class MultipleChoiseQuestion extends Question {

    public MultipleChoiseQuestion(WebElement element) {
        super(element);
    }

    public MultipleChoiseQuestion(String locator, Object... args) {
        super(locator, args);
    }
}
