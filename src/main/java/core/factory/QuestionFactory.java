package core.factory;

import core.customized.Question;
import core.customized.question_item.ParagraphQuestion;
import core.customized.question_item.ShortAnswerQuestion;

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