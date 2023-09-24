package core.factory;

import core.customized.question.Question;
import core.customized.question.item.*;
import core.util.Enum.QuestionType;
import core.util.Log;
import org.openqa.selenium.WebElement;

public class QuestionFactory {
    public static Question getSpecificQuestion(QuestionType type, WebElement element) {

        Question question;
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
                question = new MultipleChoiseQuestion(element);
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

        return question;
    }

    public static Question getSpecificQuestion(QuestionType type, String locator, Object... args) {

        Question question = null;
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
                    question = new MultipleChoiseQuestion(locator, args);
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
                default:
                    question = null;
            }
        } catch (NullPointerException npe) {
            Log.ERROR(npe);
        }

        return question;
    }

}
