package core.customized.question;

import core.customized.question.item.*;
import core.util.enums.QuestionType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class QuestionFactory {
    private static final Logger log = LogManager.getLogger(QuestionFactory.class);
    private static Question question = null;

    public static Question getSpecificQuestion(QuestionType type, WebElement element) {
        try {
            switch (type) {
                case CHECKBOX:
                    question = new CheckboxQuestion(element);
                    break;
                case DATE:
                    question = new DateQuestion(element);
                    break;
                case CHECKBOX_GRID:
                    question = new CheckboxGridQuestion(element);
                    break;
                case DROP_DOWN:
                    question = new DropdownQuestion(element);
                    break;
                case LINEAR_SCALE:
                    question = new LinearScaleQuestion(element);
                    break;
                case MULTIPLE_CHOICE:
                    question = new MultipleChoiceQuestion(element);
                    break;
                case MULTIPLE_CHOICE_GRID:
                    question = new MultipleChoiceGridQuestion(element);
                    break;
                case PARAGRAPH:
                    question = new ParagraphQuestion(element);
                    break;
                case SHORT_ANSWER:
                    question = new ShortAnswerQuestion(element);
                    break;
                case TIME:
                    question = new TimeQuestion(element);
                    break;
                default:
                    question = null;
            }
        } catch (NullPointerException npe) {
            log.error(npe.getMessage());
        }

        return question;
    }

    public static Question getSpecificQuestion(QuestionType type, String locator, Object... args) {
        try {
            switch (type) {
                case CHECKBOX:
                    question = new CheckboxQuestion(locator, args);
                    break;
                case DATE:
                    question = new DateQuestion(locator, args);
                    break;
                case CHECKBOX_GRID:
                    question = new CheckboxGridQuestion(locator, args);
                    break;
                case DROP_DOWN:
                    question = new DropdownQuestion(locator, args);
                    break;
                case LINEAR_SCALE:
                    question = new LinearScaleQuestion(locator, args);
                    break;
                case MULTIPLE_CHOICE:
                    question = new MultipleChoiceQuestion(locator, args);
                    break;
                case MULTIPLE_CHOICE_GRID:
                    question = new MultipleChoiceGridQuestion(locator, args);
                    break;
                case PARAGRAPH:
                    question = new ParagraphQuestion(locator, args);
                    break;
                case SHORT_ANSWER:
                    question = new ShortAnswerQuestion(locator, args);
                    break;
                case TIME:
                    question = new TimeQuestion(locator, args);
                    break;
            }
        } catch (NullPointerException npe) {
            log.error(npe.getMessage());
        }

        return question;
    }

}
