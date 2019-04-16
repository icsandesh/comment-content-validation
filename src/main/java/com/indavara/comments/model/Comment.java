package com.indavara.comments.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document
@Data
public class Comment {

    @Id
    private String commentId;

    @NotBlank(message = "Comment Text cannot be blank")
    private String content;

    @Email(message = "emailId should not be invalid")
    private String emailId;

}
