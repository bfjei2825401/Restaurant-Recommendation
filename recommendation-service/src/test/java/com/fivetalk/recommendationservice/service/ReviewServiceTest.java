package com.fivetalk.recommendationservice.service;

import com.fivetalk.recommendationservice.service.impl.ReviewServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewServiceTest {
    private ReviewService reviewService = new ReviewServiceImpl();
    @Test
    public void testInsert() throws Exception {
        System.out.println();
    }
}
