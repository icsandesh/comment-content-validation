package com.indavara.comments.controller;

import com.indavara.comments.model.Comment;
import com.indavara.comments.model.CommentFeedBack;
import com.indavara.comments.service.CommentService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;


@Slf4j
@RestController
@Api(value = "Product Comments API", description = "Crud operations of Product Comments.")
public class CommentController {


    @Autowired
    private CommentService commentService;


    @RequestMapping(value = "v1/comments", method = POST, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> createComment(@RequestBody @Valid Comment comment) {
        String commentID = commentService.createComment(comment);
        log.info("Comment Created with commentID: {}", commentID);
        return new ResponseEntity<>(commentID, HttpStatus.CREATED);
    }

    @RequestMapping(value = "v1/comments/{commentId}", method = GET, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Comment> retrieveComment(@PathVariable String commentId) {
        Comment comment = commentService.retrieveComment(commentId);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @RequestMapping(value = "v1/comments/{commentId}", method = DELETE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity deleteComment(@PathVariable String commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "v1/comments/{commentId}/validate", method = POST, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CommentFeedBack> validateComment(@PathVariable String commentId) {
        CommentFeedBack commentFeedBack = commentService.validateComment(commentId);
        return new ResponseEntity<>(commentFeedBack, HttpStatus.OK);
    }


    @RequestMapping(value = "v1/comments/validate", method = POST, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CommentFeedBack> validateCommentContent(@RequestBody String content) {
        CommentFeedBack commentFeedBack = commentService.validateCommentContent(content);
        return new ResponseEntity<>(commentFeedBack, HttpStatus.OK);
    }


}
