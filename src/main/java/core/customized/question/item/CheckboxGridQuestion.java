package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.old.behavior.fill_result.FillResultCheckboxGrid;
import core.page_object.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class CheckboxGridQuestion extends Question {
    private static final Logger logger = LogManager.getLogger(CheckboxGridQuestion.class);

    public CheckboxGridQuestion(WebElement element) {
        super(element);
//        setFillResultBehavior(new FillResultCheckboxGrid()); --no longer used
    }

    public CheckboxGridQuestion(String locator, Object... args) {
        super(locator, args);
//        setFillResultBehavior(new FillResultCheckboxGrid()); --no longer used
    }

    @Override
    public void fillResult() {
        logger.info("Fill result for Checkbox Grid Question");

    }
}
