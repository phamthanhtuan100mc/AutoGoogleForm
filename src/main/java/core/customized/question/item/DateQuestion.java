package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.behavior.fill_result.FillResultDate;
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
