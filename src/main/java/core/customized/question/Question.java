package core.customized.question;

import core.customized.question.item.ParagraphQuestion;
import core.customized.question.item.ShortAnswerQuestion;
import core.factory.QuestionFactory;
import core.util.Enum.QuestionType;
import core.wrapper.ElementWrapper;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        Question question;

        question = new ShortAnswerQuestion(element.getElementXpath() + _locatorShortAnswer);

        if (question.getElement() == null) {
            question = new ParagraphQuestion(element.getElementXpath() + _locatorTextarea);

            if (question.getElement() == null) {
                return QuestionType.NULL;
            } else {
                return QuestionType.PARAGRAPH;
            }
        } else {
            return QuestionType.SHORT_ANSWER;
        }
    }

    public static List<Question> identifyQuestionList(List<ElementWrapper> elementList) {
        List<Question> questionList = new ArrayList<>();
        HashMap<QuestionType, String> questionSet = new HashMap<QuestionType, String>();

        for (ElementWrapper element: elementList) {
            questionList.add(
                    QuestionFactory.getSpecificQuestion(
                            identifyQuestion(element),
                            element.getElementXpath()
                    )
            );
        }
        return questionList;
    }
}
