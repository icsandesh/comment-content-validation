package com.indavara.comments.service.validationStrategy;

import com.indavara.comments.model.CommentFeedBack;
import com.indavara.comments.util.CommonUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import static com.indavara.comments.util.CommonUtils.isWordsFound;

@Component
public class AdultContentValidationStrategy implements ContentValidator {


    private static List<String> adultWordList = Arrays.asList("adult", "sexual");

    @Override
    public CommentFeedBack validateContent(String content) {

        boolean isAdultPatternMatched = isWordsFound(content, adultWordList);

        CommentFeedBack commentFeedBack = new CommentFeedBack();

        if (isAdultPatternMatched) {
            commentFeedBack.setObjectionFeedback(Collections.singletonList("Adult Content found"));
            commentFeedBack.setObjectionScore(75);
        }
        return commentFeedBack;
    }

}
