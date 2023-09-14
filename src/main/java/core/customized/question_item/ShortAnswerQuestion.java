package core.customized.question_item;

import core.customized.Question;
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
