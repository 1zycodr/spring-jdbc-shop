package kz.iitu.itse1909.amirlan.service.mappers;

import kz.iitu.itse1909.amirlan.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Order(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("address"),
            rs.getString("status"),
            rs.getTimestamp("created_at"),
            rs.getTimestamp("updated_at")
        );
    }
}
