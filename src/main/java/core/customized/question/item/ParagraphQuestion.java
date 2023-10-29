package core.customized.question.item;

import core.customized.question.Question;
import core.customized.question.item.old.behavior.fill_result.FillResultParagraph;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class ParagraphQuestion extends Question {
    private static final Logger logger = LogManager.getLogger(ParagraphQuestion.class);

    public ParagraphQuestion(WebElement element) {
        super(element);
//        setFillResultBehavior(new FillResultParagraph()); --no longer used
    }

    public ParagraphQuestion(String locator, Object... args) {
        super(locator, args);
//        setFillResultBehavior(new FillResultParagraph()); --no longer used
    }

    @Override
    public void fillResult() {
        logger.info("Fill result for Paragraph Question");

    }
}
