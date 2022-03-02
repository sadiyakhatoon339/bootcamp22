package com.demo.service;

import static org.junit.Assert.*;

import com.demo.domain.Order;
import org.junit.Test;



public class OrderServiceTest {

    Order obj1 = new Order(5, "Egg", 20.75);
    @Test
    public void placeOrderTest1() {
        assertEquals(5, obj1.getQuantity());
        assertEquals("Egg", obj1.getItemName());
    }


    Order obj2 = new Order(5, "Egg", 20.75);
    @Test
    public void placeOrderTest2() {
        assertEquals(5, obj2.getQuantity());
        assertEquals("Egg", obj2.getItemName());
    }
}
