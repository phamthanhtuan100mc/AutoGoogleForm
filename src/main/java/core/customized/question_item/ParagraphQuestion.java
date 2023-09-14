package core.customized.question_item;

import core.customized.Question;
import org.openqa.selenium.WebElement;

public class ParagraphQuestion extends Question {

    public ParagraphQuestion(WebElement element) {
        super(element);
    }

    public ParagraphQuestion(String locator, Object... args) {
        super(locator, args);
    }
}
