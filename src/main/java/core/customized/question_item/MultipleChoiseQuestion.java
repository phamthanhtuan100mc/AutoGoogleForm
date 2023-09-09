package core.customized.question_item;

import core.customized.Question;
import org.openqa.selenium.WebElement;

public class MultipleChoiseQuestion extends Question {
    public MultipleChoiseQuestion(String locator) {
        super(locator);
    }

    public MultipleChoiseQuestion(WebElement element) {
        super(element);
    }
}
