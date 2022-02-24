package kz.iitu.itse1909.amirlan.service.impl;

import kz.iitu.itse1909.amirlan.model.Product;
import kz.iitu.itse1909.amirlan.repository.ProductRepository;
import kz.iitu.itse1909.amirlan.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id);
    }
}
