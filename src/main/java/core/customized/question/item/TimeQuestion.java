package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.old.behavior.fill_result.FillResultTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class TimeQuestion extends Question {
    private static final Logger logger = LogManager.getLogger(TimeQuestion.class);

    /*
     * Need to handle AM/PM select for english version
     */

    public TimeQuestion(WebElement element) {
        super(element);
//        setFillResultBehavior(new FillResultTime()); --no longer used
    }

    public TimeQuestion(String locator, Object... args) {
        super(locator, args);
//        setFillResultBehavior(new FillResultTime()); --no longer used
    }

    @Override
    public void fillResult() {
        logger.info("Fill result for Time Question");

    }
}
