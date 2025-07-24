package com.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class cleaTestServiceTest {
    @InjectMocks
    TestService testService;

    @Test
    public void testFirstMethod() {
        assertEquals(1, testService.test());
    }
}