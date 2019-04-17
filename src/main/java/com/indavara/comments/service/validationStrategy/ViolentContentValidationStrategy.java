package com.indavara.comments.service.validationStrategy;

import com.indavara.comments.model.CommentFeedBack;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.regex.Pattern;

@Component
public class ViolentContentValidationStrategy implements ContentValidator {
    private Pattern violentPatterns = Pattern.compile("(terrorism|attack|murder)");

    @Override
    public CommentFeedBack validateContent(String content) {


        boolean isAdultPatternMatched = violentPatterns.matcher(content).matches();

        CommentFeedBack commentFeedBack = new CommentFeedBack();

        if (isAdultPatternMatched) {
            commentFeedBack.setObjectionFeedback(Collections.singletonList("Violent Content found"));
            commentFeedBack.setObjectionScore(50);
        }
        return commentFeedBack;
    }
}
