package kz.iitu.itse1909.amirlan.repository.impl;

import kz.iitu.itse1909.amirlan.model.Order;
import kz.iitu.itse1909.amirlan.model.Product;
import kz.iitu.itse1909.amirlan.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryImplTest {

    @Mock
    ProductRepositoryImpl productRepository;

    @Mock
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productRepository = new ProductRepositoryImpl(jdbcTemplate);
    }

    @Test
    void findAll() {
        List<Product> products = productRepository.findAll();
        assertInstanceOf(List.class, products);
        assertEquals(new ArrayList<>(), products);
    }

    @Test
    void findById() {
        assertEquals(null, productRepository.findById(1L));
    }

    @Test
    void findById2() {
        Product product = new Product("", "", 1);
        productRepository.save(product);
        assertEquals(null, productRepository.findById(1L));
    }

    @Test
    void findOrderProducts() {
        assertDoesNotThrow(() -> {
            productRepository.findOrderProducts(1L);
        });
    }

    @Test
    void save() {
        Product product = new Product("", "", 1);
        assertDoesNotThrow(() -> {
            productRepository.save(product);
        });
    }

    @Test
    void update() {
        Product product = new Product(1L, "", "", 1);
        assertDoesNotThrow(() -> {
            productRepository.update(product);
        });
    }

    @Test
    void deleteById() {
        assertDoesNotThrow(() -> {
            productRepository.deleteById(1L);
        });
    }

    @Test
    void count() {
    }
}