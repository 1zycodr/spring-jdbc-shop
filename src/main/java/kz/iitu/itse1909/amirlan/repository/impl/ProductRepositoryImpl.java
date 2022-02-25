package kz.iitu.itse1909.amirlan.repository.impl;

import kz.iitu.itse1909.amirlan.model.Product;
import kz.iitu.itse1909.amirlan.service.mappers.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlRowSetResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductRepositoryImpl implements kz.iitu.itse1909.amirlan.repository.ProductRepository {
    private final JdbcTemplate jdbcTemplate;
    private final String SELECT_ALL_QUERY = "SELECT * FROM SHOP_PRODUCT";
    private final String SELECT_BY_ID_QUERY = "SELECT * FROM SHOP_PRODUCT WHERE id = ?";
    private final String SELECT_ORDER_PRODUCTS_QUERY = "SELECT * FROM SHOP_ORDER_PRODUCTS op " +
            "INNER JOIN shop_product sp on op.product_id = sp.id WHERE order_id = ?";
    private final String INSERT_QUERY = "INSERT INTO SHOP_PRODUCT (title, description, price) VALUES (?, ?, ?)";
    private final String UPDATE_QUERY = "UPDATE SHOP_PRODUCT SET title=?,description=?,price=? WHERE id=?";
    private final String DELETE_QUERY = "DELETE FROM SHOP_PRODUCT WHERE id=?";
    private final String COUNT_QUERY = "SELECT COUNT(*) as count FROM SHOP_PRODUCT;";

    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(SELECT_ALL_QUERY, new ProductRowMapper());
    }

    @Override
    public Product findById(Long id) {
        return jdbcTemplate.queryForObject(
                SELECT_BY_ID_QUERY, new Object[]{id}, new ProductRowMapper()
        );
    }

    @Override
    public Map<Product, Integer> findOrderProducts(Long orderId) {
        Map<Product, Integer> orderProducts = new HashMap<>();
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(SELECT_ORDER_PRODUCTS_QUERY, orderId);
        for(Map<String, Object> result: resultList) {
            orderProducts.put(
                    new Product(
                            Long.valueOf(String.valueOf(result.get("product_id"))),
                            (String) result.get("title"),
                            (String) result.get("description"),
                            (Integer) result.get("price")
                    ),
                    (Integer) result.get("quantity")
            );
        }
        return orderProducts;
    }

    @Override
    public void save(Product product) {
        jdbcTemplate.update(
                INSERT_QUERY,
                product.getTitle(), product.getDescription(), product.getPrice()
        );
    }

    @Override
    public boolean update(Product product) {
        int count = jdbcTemplate.update(
                UPDATE_QUERY,
                product.getTitle(), product.getDescription(), product.getPrice(),
                product.getId()
        );
        return count != 0;
    }

    @Override
    public boolean deleteById(Long id) {
        int count = jdbcTemplate.update(
                DELETE_QUERY,
                id
        );
        return count != 0;
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject(COUNT_QUERY, Integer.class);
    }
}
