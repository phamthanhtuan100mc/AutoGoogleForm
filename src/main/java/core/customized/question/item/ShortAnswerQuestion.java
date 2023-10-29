package core.customized.question.item;

import core.customized.question.IFillResultBehavior;
import core.customized.question.Question;
import core.customized.question.item.old.behavior.fill_result.FillResultShortAnswer;
import core.page_object.HomePage;
import core.util.common.Constant;
import core.util.helper.DataFakerHandler;
import core.wrapper.element.ElementWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShortAnswerQuestion extends Question {
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    // Locators
    private final String _txtInput = ".//input[@type='text']";

    // Elements
    private ElementWrapper inputTextBox = this.findElement(_txtInput);

    public ShortAnswerQuestion(WebElement element) {
        super(element);
//        setFillResultBehavior(new FillResultShortAnswer()); --no longer used
    }

    public ShortAnswerQuestion(String locator, Object... args) {
        super(locator, args);
//        setFillResultBehavior(new FillResultShortAnswer()); --no longer used
    }

    @Override
    public void fillResult() {
        logger.info("Fill result for Short Answer Question");

        // Randomly create some text
        String randomText = DataFakerHandler.getFaker().lorem().sentence();

        // input random text to input textbox
        logger.info("Input generated text: " + randomText);
        this.fillResult(randomText);
    }

    public void fillResult(String text) {
        this.inputTextBox.enter(text);
    }
}
