package core.customized.question_item;

import core.customized.Question;
import org.openqa.selenium.WebElement;

public class ShortAnswerQuestion extends Question {
    public ShortAnswerQuestion(String locator) {
        super(locator);
    }

    public ShortAnswerQuestion(WebElement element) {
        super(element);
    }

    public void fillAnswer() {

    }
}
