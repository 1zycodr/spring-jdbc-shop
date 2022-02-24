package kz.iitu.itse1909.amirlan.repository.impl;

import kz.iitu.itse1909.amirlan.model.Product;
import kz.iitu.itse1909.amirlan.repository.mappers.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepositoryImpl implements kz.iitu.itse1909.amirlan.repository.ProductRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM SHOP_PRODUCT;", new ProductRowMapper()
        );
    }

    public Product findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM SHOP_PRODUCT WHERE id = ?",
                new Object[]{id}, new ProductRowMapper()
        );
    }
}
