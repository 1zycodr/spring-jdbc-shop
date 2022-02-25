package kz.iitu.itse1909.amirlan.service.impl;

import kz.iitu.itse1909.amirlan.model.Product;
import kz.iitu.itse1909.amirlan.repository.ProductRepository;
import kz.iitu.itse1909.amirlan.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Map<Product, Integer> getOrderProducts(Long orderId) {
        return productRepository.findOrderProducts(orderId);
    }

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public boolean delete(Long productId) {
        return productRepository.deleteById(productId);
    }

    @Override
    public int getCountOfProducts() {
        return productRepository.count();
    }
}
