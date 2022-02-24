package kz.iitu.itse1909.amirlan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Product implements Serializable {
    private Long id;
    private String title;
    private String description;
    private Integer price;
}
