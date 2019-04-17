package com.indavara.comments.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CommentFeedBack {

    private double objectionScore;

    private List<String> objectionFeedback;

    public CommentFeedBack(double avgObjectionScore, List<String> objectionFeedback) {
        this.objectionScore = avgObjectionScore;
        this.objectionFeedback = objectionFeedback;
    }
}