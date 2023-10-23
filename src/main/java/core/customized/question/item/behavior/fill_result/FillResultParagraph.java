package core.customized.question.item.behavior.fill_result;

import core.customized.question.FillResultBehavior;
import core.customized.question.Question;

public class FillResultParagraph implements FillResultBehavior {

    @Override
    public void fillResult(Question question) {
        // do something
        System.out.println("Test fill result for: " + question.getClass());
    }

}
