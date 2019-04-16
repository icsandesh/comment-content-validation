package com.indavara.comments.service;

import com.indavara.comments.database.repositories.CommentMongoRepository;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoDBContactServiceTest {

    @Mock
    private CommentMongoRepository contactMongoRepository;

    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private MongoDBCommentService mongoDBContactService;


    public static final String ID = "12313ID";


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


}