package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.behavior.fill_result.FillResultTime;
import org.openqa.selenium.WebElement;

public class TimeQuestion extends Question {

    /*
     * Need handle AM/PM for english version
     */

    public TimeQuestion(WebElement element) {
        super(element);
        setFillResultBehavior(new FillResultTime());
    }

    public TimeQuestion(String locator, Object... args) {
        super(locator, args);
        setFillResultBehavior(new FillResultTime());
    }
}
