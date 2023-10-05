package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.behavior.fill_result.FillResultMultipleChoiceGrid;
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
