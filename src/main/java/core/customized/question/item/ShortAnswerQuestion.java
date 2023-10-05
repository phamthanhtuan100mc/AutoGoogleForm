package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.behavior.fill_result.FillResultShortAnswer;
import org.openqa.selenium.WebElement;

public class ShortAnswerQuestion extends Question {
    public ShortAnswerQuestion(WebElement element) {
        super(element);
        setFillResultBehavior(new FillResultShortAnswer());
    }

    public ShortAnswerQuestion(String locator, Object... args) {
        super(locator, args);
        setFillResultBehavior(new FillResultShortAnswer());
    }

}
