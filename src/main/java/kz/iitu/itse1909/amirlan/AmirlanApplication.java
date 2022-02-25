package kz.iitu.itse1909.amirlan;

import kz.iitu.itse1909.amirlan.model.Order;
import kz.iitu.itse1909.amirlan.model.Product;
import kz.iitu.itse1909.amirlan.service.impl.OrderServiceImpl;
import kz.iitu.itse1909.amirlan.service.impl.ProductServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.PipedOutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class AmirlanApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AmirlanApplication.class, args);
        ProductServiceImpl productService = applicationContext.getBean(ProductServiceImpl.class);
        System.out.println("Get All Products:");
        List<Product> productList = (ArrayList<Product>) productService.getAllProducts();
        System.out.println(productList);
        System.out.println("Get product by id:");
        System.out.println(productService.getById(productList.get(0).getId()));
        System.out.println("Create product:");
        Product product = new Product("created product", "", 1000);
        productService.create(product);
        productList = (ArrayList<Product>) productService.getAllProducts();
        product = productList.get(productList.size() - 1);
        System.out.println(product);
        System.out.println("Update product:");
        product.setTitle("updated product");
        productService.update(product);
        product = productService.getById(product.getId());
        System.out.println(product);
        System.out.println("Products after delete:");
        productService.delete(product.getId());
        System.out.println(productService.getAllProducts());
        System.out.println("Products count: " + productService.getCountOfProducts());

        OrderServiceImpl orderService = applicationContext.getBean(OrderServiceImpl.class);
        Order order = new Order(10L, 1L, "address", "status", new Timestamp(1000L), new Timestamp(1000L));

        Map<Product, Integer> products = new HashMap<>();

        products.put(new Product(1L, "title", "desc", 1000), 2);

        order.setProducts(products);
        orderService.create(order);
        System.out.println(orderService.getById(order.getId()));
        products.clear();
        products.put(new Product(2L, "title", "desc", 1000), 2);
        products.put(new Product(3L, "title", "desc", 1000), 2);
        order.setProducts(products);
        orderService.update(order);
        System.out.println("after update:");
        System.out.println(orderService.getById(order.getId()));
        orderService.delete(order.getId());
    }
}
