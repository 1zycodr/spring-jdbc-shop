package kz.iitu.itse1909.amirlan.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
public class Order implements Serializable {
    private Long id;
    private String address;
    private String status;
    private Timestamp created_at;
    private Timestamp updated_at;

    private List<Product> products;
}
