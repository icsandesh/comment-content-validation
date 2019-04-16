package com.indavara.comments.service.validationStrategy;

import com.indavara.comments.model.CommentFeedBack;
import org.springframework.stereotype.Component;

@Component
public class ViolentContentValidationStrategy implements ContentValidator {
    @Override
    public CommentFeedBack validateContent(String content) {
        return null;
    }
}
