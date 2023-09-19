package core.model.question.item;

import core.model.question.Question;
import org.openqa.selenium.WebElement;

public class ParagraphQuestion extends Question {

    public ParagraphQuestion(WebElement element) {
        super(element);
    }

    public ParagraphQuestion(String locator, Object... args) {
        super(locator, args);
    }
}
