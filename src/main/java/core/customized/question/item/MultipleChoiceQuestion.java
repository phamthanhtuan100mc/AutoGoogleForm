package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.behavior.FillResultMultipleChoice;
import org.openqa.selenium.WebElement;

public class MultipleChoiceQuestion extends Question {

    public MultipleChoiceQuestion(WebElement element) {
        super(element);
        setFillResultBehavior(new FillResultMultipleChoice());
    }

    public MultipleChoiceQuestion(String locator, Object... args) {
        super(locator, args);
        setFillResultBehavior(new FillResultMultipleChoice());
    }
}
