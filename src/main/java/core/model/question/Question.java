package core.model.question;

import core.model.question.item.ParagraphQuestion;
import core.model.question.item.ShortAnswerQuestion;
import core.wrapper.ElementWrapper;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public abstract class Question extends ElementWrapper {

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
        this.fillResultBehavior = behavior;
    }

    public static Question identifyQuestion(ElementWrapper element) {
        Question question;
        long noTimeout = 0;

        question = new ShortAnswerQuestion(element.getElementXpath() + "//error");

        if (!question.isDisplayed(noTimeout)) {
            question = new ParagraphQuestion(element.getElementXpath() + "//textarea");

            if (!question.isDisplayed(noTimeout)) {
                question = null;
            }
        }
        return question;
    }

    public static List<Question> identifyQuestionList(List<ElementWrapper> elementList) {
        List<Question> questionList = new ArrayList<>();
        for (ElementWrapper element: elementList) {
            questionList.add(identifyQuestion(element));
        }
        return questionList;
    }
}
