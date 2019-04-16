package com.indavara.comments.database.repositories;

import com.indavara.comments.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface CommentMongoRepository extends MongoRepository<Comment, String> {

    Comment findByCommentId(String commentId);

    void deleteByCommentId(String commentId);

}
