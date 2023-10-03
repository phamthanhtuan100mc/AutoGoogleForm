package core.customized.old;

import core.util.Enum.QuestionType;

public class QuestionTypeWithLocator {
    private QuestionType questionType = QuestionType.NULL;
    private String locator = "";

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
    public void setLocator(String locator) {
        this.locator = locator;
    }

    public void set(QuestionType questionType, String locator) {
        this.questionType = questionType;
        this.locator = locator;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }
    public String getLocator() {
        return locator;
    }

}
