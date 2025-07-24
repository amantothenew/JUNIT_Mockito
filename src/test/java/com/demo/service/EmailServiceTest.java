package com.demo.service;

import com.demo.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {
    @Mock
    EmailService emailService;

    @Test
    public void emailTesting() {
        //given
        Order order = new Order(2, "bike", 100000);
        given(emailService.sendEmail(order, "successfull")).willReturn(true);

        //when
        boolean result = emailService.sendEmail(order, "successfull");

        //then
        verify(emailService).sendEmail(order, "successfull");
        assertThat(result, is(true));
    }

    @Test(expected = RuntimeException.class)
    public void emailVoidMethodTesting() {
        //given
        Order order = new Order(2, "bike", 100000);
        doThrow(RuntimeException.class).when(emailService).sendEmail(order);

        //when
        emailService.sendEmail(order);

        //then
        verify(emailService).sendEmail(order, "successfull");
    }
}