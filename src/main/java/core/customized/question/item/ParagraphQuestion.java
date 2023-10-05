package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.behavior.fill_result.FillResultParagraph;
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
