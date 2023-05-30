package com.example.demo.OrderRepository;/*
 * @author Dzmitry Rusak
 * @link
 */

import com.example.demo.Produkty.Order;
import com.example.demo.Produkty.Produkt;
import com.example.demo.Users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderRepository {
    private List<Order> orders;

    public OrderRepository(final List<Order> orders) {
        this.orders = orders;
    }

    public Order create(int orderId, int userId, List<Produkt> products) {
        if (this.getById(orderId) != null) {
            throw new IllegalArgumentException("Order already exists:" + orderId);
        }
        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(userId);
        order.setProducts(products);
        orders.add(order);

        return order;
    }

   /* Delete method version
   public void delete(int id) throws Exception {
        for (Order order : orders) {
            if (order.getId() == id) {
                orders.remove(id);
            } else throw new Exception("ID is not found:" + id);
        }
    }*/

/* Delete method version
    public void delete(int orderId) {
        this.orders = orders.stream()
                .filter(order -> order.getOrderId() != orderId)
                .collect(Collectors.toList());
    } */

    public void delete(int orderId) throws Exception {
        var itemIndex = IntStream.range(0, orders.size())
                .filter(i -> orders.get(i).getOrderId() == orderId)
                .findFirst()
                .orElse(-1);

        if (itemIndex != -1) {
            orders.remove(itemIndex);
        } else {
            throw new Exception("ID is not found: " + orderId);
        }

    }

    public List<Order> getAll() {
        return new ArrayList<>(orders);
    }

   /* getById method version
   public Order getById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return orders.get(id);
            }
        }
        return null;
    }*/

    /* getById method version
    public Order getById(int orderId) {
        Optional<Order> first = orders.stream()
                .filter(order -> order.getOrderId() == orderId)
                .findFirst();

        Order order = first.orElseThrow(IllegalArgumentException::new);
        return order;
    } */

    public Order getById(int orderId) {
        var index = IntStream.range(0, orders.size())
                .filter(i -> orders.get(i).getOrderId() == orderId)
                .findFirst()
                .orElse(-1);

        return (index != -1) ? orders.get(orderId) : null;
    }
}

