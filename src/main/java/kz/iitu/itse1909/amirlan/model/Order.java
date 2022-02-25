package kz.iitu.itse1909.amirlan.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

@Data
@AllArgsConstructor
public class Order implements Serializable {
    private Long id;
    private Long user_id;
    private String address;
    private String status;
    private Timestamp created_at;
    private Timestamp updated_at;

    private Map<Product, Integer> products;

    public Order(Long id, Long user_id, String address, String status, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.user_id = user_id;
        this.address = address;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
