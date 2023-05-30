package com.example.demo.Service;/*
 * @author Dzmitry Rusak
 * @link
 */

import com.example.demo.OrderRepository.OrderRepository;
import com.example.demo.Produkty.Order;
import com.example.demo.Produkty.Produkt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order create(int orderId, int userId, List<Produkt> products) {
        return orderRepository.create(orderId, userId, products);
    }

    public Order getById(int orderId) {
        return orderRepository.getById(orderId);
    }

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public void delete(int orderId) throws Exception {
        orderRepository.delete(orderId);
    }

}
