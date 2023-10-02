package core.customized.question;

import core.customized.QuestionTypeWithLocator;
import core.customized.question.item.ParagraphQuestion;
import core.customized.question.item.ShortAnswerQuestion;
import core.factory.QuestionFactory;
import core.util.Enum.QuestionType;
import core.wrapper.ElementWrapper;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Question extends ElementWrapper {

    private final static String _locatorShortAnswer = "//input[@type='text']";
    private final static String _locatorTextarea = "//textarea";
    private FillResultBehavior fillResultBehavior;

    public Question(WebElement element) {
        super(element);
    }

    public Question(String locator, Object... args) {
        super(locator, args);
    }

    public void performFillResult() {
        fillResultBehavior.fillResult();
    }

    public void setFillResultBehavior(FillResultBehavior behavior) {
        fillResultBehavior = behavior;
    }

    public static QuestionType identifyQuestion(ElementWrapper element) {
        QuestionType questionType = QuestionType.NULL;

        // locator contains Xpath = //input[@type='text'] including:
        // Short Answer Question
        // Time Question
        if (new ShortAnswerQuestion(element.getElementXpath() + _locatorShortAnswer).getElement() != null) {
            int count = new ShortAnswerQuestion(element.getElementXpath() + _locatorShortAnswer).getElementList().size();
            if (count == 2) {
                questionType = QuestionType.TIME;
            } else {
                questionType = QuestionType.SHORT_ANSWER;
            }
        } else if (new ParagraphQuestion(element.getElementXpath() + _locatorTextarea).getElement() != null) {
            questionType = QuestionType.PARAGRAPH;
        }

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
