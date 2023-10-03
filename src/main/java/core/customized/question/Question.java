package core.customized.question;

import core.customized.question.item.*;
import core.factory.QuestionFactory;
import core.util.Enum.QuestionType;
import core.wrapper.ElementWrapper;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public abstract class Question extends ElementWrapper {

    private final static String _locatorCheckboxGrid = "...";
    private final static String _locatorCheckbox = "...";
    private final static String _locatorDate = "//input[@type='date']";
    private final static String _locatorDropdown = "//div[@role='listbox']";
    private final static String _locatorLinearScale = "...";
    private final static String _locatorMultipleChoiceGrid = "...";
    private final static String _locatorMultipleChoice = "...";
    private final static String _locatorParagraph = "//textarea";
    private final static String _locatorShortAnswer = "//input[@type='text']";
    private FillResultBehavior fillResultBehavior;

    public Question(WebElement element) {
        super(element);
    }

    public Question(String locator, Object... args) {
        super(locator, args);
    }

    public void setFillResultBehavior(FillResultBehavior behavior) {
        fillResultBehavior = behavior;
    }

    public void performFillResult() {
        fillResultBehavior.fillResult();
    }

    public static QuestionType identifyQuestion(ElementWrapper element) {
        QuestionType questionType = QuestionType.NULL;



        if (new CheckboxGridQuestion(element.getElementXpath() + _locatorCheckboxGrid).getElement() != null) {
            questionType = QuestionType.CHECKBOX_GRID;

        } else if (new CheckboxQuestion(element.getElementXpath() + _locatorCheckbox).getElement() != null) {
            questionType = QuestionType.CHECKBOX;

        } else if (new DateQuestion(element.getElementXpath() + _locatorDate).getElement() != null) {
            questionType = QuestionType.DATE;

        } else if (new DropdownQuestion(element.getElementXpath() + _locatorDropdown).getElement() != null) {
            questionType = QuestionType.DROP_DOWN;

        } else if (new LinearScaleQuestion(element.getElementXpath() + _locatorLinearScale).getElement() != null) {
            questionType = QuestionType.LINEAR_SCALE;

        } else if (new MultipleChoiceGridQuestion(element.getElementXpath() + _locatorMultipleChoiceGrid).getElement() != null) {
            questionType = QuestionType.MULTIPLE_CHOICE_GRID;

        } else if (new MultipleChoiceQuestion(element.getElementXpath() + _locatorMultipleChoice).getElement() != null) {
            questionType = QuestionType.MULTIPLE_CHOICE_GRID;

        } else if (new ParagraphQuestion(element.getElementXpath() + _locatorParagraph).getElement() != null) {
            questionType = QuestionType.PARAGRAPH;

        /* locator contains Xpath = //input[@type='text'] including:
         * Short Answer Question
         * Time Question
         */
        } else if (new ShortAnswerQuestion(element.getElementXpath() + _locatorShortAnswer).getElement() != null) {
            int count = new ShortAnswerQuestion(element.getElementXpath() + _locatorShortAnswer).getElementList().size();
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
