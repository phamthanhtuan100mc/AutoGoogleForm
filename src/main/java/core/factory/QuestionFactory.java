package core.factory;

import core.customized.Question;
import core.customized.question_item.ParagraphQuestion;
import core.customized.question_item.ShortAnswerQuestion;

public class QuestionFactory {
    public Question createQuestion(String locator) {
        Question question = new ShortAnswerQuestion(locator, "//...");

        if (!question.isDisplayed(0)) {
            question = new ParagraphQuestion(locator, "//textarea");

            if (!question.isDisplayed(0)) {
                question = null;
            }
        }
        return question;
    }

    public Question getSpecificQuestion(Question question) {
        Question q = null;
        return q;
    }
}
