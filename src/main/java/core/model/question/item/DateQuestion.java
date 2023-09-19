package core.model.question.item;

import core.model.question.Question;
import core.model.question.item.behavior.FillResultDate;
import org.openqa.selenium.WebElement;

public class DateQuestion extends Question {

    public DateQuestion(WebElement element) {
        super(element);
        setFillResultBehavior(new FillResultDate());
    }

    public DateQuestion(String locator, Object... args) {
        super(locator, args);
        setFillResultBehavior(new FillResultDate());
    }
}
