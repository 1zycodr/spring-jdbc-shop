package kz.iitu.itse1909.amirlan.repository;

import kz.iitu.itse1909.amirlan.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
    Map<Product, Integer> findOrderProducts(Long orderId);
    void save(Product product);
    boolean update(Product product);
    boolean deleteById(Long id);
    int count();
}
