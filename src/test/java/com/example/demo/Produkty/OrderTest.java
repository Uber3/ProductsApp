package com.example.demo.Produkty;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * @author Dzmitry Rusak
 * @link
 */
class OrderTest {
    Produkt product1;
    Produkt product2;
    @BeforeEach
    void setup() {
       product1 = new Produkt(1, " bread", BigDecimal.valueOf(12));
       product2 = new Produkt(2, " butter", BigDecimal.valueOf(10));
    }


    @Test
    void setProducts() {

        Order order = new Order();
        List<Produkt> newProducts = new ArrayList<>();
        newProducts.add(product1);
        newProducts.add(product2);
        order.setProducts(newProducts);

        assertFalse(order.getProducts().isEmpty());
        assertEquals(order.getProducts().size(), 2);
        assertTrue(order.getProducts().get(0).equals(product1));
    }

    @Test
    void add() {

        Order order = new Order();
        order.add(product1);

        assertFalse(order.getProducts().isEmpty());
        assertTrue(order.getProducts().get(0).equals(product1));
    }

    @Test
    void getProducts() {

        Order order = new Order();
        order.add(product1);

        List<Produkt> products = order.getProducts();

        assertEquals(products.size(), 1);
    }

    @Test
    void getTotalSum() {

        Order order = new Order();
        order.add(product1);
        order.add(product2);

        assertEquals(order.getTotalSum(), BigDecimal.valueOf(22));

    }

    @Test
    void getCreatedTime() {
        Order order = new Order();
        LocalDateTime createdTime = order.getCreatedTime();
        LocalDateTime currentTime = LocalDateTime.now();

        assertTrue(createdTime.isBefore(currentTime) || createdTime.isEqual(currentTime));
    }

    @Test
    void getUpdatedTime() {
        Order order = new Order();
        LocalDateTime time = order.getCreatedTime();

        order.add(product1);
        LocalDateTime updatedTime = order.getUpdatedTime();

        assertNotEquals(time, updatedTime);
    }
}
