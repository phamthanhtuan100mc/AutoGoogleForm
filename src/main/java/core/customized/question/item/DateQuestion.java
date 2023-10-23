package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.old.behavior.fill_result.FillResultDate;
import org.openqa.selenium.WebElement;

public class DateQuestion extends Question {

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

    }
}
