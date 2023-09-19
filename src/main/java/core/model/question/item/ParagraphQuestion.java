package core.model.question.item;

import core.model.question.Question;
import core.model.question.item.behavior.FillResultParagraph;
import org.openqa.selenium.WebElement;

public class ParagraphQuestion extends Question {

    public ParagraphQuestion(WebElement element) {
        super(element);
        setFillResultBehavior(new FillResultParagraph());
    }

    public ParagraphQuestion(String locator, Object... args) {
        super(locator, args);
        setFillResultBehavior(new FillResultParagraph());
    }
}
