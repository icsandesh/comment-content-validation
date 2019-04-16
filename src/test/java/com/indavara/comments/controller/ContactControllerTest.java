package com.indavara.comments.controller;

import com.indavara.comments.service.MongoDBCommentService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class ContactControllerTest {

    public static final String ID = "12313ID";

    @Mock
    private MongoDBCommentService mongoDBContactService;

    @InjectMocks
    private CommentController contactController;


    @Before
    public  void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


}