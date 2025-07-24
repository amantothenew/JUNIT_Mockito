package com.demo.service;

import com.demo.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    @Mock
    EmailService emailService;

    @InjectMocks
    OrderService orderService;

    @Test
    public void placeOrderBooleanReturnFunctionTest() {
        //given
        Order order = new Order(2,"Bike", 100000);

        given(emailService.sendEmail(order, "successfull")).willReturn(true);

        //when
        boolean result = orderService.placeOrder(order, "successfull");

        //then
        assertThat(result, is(true));
        assertThat(order.isCustomerNotified(), is(true));
        verify(emailService).sendEmail(order, "successfull");
    }


    @Test
    public void placeOrderVoidReturnFunctionTest() {
        //given
        Order order = new Order(2,"Bike", 100000);

        doNothing().when(emailService).sendEmail(order);
        //when
        orderService.placeOrder(order);

        //then
        verify(emailService).sendEmail(order);
        assertThat(order.isCustomerNotified(), is(true));
    }
}
