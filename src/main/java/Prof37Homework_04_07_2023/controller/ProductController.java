package Prof37Homework_04_07_2023.controller;

import Prof37Homework_04_07_2023.model.Product;
import Prof37Homework_04_07_2023.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable(name = "id") int id) {
        return productService.getById(id);
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PostMapping("/{id}")
    public Product addToCart(@PathVariable(name = "id") int id) {
        return productService.addToCart(id);
    }
}