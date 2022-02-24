package kz.iitu.itse1909.amirlan.model;

import lombok.Data;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class User implements Serializable {
    private Long id;
    private String username;
    private String password;

    private List<Order> orders;
}
