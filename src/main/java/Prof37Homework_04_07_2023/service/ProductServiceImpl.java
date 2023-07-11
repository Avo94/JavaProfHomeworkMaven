package Prof37Homework_04_07_2023.service;

import Prof37Homework_04_07_2023.model.Product;
import Prof37Homework_04_07_2023.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        List<Product> productList = productRepository.getAll();
        if (productList.isEmpty()) {
            System.out.println("Product list is empty");
        }
        return productList;
    }

    @Override
    public Product getById(int id) {
        if (id == 0) {
            System.out.println("Incorrect id " + id);
            return null;
        }
        Product product = productRepository.getById(id);
        if (product == null) {
            System.out.println("Product with id " + id + " no found");
        }
        return product;
    }

    @Override
    public Product save(Product product) {
        if (product.getName().isEmpty()) {
            System.out.println("Product name is empty");
            return null;
        } else if (product.getPrice() < 0) {
            System.out.println("Price is wrong");
            return null;
        }
        return productRepository.save(product);
    }

    public Product addToCart(Product product) {
        for (Product item : productRepository.getAll()) {
            if (item.equals(product)) {
                System.out.println("Product successfully added");
                return productRepository.addToCart(item);
            }
        }
        System.out.println("No such product exists");
        return null;
    }
}