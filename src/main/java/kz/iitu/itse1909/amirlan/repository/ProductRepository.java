package kz.iitu.itse1909.amirlan.repository;

import kz.iitu.itse1909.amirlan.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM SHOP_PRODUCT;",
                (rs, rowNum) -> new Product(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("price")
                )
        );
    }
}
