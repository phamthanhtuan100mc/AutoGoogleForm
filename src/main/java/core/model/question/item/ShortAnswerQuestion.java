package core.model.question.item;

import core.model.question.Question;
import core.model.question.item.behavior.FillResultShortAnswer;
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
