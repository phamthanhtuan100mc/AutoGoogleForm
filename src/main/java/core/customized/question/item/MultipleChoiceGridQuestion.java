package core.customized.question.item;

import core.customized.question.Question;
import org.openqa.selenium.WebElement;

public class MultipleChoiceGridQuestion extends Question {

    public MultipleChoiceGridQuestion(WebElement element) {
        super(element);
    }

    public MultipleChoiceGridQuestion(String locator, Object... args) {
        super(locator, args);
    }
}