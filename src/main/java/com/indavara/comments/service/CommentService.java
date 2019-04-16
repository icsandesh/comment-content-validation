package com.indavara.comments.service;

import com.indavara.comments.model.Comment;
import com.indavara.comments.model.CommentFeedBack;

public interface CommentService {

    String createComment(Comment comment);

    Comment retrieveComment(String commentId);

    void deleteComment(String commentId);

    CommentFeedBack validateComment(String commentId);

    CommentFeedBack validateCommentContent(String content);
}
