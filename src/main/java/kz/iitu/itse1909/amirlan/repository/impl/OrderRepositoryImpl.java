package kz.iitu.itse1909.amirlan.repository.impl;

import com.sun.istack.NotNull;
import kz.iitu.itse1909.amirlan.model.Order;
import kz.iitu.itse1909.amirlan.model.Product;
import kz.iitu.itse1909.amirlan.repository.OrderRepository;
import kz.iitu.itse1909.amirlan.service.ProductService;
import kz.iitu.itse1909.amirlan.service.mappers.OrderRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderRepositoryImpl implements OrderRepository {
    private final ProductService productService;
    private final JdbcTemplate jdbcTemplate;
    private final String SELECT_ALL_QUERY = "SELECT * FROM SHOP_ORDER";
    private final String SELECT_BY_ID_QUERY = "SELECT * FROM SHOP_ORDER WHERE id = ?";
    private final String SELECT_BY_USER_ID_QUERY = "SELECT * FROM SHOP_ORDER WHERE user_id = ?";
    private final String INSERT_QUERY = "INSERT INTO SHOP_ORDER (user_id, address, status) VALUES (?, ?, ?)";
    private final String INSERT_ORDER_PRODUCTS = "INSERT INTO " +
            "SHOP_ORDER_PRODUCTS (order_id, product_id, quantity) VALUES (?, ?, ?)";
    private final String UPDATE_QUERY = "UPDATE SHOP_ORDER SET user_id=?,address=?,status=? WHERE id=?";
    private final String DELETE_QUERY = "DELETE FROM SHOP_ORDER WHERE id=?";
    private final String DELETE_ORDER_PRODUCTS_QUERY = "DELETE FROM SHOP_ORDER_PRODUCTS WHERE order_id=?";

    public OrderRepositoryImpl(ProductService productService, JdbcTemplate jdbcTemplate) {
        this.productService = productService;
        this.jdbcTemplate = jdbcTemplate;
    }
//    @Autowired
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Autowired
//    public void setProductRepository(ProductService productService) {
//        this.productService = productService;
//    }

    @Override
    public List<Order> findAll() {
        return jdbcTemplate.query(SELECT_ALL_QUERY, new OrderRowMapper()).stream().peek((order) -> order.setProducts(productService.getOrderProducts(order.getId()))
        ).collect(Collectors.toList());
    }

    @Override
    public Order findById(Long id) {
        Order order = jdbcTemplate.queryForObject(SELECT_BY_ID_QUERY, new Object[]{id}, new OrderRowMapper());
        System.out.println(order);
        if (order == null) {
            return null;
        }
        order.setProducts(productService.getOrderProducts(id));
        return order;
    }

    @Override
    public List<Order> findByUserId(Long userId) {
        return jdbcTemplate.query(SELECT_BY_USER_ID_QUERY, new Object[]{userId}, new OrderRowMapper()).stream().peek(
                (order) -> order.setProducts(productService.getOrderProducts(order.getId()))
        ).collect(Collectors.toList());
    }

    @Override
    public void save(Order order) {
        jdbcTemplate.update(
                INSERT_QUERY,
                order.getUser_id(),
                order.getAddress(),
                order.getStatus()
        );
        Integer id = jdbcTemplate.queryForObject("SELECT MAX(id) FROM SHOP_ORDER", Integer.class);
        if (id == null) id = 1;
        order.setId(
                Long.parseLong(String.valueOf(
                        id
                ))
        );
        if (order.getProducts() != null) {

            List<Map.Entry<Product, Integer>> ordersList =
                    new ArrayList<>(order.getProducts().entrySet());
            jdbcTemplate.batchUpdate(
                    INSERT_ORDER_PRODUCTS, new BatchPreparedStatementSetter() {
                        @Override
                        public void setValues(PreparedStatement ps, int i) throws SQLException {
                            Map.Entry<Product, Integer> orderProduct = ordersList.get(i);
                            ps.setInt(1, Integer.parseInt(String.valueOf(order.getId())));
                            ps.setInt(2, Integer.parseInt(String.valueOf(orderProduct.getKey().getId())));
                            ps.setInt(3, orderProduct.getValue());
                        }
                        @Override
                        public int getBatchSize() {
                            return ordersList.size();
                        }
                    }
            );
        }
    }

    @Override
    public boolean update(Order order) {
        int count = jdbcTemplate.update(
                UPDATE_QUERY,
                order.getUser_id(),
                order.getAddress(),
                order.getStatus(),
                order.getId()
        );

        if (count != 0) {
            jdbcTemplate.update(
                    DELETE_ORDER_PRODUCTS_QUERY,
                    order.getId()
            );
            Map<Product, Integer> orderProducts = order.getProducts();
            if (orderProducts == null) orderProducts = new HashMap<>();
            List<Map.Entry<Product, Integer>> ordersList =
                    new ArrayList<>(orderProducts.entrySet());
            jdbcTemplate.batchUpdate(
                    INSERT_ORDER_PRODUCTS, new BatchPreparedStatementSetter() {
                        @Override
                        public void setValues(PreparedStatement ps, int i) throws SQLException {
                            Map.Entry<Product, Integer> orderProduct = ordersList.get(i);
                            ps.setInt(1, Integer.parseInt(String.valueOf(order.getId())));
                            ps.setInt(2, Integer.parseInt(String.valueOf(orderProduct.getKey().getId())));
                            ps.setInt(3, orderProduct.getValue());
                        }
                        @Override
                        public int getBatchSize() {
                            return ordersList.size();
                        }
                    }
            );
        }
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
}
