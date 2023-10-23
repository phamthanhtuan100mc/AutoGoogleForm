package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.old.behavior.fill_result.FillResultMultipleChoiceGrid;
import org.openqa.selenium.WebElement;

public class MultipleChoiceGridQuestion extends Question {

    public MultipleChoiceGridQuestion(WebElement element) {
        super(element);
//        setFillResultBehavior(new FillResultMultipleChoiceGrid()); --no longer used
    }

    public MultipleChoiceGridQuestion(String locator, Object... args) {
        super(locator, args);
//        setFillResultBehavior(new FillResultMultipleChoiceGrid()); --no longer used
    }

    @Override
    public void fillResult() {

    }
}
