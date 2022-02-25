package kz.iitu.itse1909.amirlan.repository;

import kz.iitu.itse1909.amirlan.model.Order;
import kz.iitu.itse1909.amirlan.repository.impl.OrderRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OrderRepositoryTest {

    @Mock
    OrderRepository orderRepository;

    @Mock
    ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAll() {
        Mockito.when(orderRepository.findAll()).thenReturn(new ArrayList<>());
        List<Order> orderList = orderRepository.findAll();
        System.out.println(orderList);
        assertInstanceOf(List.class, orderList);
        assertEquals(new ArrayList<>(), orderList);
    }

    @Test
    void findById() {
        Order order = orderRepository.findById(1L);
        System.out.println(order);
        assertNull(order);
    }

    @Test
    void findByUserId() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}