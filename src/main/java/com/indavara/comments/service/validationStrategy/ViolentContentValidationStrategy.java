package com.indavara.comments.service.validationStrategy;

import com.indavara.comments.model.CommentFeedBack;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.indavara.comments.util.CommonUtils.isWordsFound;

@Component
public class ViolentContentValidationStrategy implements ContentValidator {
    private static List<String> adultWordList = Arrays.asList("terrorism", "attack", "murder");

    @Override
    public CommentFeedBack validateContent(String content) {

        boolean isAdultPatternMatched = isWordsFound(content, adultWordList);

        CommentFeedBack commentFeedBack = new CommentFeedBack();
        if (isAdultPatternMatched) {
            commentFeedBack.setObjectionFeedback(Collections.singletonList("Violent Content found"));
            commentFeedBack.setObjectionScore(50);
        }
        return commentFeedBack;
    }
}
