package com.example.demo.Service;

import com.example.demo.OrderRepository.OrderRepository;
import com.example.demo.Produkty.Order;
import com.example.demo.Produkty.Produkt;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/*
 * @author Dzmitry Rusak
 * @link
 */
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private OrderService orderService;
    private static final List<Order> orders = new ArrayList<>();
    private static final Order order = new Order();
    private final static int ORDER_ID = 1;


    @Test
    void create() {
        int userId = 1;
        List<Produkt> products = new ArrayList<>();

        when(orderRepository.create(ORDER_ID,userId, products)).thenReturn(order);

        Order actualOrder = orderService.create(ORDER_ID, userId, products);
        verify(orderRepository).create(ORDER_ID,userId, products);
        assertEquals(order, actualOrder);
    }

    @Test
    void testGetById() {

        order.setOrderId(ORDER_ID);
        orders.add(order);

       when(orderRepository.getById(ORDER_ID)).thenReturn(order);

        Order actualOrder = orderService.getById(ORDER_ID);
        verify(orderRepository).getById(ORDER_ID);
        assertEquals(order, actualOrder);
    }

    @Test
    void getAll() {
        orders.add(order);
        when(orderRepository.getAll()).thenReturn(orders);

        List<Order> actualOrders = orderService.getAll();
        verify(orderRepository).getAll();
        assertEquals(orders, actualOrders);
    }

    @Test
    void delete() throws Exception {

        orderService.delete(ORDER_ID);
        verify(orderRepository,times(1)).delete(eq(ORDER_ID));
    }

}