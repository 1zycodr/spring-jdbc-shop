package kz.iitu.itse1909.amirlan.service;

import kz.iitu.itse1909.amirlan.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getAllProducts();
    Product getById(Long id);
    Map<Product, Integer> getOrderProducts(Long orderId);
    void create(Product product);
    boolean update(Product product);
    boolean delete(Long productId);
    int getCountOfProducts();
}
