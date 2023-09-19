package core.model.question.item;

import core.model.question.Question;
import core.model.question.item.behavior.FillResultMultipleChoiceGrid;
import org.openqa.selenium.WebElement;

public class MultipleChoiceGridQuestion extends Question {

    public MultipleChoiceGridQuestion(WebElement element) {
        super(element);
        setFillResultBehavior(new FillResultMultipleChoiceGrid());
    }

    public MultipleChoiceGridQuestion(String locator, Object... args) {
        super(locator, args);
        setFillResultBehavior(new FillResultMultipleChoiceGrid());
    }
}
