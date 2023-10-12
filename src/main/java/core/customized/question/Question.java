package core.customized.question;

import core.customized.question.item.*;
import core.factory.QuestionFactory;
import core.util.Enum.QuestionType;
import core.wrapper.ElementWrapper;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public abstract class Question extends ElementWrapper {

    private boolean requireStatus = false;
    private FillResultBehavior fillResultBehavior;

    private final static String _locatorRadio = "//div[@role='radio']";
    private final static String _locatorLSQ_MCGQ = "/parent::div/parent::div/preceding-sibling::div"; // Linear Scale Question - Multiple Choice Grid Question
    private final static String _locatorCheckboxGrid = "...";
    private final static String _locatorCheckbox = "...";
    private final static String _locatorDate = "//input[@type='date']";
    private final static String _locatorDropdown = "//div[@role='listbox']";
    private final static String _locatorMultipleChoiceGrid = "/parent::div/parent::div/parent::div/parent::div[@aria-hidden=\"true\"]";
    private final static String _locatorParagraph = "//textarea";
    private final static String _locatorShortAnswer = "//input[@type='text']";
    private final static String _locatorRadioGroup = "//div[@role='radiogroup']";

    public Question(WebElement element) {
        super(element);
    }

    public Question(String locator, Object... args) {
        super(locator, args);
    }

    public void setFillResultBehavior(FillResultBehavior behavior) {
        fillResultBehavior = behavior;
    }

    public boolean getRequireStatus() {
        return this.requireStatus;
    }

    public void setRequireStatus(boolean status) {
        this.requireStatus = status;
    }

    public void performFillResult() {
        fillResultBehavior.fillResult();
    }

    public static QuestionType identifyQuestion(ElementWrapper element) {
        QuestionType questionType = QuestionType.NULL;

        if (new ElementWrapper(element.getElementXpath() + _locatorCheckboxGrid).getElement() != null) {
            questionType = QuestionType.CHECKBOX_GRID;

        } else if (new ElementWrapper(element.getElementXpath() + _locatorCheckbox).getElement() != null) {
            questionType = QuestionType.CHECKBOX;

        } else if (new ElementWrapper(element.getElementXpath() + _locatorDate).getElement() != null) {
            questionType = QuestionType.DATE;

        } else if (new ElementWrapper(element.getElementXpath() + _locatorDropdown).getElement() != null) {
            questionType = QuestionType.DROP_DOWN;

        } else if (new ElementWrapper(element.getElementXpath() + _locatorRadio).getElement() != null) {

            if (new ElementWrapper(element.getElementXpath() + _locatorRadio + _locatorLSQ_MCGQ).getElement() != null) {
                if (new ElementWrapper(element.getElementXpath() + _locatorRadio + _locatorMultipleChoiceGrid).getElement() != null) {
                    questionType = QuestionType.MULTIPLE_CHOICE_GRID;
                } else {
                    questionType = QuestionType.LINEAR_SCALE;
                }
            } else {
                questionType = QuestionType.MULTIPLE_CHOICE;
            }

        } else if (new ElementWrapper(element.getElementXpath() + _locatorParagraph).getElement() != null) {
            questionType = QuestionType.PARAGRAPH;

        /* locator contains Xpath = //input[@type='text'] including:
         * Short Answer Question
         * Time Question
         */
        } else if (new ElementWrapper(element.getElementXpath() + _locatorShortAnswer).getElement() != null) {
            int count = new ElementWrapper(element.getElementXpath() + _locatorShortAnswer).getElementList().size();
            if (count == 2) {
                questionType = QuestionType.TIME;
            } else {
                questionType = QuestionType.SHORT_ANSWER;
            }
        }

        // Test
        System.out.println(questionType);
        return questionType;
    }

    public static List<Question> identifyQuestionList(List<ElementWrapper> elementList) {
        List<Question> questionList = new ArrayList<>();
        QuestionType QuestionType;

        for (ElementWrapper element: elementList) {
            QuestionType = identifyQuestion(element);

            questionList.add(
                    QuestionFactory.getSpecificQuestion(QuestionType, element.getElement())
            );
        }
        return questionList;
    }
}
