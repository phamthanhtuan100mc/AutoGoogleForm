package core.customized.question_item;

import core.customized.Question;
import org.openqa.selenium.WebElement;

public class MultipleChoiceGridQuestion extends Question {
    public MultipleChoiceGridQuestion(String locator) {
        super(locator);
    }

    public MultipleChoiceGridQuestion(WebElement element) {
        super(element);
    }
}
