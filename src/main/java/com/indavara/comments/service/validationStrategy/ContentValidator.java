package com.indavara.comments.service.validationStrategy;

import com.indavara.comments.model.CommentFeedBack;

public interface ContentValidator {
    CommentFeedBack validateContent(String content);
}
