package com.indavara.comments.service.validationStrategy;

import com.indavara.comments.model.CommentFeedBack;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.regex.Pattern;

@Component
public class AdultContentValidationStrategy implements ContentValidator {


    private Pattern adultPatterns = Pattern.compile("(adult|sexual|asshole)");

    @Override
    public CommentFeedBack validateContent(String content) {


        boolean isAdultPatternMatched = adultPatterns.matcher(content).matches();

        CommentFeedBack commentFeedBack = new CommentFeedBack();

        if (isAdultPatternMatched) {
            commentFeedBack.setObjectionFeedback(Collections.singletonList("Adult Content found"));
            commentFeedBack.setObjectionScore(50);
        }
        return commentFeedBack;
    }
}
