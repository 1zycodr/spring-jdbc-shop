package kz.iitu.itse1909.amirlan.repository.impl;

import kz.iitu.itse1909.amirlan.model.Order;
import kz.iitu.itse1909.amirlan.repository.OrderRepository;
import kz.iitu.itse1909.amirlan.repository.ProductRepository;
import kz.iitu.itse1909.amirlan.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


class OrderRepositoryImplTest {

    @Mock
    OrderRepositoryImpl orderRepository;

    @Mock
    ProductService productService;

    @Mock
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        orderRepository = new OrderRepositoryImpl(productService, jdbcTemplate);
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
        Mockito.when(orderRepository.findAll()).thenReturn(new ArrayList<>());
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