package core.customized;

import core.customized.question_item.ParagraphQuestion;
import core.customized.question_item.ShortAnswerQuestion;
import core.wrapper.ElementWrapper;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public abstract class Question extends ElementWrapper {

    private String _locator;
    private WebElement _element;

    public Question(WebElement element) {
        super(element);
    }

    public Question(String locator, Object... args) {
        super(locator, args);
    }

    public void fillAnswer() {

    }

    public static Question identifyQuestion(ElementWrapper element) {
        Question question;
        long noTimeout = 0;

        question = new ShortAnswerQuestion(element.getElementXpath() + "//error");

        if (!question.isDisplayed(noTimeout)) {
            question = new ParagraphQuestion(element.getElementXpath() + "//textarea");

            if (!question.isDisplayed(noTimeout)) {
                question = null;
            } else {
                System.out.println("Textarea");
                System.out.println(element.getElementXpath());
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
