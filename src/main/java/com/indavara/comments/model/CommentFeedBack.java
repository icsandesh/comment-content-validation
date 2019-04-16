package com.indavara.comments.model;

import lombok.Data;

import java.util.List;

@Data
public class CommentFeedBack {

    private double objectionScore;

    private List<String> objectionFeedback;

    public CommentFeedBack(double avgObjectionScore, List<String> objectionFeedback) {
        this.objectionScore = avgObjectionScore;
        this.objectionFeedback = objectionFeedback;
    }
}