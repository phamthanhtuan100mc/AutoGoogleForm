package core.model.question.item;

import core.model.question.Question;
import org.openqa.selenium.WebElement;

public class ShortAnswerQuestion extends Question {
    public ShortAnswerQuestion(WebElement element) {
        super(element);
    }

    public ShortAnswerQuestion(String locator, Object... args) {
        super(locator, args);
    }

    public void fillAnswer() {

    }
}
