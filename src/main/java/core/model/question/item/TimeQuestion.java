package core.model.question.item;

import core.model.question.Question;
import core.model.question.item.behavior.FillResultTime;
import org.openqa.selenium.WebElement;

public class TimeQuestion extends Question {

    public TimeQuestion(WebElement element) {
        super(element);
        setFillResultBehavior(new FillResultTime());
    }

    public TimeQuestion(String locator, Object... args) {
        super(locator, args);
        setFillResultBehavior(new FillResultTime());
    }
}
