package core.customized.question_item;

import core.customized.Question;
import org.openqa.selenium.WebElement;

public class ParagraphQuestion extends Question {
    public ParagraphQuestion(String locator) {
        super(locator);
    }

    public ParagraphQuestion(WebElement element) {
        super(element);
    }
}
