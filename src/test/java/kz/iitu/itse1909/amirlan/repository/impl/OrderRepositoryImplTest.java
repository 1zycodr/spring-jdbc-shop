package kz.iitu.itse1909.amirlan.repository.impl;

import kz.iitu.itse1909.amirlan.model.Order;
import kz.iitu.itse1909.amirlan.repository.OrderRepository;
import kz.iitu.itse1909.amirlan.repository.ProductRepository;
import kz.iitu.itse1909.amirlan.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
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
    void findAll() {
//        Mockito.when(orderRepository.findAll()).thenReturn(new ArrayList<>());
        List<Order> orderList = orderRepository.findAll();
        assertInstanceOf(List.class, orderList);
        assertEquals(new ArrayList<>(), orderList);
    }

    @Test
    void findById() {
        Order order = new Order(1L, 1L, "", "", new Timestamp(10), new Timestamp(10));
//        when(orderRepository.findById(anyLong())).thenReturn(order);
        assertEquals(null, orderRepository.findById(1L));
    }

    @Test
    void findById2() {
        Order order = new Order(1L, 1L, "a", "a", new Timestamp(10), new Timestamp(10));
        orderRepository.save(order);
        assertEquals(null, orderRepository.findById(1L));
    }

    @Test
    void findByUserId() {
        assertInstanceOf(List.class, orderRepository.findByUserId(1L));
    }

    @Test
    void save() {
    }

    @Test
    void update() {
        when(jdbcTemplate.update(any(), any(), any(), any(), any())).thenReturn(1);
        assertDoesNotThrow(() -> {
            Order order = new Order(1L, 1L, "a", "a", new Timestamp(10), new Timestamp(10));
            orderRepository.update(order);
        });
    }

    @Test
    void deleteById() {
        assertDoesNotThrow(() -> {
            orderRepository.deleteById(1L);
        });
    }
}