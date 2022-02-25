package kz.iitu.itse1909.amirlan.repository.impl;

import kz.iitu.itse1909.amirlan.model.Order;
import kz.iitu.itse1909.amirlan.repository.OrderRepository;
import kz.iitu.itse1909.amirlan.repository.ProductRepository;
import kz.iitu.itse1909.amirlan.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryImplTest {

    @Mock
    OrderRepository orderRepository;

    @Mock
    ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void setJdbcTemplate() {
    }

    @Test
    void setProductRepository() {
//        assertDoesNotThrow(() -> {
//            orderRepository.setProductRepository(productService);
//        });
    }

    @Test
    void findAll() {
        List<Order> orderList = orderRepository.findAll();
        System.out.println(orderList);
        assertInstanceOf(List.class, orderList);
        assertEquals(new ArrayList<>(), orderList);
    }

    @Test
    void findById() {
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