package core.model.question.item;

import core.model.question.Question;
import org.openqa.selenium.WebElement;

public class MultipleChoiceGridQuestion extends Question {

    public MultipleChoiceGridQuestion(WebElement element) {
        super(element);
    }

    public MultipleChoiceGridQuestion(String locator, Object... args) {
        super(locator, args);
    }
}
