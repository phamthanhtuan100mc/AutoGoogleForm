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

    public static Map<QuestionType, String> identifyQuestion(ElementWrapper element) {
        Map<QuestionType, String> questionSet = new HashMap<>();

        if (new ShortAnswerQuestion(element.getElementXpath() + _locatorShortAnswer).getElement() != null) {
            questionSet.put(QuestionType.SHORT_ANSWER, _locatorShortAnswer);
        } else if (new ParagraphQuestion(element.getElementXpath() + _locatorTextarea).getElement() != null) {
            questionSet.put(QuestionType.PARAGRAPH, _locatorTextarea);
        }

        return questionSet;
    }

    public static List<Question> identifyQuestionList(List<ElementWrapper> elementList) {
        List<Question> questionList = new ArrayList<>();
        Map<QuestionType, String> questionSet;
        QuestionType type;
        String locator;

        for (ElementWrapper element: elementList) {
            questionSet = identifyQuestion(element);
            type = questionSet.keySet().iterator().next();
            locator = questionSet.get(questionSet.keySet().iterator().next());

            questionList.add(
                    QuestionFactory.getSpecificQuestion(type, locator)
            );
        }
        return questionList;
    }
}
