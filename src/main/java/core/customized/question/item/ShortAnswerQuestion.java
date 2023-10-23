package core.customized.question.item;

import core.customized.question.IFillResultBehavior;
import core.customized.question.Question;
import core.customized.question.item.old.behavior.fill_result.FillResultShortAnswer;
import core.wrapper.element.ElementWrapper;
import org.openqa.selenium.WebElement;

public class ShortAnswerQuestion extends Question {

    private ElementWrapper txtInput;

    public ShortAnswerQuestion(WebElement element) {
        super(element);
//        setFillResultBehavior(new FillResultShortAnswer()); --no longer used
    }

    public ShortAnswerQuestion(String locator, Object... args) {
        super(locator, args);
//        setFillResultBehavior(new FillResultShortAnswer()); --no longer used
    }

    @Override
    public void fillResult() {

    }
}
