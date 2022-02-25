package kz.iitu.itse1909.amirlan.service.mappers;

import kz.iitu.itse1909.amirlan.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Product(
            rs.getLong("id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getInt("price")
        );
    }
}
