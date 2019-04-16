package com.indavara.comments.service;

import com.indavara.comments.model.CommentFeedBack;
import com.indavara.comments.service.validationStrategy.ContentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContentValidationService {

    @Autowired
    private List<ContentValidator> contentValidators = new ArrayList<>();

    public CommentFeedBack validateCommentContent(String content) {
        int totalObjectionScore = 0;
        List<String> objectionFeedback = new ArrayList<>();
        for (ContentValidator contentValidator : contentValidators) {
            CommentFeedBack commentFeedBack = contentValidator.validateContent(content);
            totalObjectionScore += commentFeedBack.getObjectionScore();
            objectionFeedback.addAll(commentFeedBack.getObjectionFeedback());
        }

        double avgObjectionScore = (double) totalObjectionScore / contentValidators.size();

        return new CommentFeedBack(avgObjectionScore, objectionFeedback);
    }
}
