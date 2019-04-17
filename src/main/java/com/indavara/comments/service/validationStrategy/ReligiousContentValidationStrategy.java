package com.indavara.comments.service.validationStrategy;

import com.indavara.comments.model.CommentFeedBack;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.regex.Pattern;

@Component
public class ReligiousContentValidationStrategy implements ContentValidator {
    private Pattern religiousPattern = Pattern.compile("(hindu|muslim|christ)");

    @Override
    public CommentFeedBack validateContent(String content) {


        boolean isAdultPatternMatched = religiousPattern.matcher(content).matches();

        CommentFeedBack commentFeedBack = new CommentFeedBack();

        if (isAdultPatternMatched) {
            commentFeedBack.setObjectionFeedback(Collections.singletonList("Religious Content found"));
            commentFeedBack.setObjectionScore(50);
        }
        return commentFeedBack;
    }
}
