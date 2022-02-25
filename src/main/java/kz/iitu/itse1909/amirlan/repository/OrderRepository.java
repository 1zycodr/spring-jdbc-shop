package kz.iitu.itse1909.amirlan.repository;

import kz.iitu.itse1909.amirlan.model.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findAll();
    Order findById(Long orderId);
    List<Order> findByUserId(Long userId);
    void save(Order order);
    boolean update(Order order);
    boolean deleteById(Long id);
        }
