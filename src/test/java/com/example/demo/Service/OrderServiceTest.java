package com.example.demo.Service;

import com.example.demo.OrderRepository.OrderRepository;
import com.example.demo.Produkty.Order;
import com.example.demo.Produkty.Produkt;
import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
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
    void checkOrdersContainCreatedOrder() {

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

    }

    @Test
    void delete() {
    }

}