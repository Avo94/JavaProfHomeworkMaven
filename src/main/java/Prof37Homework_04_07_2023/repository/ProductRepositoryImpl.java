package Prof37Homework_04_07_2023.repository;

import Prof37Homework_04_07_2023.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Map<Integer, Product> productMap = new HashMap<>();

    private final Map<Integer, Product> basket = new HashMap<>();

    @PostConstruct
    private void init() {
        productMap.put(1, new Product(1, "Book", 509.99));
        productMap.put(2, new Product(2, "Pan", 17.58));
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product getById(int id) {
        return productMap.get(id);
    }

    @Override
    public Product save(Product product) {
        int lastId = productMap.keySet().stream().mapToInt(s -> s).max().getAsInt();
        product.setId(lastId + 1);
        productMap.put(product.getId(), product);
        return product;
    }

    @Override
    public Product addToCart(Product product) {
        basket.put(product.getId(), product);
        return product;
    }
}