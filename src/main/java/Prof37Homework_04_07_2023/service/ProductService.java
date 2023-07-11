package Prof37Homework_04_07_2023.service;

import Prof37Homework_04_07_2023.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();
    Product getById(int id);
    Product save(Product product);
    Product addToCart(Product product);
}