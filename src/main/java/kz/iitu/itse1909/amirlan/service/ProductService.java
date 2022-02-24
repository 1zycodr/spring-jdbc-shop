package kz.iitu.itse1909.amirlan.service;

import kz.iitu.itse1909.amirlan.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getById(Long id);
}
