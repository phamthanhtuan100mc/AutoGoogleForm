package core.factory;

import core.model.question.Question;
import core.model.question.item.ParagraphQuestion;
import core.model.question.item.ShortAnswerQuestion;

public class QuestionFactory {
    public static Question getSpecificQuestion(Question question) {
        question = new ShortAnswerQuestion(question.getElementXpath(), "//...");

        if (!question.isDisplayed(0)) {
            question = new ParagraphQuestion(question.getElementXpath(), "//textarea");

            if (!question.isDisplayed(0)) {
                question = null;
            } else {
                System.out.println("Textarea");
                System.out.println(question.getElementXpath());
            }
        }
        return question;
    }

//    public Question getSpecificQuestion(Question question) {
//        Question q = null;
//        return q;
//    }
}
