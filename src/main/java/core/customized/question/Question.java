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

    public static QuestionTypeWithLocator identifyQuestion(ElementWrapper element) {
        QuestionTypeWithLocator questionSet = new QuestionTypeWithLocator();

        if (new ShortAnswerQuestion(element.getElementXpath() + _locatorShortAnswer).getElement() != null) {
            questionSet.set(QuestionType.SHORT_ANSWER, _locatorShortAnswer);
        } else if (new ParagraphQuestion(element.getElementXpath() + _locatorTextarea).getElement() != null) {
            questionSet.set(QuestionType.PARAGRAPH, _locatorTextarea);
        }

        return questionSet;
    }

    public static List<Question> identifyQuestionList(List<ElementWrapper> elementList) {
        List<Question> questionList = new ArrayList<>();
        QuestionTypeWithLocator questionSet;

        for (ElementWrapper element: elementList) {
            questionSet = identifyQuestion(element);

            questionList.add(
                    QuestionFactory.getSpecificQuestion(questionSet.getQuestionType(), questionSet.getLocator())
            );
        }
        return questionList;
    }
}
