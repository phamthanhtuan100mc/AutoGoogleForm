package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.old.behavior.fill_result.FillResultCheckbox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class CheckboxQuestion extends Question {
    private static final Logger logger = LogManager.getLogger(CheckboxQuestion.class);

    public CheckboxQuestion(WebElement element) {
        super(element);
//        setFillResultBehavior(new FillResultCheckbox()); --no longer used
    }

    public CheckboxQuestion(String locator, Object... args) {
        super(locator, args);
//        setFillResultBehavior(new FillResultCheckbox()); --no longer used
    }

    @Override
    public void fillResult() {
        logger.info("Fill result for Checkbox Question");

    }
}
