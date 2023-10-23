package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.old.behavior.fill_result.FillResultCheckbox;
import org.openqa.selenium.WebElement;

public class CheckboxQuestion extends Question {

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

    }
}
