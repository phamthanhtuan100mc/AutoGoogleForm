package core.model.question.item;

import core.model.question.Question;
import core.model.question.item.behavior.FillResultMultipleChoice;
import org.openqa.selenium.WebElement;

public class MultipleChoiseQuestion extends Question {

    public MultipleChoiseQuestion(WebElement element) {
        super(element);
        setFillResultBehavior(new FillResultMultipleChoice());
    }

    public MultipleChoiseQuestion(String locator, Object... args) {
        super(locator, args);
        setFillResultBehavior(new FillResultMultipleChoice());
    }
}
