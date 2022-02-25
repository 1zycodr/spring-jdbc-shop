package kz.iitu.itse1909.amirlan.service.impl;

import kz.iitu.itse1909.amirlan.model.Order;
import kz.iitu.itse1909.amirlan.repository.OrderRepository;
import kz.iitu.itse1909.amirlan.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public void create(Order order) {
        orderRepository.save(order);
    }

    @Override
    public boolean update(Order order) {
        return orderRepository.update(order);
    }

    @Override
    public boolean delete(Long orderId) {
        return orderRepository.deleteById(orderId);
    }
}
