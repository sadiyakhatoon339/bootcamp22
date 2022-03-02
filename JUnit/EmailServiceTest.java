
package com.demo.service;

import com.demo.domain.Order;

import org.junit.Test;


public class EmailServiceTest {

    //creating spy
    EmailService eService = spy(EmailService.class);

    @Test
    public void sendEmailTest_whenWePassEmail(){
        Order order = mock(Order.class);
    }

    private Order mock(Class<Order> class1) {
        // TODO Auto-generated method stub
        return null;
    }

    private EmailService spy(Class<EmailService> class1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Test(expected = RuntimeException.class)
    public void sendEmailTest_WhenEmailNotPasssed(){
        Order order = mock(Order.class);
        eService.sendEmail(order);

    }

}