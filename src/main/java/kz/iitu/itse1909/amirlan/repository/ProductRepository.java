package kz.iitu.itse1909.amirlan.repository;

import kz.iitu.itse1909.amirlan.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
