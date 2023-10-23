package core.customized.question;

import core.util.enums.QuestionType;
import core.wrapper.element.ElementWrapper;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public abstract class Question extends ElementWrapper implements IFillResultBehavior {

    private boolean requireStatus = false;
//    private IFillResultBehavior fillResultBehavior; --no longer used

    private final static String _locatorRadio = "//div[@role='radio']";
    private final static String _locatorLSQ_MCGQ = "/parent::div/parent::div/preceding-sibling::div"; // Linear Scale Question - Multiple Choice Grid Question
    private final static String _locatorCheckboxGrid = "/parent::div/parent::div/parent::div[@aria-hidden='true']";
    private final static String _locatorCheckboxGroup = "//div[@role='checkbox']";
    private final static String _locatorDate = "//input[@type='date']";
    private final static String _locatorDropdown = "//div[@role='listbox']";
    private final static String _locatorMultipleChoiceGrid = "/parent::div/parent::div/parent::div/parent::div[@aria-hidden='true']";
    private final static String _locatorParagraph = "//textarea";
    private final static String _locatorShortAnswer = "//input[@type='text']";
    private final static String _locatorRequireStatus = "//span[text()=' *']";

    public Question(WebElement element) {
        super(element);
    }

    public Question(String locator, Object... args) {
        super(locator, args);
        identifyRequireStatus();
    }

//    public void setFillResultBehavior(IFillResultBehavior behavior) {
//        fillResultBehavior = behavior;
//    } --no longer used

    public boolean getRequireStatus() {
        return this.requireStatus;
    }

    public void setRequireStatus(boolean status) {
        this.requireStatus = status;
    }

//    public void performFillResult() {
//        fillResultBehavior.fillResult();
//    } --no longer used

    public void identifyRequireStatus() {
        // Need to be clarified why there is are 2 if
//        if (this.findElement(By.xpath(_locatorRequireStatus)).getSize() != null) {
//            requireStatus = true;
//        }
        if (new ElementWrapper(this.getElementXpath() + _locatorRequireStatus).getElement() != null) {
            requireStatus = true;
        }
    }

    public static QuestionType identifyQuestion(ElementWrapper element) {
        QuestionType questionType = QuestionType.NULL;

        if (new ElementWrapper(element.getElementXpath() + _locatorCheckboxGroup).getElement() != null) {
            if (new ElementWrapper(element.getElementXpath() + _locatorCheckboxGroup + _locatorCheckboxGrid).getElement() != null) {
                questionType = QuestionType.CHECKBOX_GRID;
            } else {
                questionType = QuestionType.CHECKBOX;
            }

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
                    QuestionFactory.getSpecificQuestion(QuestionType, element.getElementXpath())
            );
        }
        return questionList;
    }
}
