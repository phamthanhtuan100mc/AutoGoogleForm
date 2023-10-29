package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.old.behavior.fill_result.FillResultDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class DateQuestion extends Question {
    private static final Logger logger = LogManager.getLogger(DateQuestion.class);

    public DateQuestion(WebElement element) {
        super(element);
//        setFillResultBehavior(new FillResultDate()); --no longer used
    }

    public DateQuestion(String locator, Object... args) {
        super(locator, args);
//        setFillResultBehavior(new FillResultDate()); --no longer used
    }

    @Override
    public void fillResult() {
        logger.info("Fill result for Date Question");

    }
}
