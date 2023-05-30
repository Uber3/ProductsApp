package com.example.demo.OrderRepository;

import com.example.demo.Produkty.Order;
import com.example.demo.Produkty.Produkt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * @author Dzmitry Rusak
 * @link
 */class OrderRepositoryTest {
    Produkt product1;
    Produkt product2;
    List<Produkt> products;
    List<Order> orders;
    Order order;
    OrderRepository orderRepository;
    final int START_INDEX = 0;
    final int USER_ID = 1;


    @BeforeEach
    void setup() {
        product1 = new Produkt(1, " bread", BigDecimal.valueOf(12));
        product2 = new Produkt(2, " butter", BigDecimal.valueOf(10));

        products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        orders = new ArrayList<>();
        orderRepository = new OrderRepository(orders);

    }


    @Test
    void create() {
        order = orderRepository.create(START_INDEX, USER_ID, products);

        assertFalse(order.getProducts().isEmpty());
        assertEquals(order.getProducts().size(), 2);
        assertEquals(order.getProducts().get(0), product1);
    }

    @Test
    void delete() throws Exception {
        order = orderRepository.create(START_INDEX,USER_ID, products);
        orderRepository.delete(START_INDEX);

        assertFalse(orders.contains(order));
        assertEquals(orders.size(), 0);
    }

    @Test
    void getAll() {
        order = orderRepository.create(START_INDEX, USER_ID, products);
        List<Order> newOrderList = orderRepository.getAll();

        assertFalse(newOrderList.isEmpty());
        assertEquals(newOrderList.size(), 1);
        assertTrue(newOrderList.get(0).equals(order));
    }

    @Test
    void getById() {
        order = orderRepository.create(START_INDEX,USER_ID, products);
        Order retrievedOrder = orderRepository.getById(START_INDEX);

        assertEquals(retrievedOrder.getOrderId(), START_INDEX);
        assertTrue(retrievedOrder.equals(order));

    }

}