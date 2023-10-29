package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.old.behavior.fill_result.FillResultMultipleChoiceGrid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class MultipleChoiceGridQuestion extends Question {
    private static final Logger logger = LogManager.getLogger(MultipleChoiceGridQuestion.class);

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
        logger.info("Fill result for Multiple Choice Grid Question");

    }
}
