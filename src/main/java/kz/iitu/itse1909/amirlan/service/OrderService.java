package kz.iitu.itse1909.amirlan.service;

import kz.iitu.itse1909.amirlan.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getById(Long id);
    List<Order> getByUserId(Long userId);
    void create(Order order);
    boolean update(Order order);
    boolean delete(Long orderId);
}
