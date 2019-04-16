package com.indavara.comments.service;

import com.indavara.comments.database.repositories.CommentMongoRepository;
import com.indavara.comments.model.Comment;
import com.indavara.comments.model.CommentFeedBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MongoDBCommentService implements CommentService {

    @Autowired
    private CommentMongoRepository commentMongoRepository;

    @Autowired
    private ContentValidationService contentValidationService;

    @Override
    public String createComment(Comment comment) {
        Comment save = commentMongoRepository.save(comment);
        return save.getCommentId();
    }

    @Override
    public Comment retrieveComment(String commentId) {
        return commentMongoRepository.findByCommentId(commentId);
    }

    @Override
    public void deleteComment(String commentId) {
        commentMongoRepository.deleteByCommentId(commentId);
    }

    @Override
    public CommentFeedBack validateComment(String commentId) {
        Comment comment = retrieveComment(commentId);
        return contentValidationService.validateCommentContent(comment.getContent());
    }

    @Override
    public CommentFeedBack validateCommentContent(String content) {
        return contentValidationService.validateCommentContent(content);
    }
}
