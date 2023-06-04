package com.example.demo.Controller;/*
 * @author Dzmitry Rusak
 * @link
 */

import com.example.demo.Produkty.Order;
import com.example.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping
    public List<Order> getAll(){
        return this.orderService.getAll();
    }

    @GetMapping
    public Order getById(int orderId) {
        return this.orderService.getById(orderId);
    }

    @PostMapping
    public Order create(@RequestBody Order order){
        return this.orderService.create(order.getOrderId(),order.getUserId(),order.getProducts());
    }

   @DeleteMapping
    public void delete(int orderId) throws Exception {
       this.orderService.delete(orderId);
    }

    //    @PutMapping
}