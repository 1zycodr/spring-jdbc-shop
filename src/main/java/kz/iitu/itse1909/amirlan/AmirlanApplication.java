package kz.iitu.itse1909.amirlan;

import kz.iitu.itse1909.amirlan.service.impl.ProductServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AmirlanApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AmirlanApplication.class, args);
        ProductServiceImpl productService = applicationContext.getBean(ProductServiceImpl.class);
        System.out.println(productService.getAllProducts());
        System.out.println(productService.getById(1L));
    }
}
