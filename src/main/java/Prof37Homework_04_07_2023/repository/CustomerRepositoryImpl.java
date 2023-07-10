package Prof37Homework_04_07_2023.repository;

import Prof37Homework_04_07_2023.model.Customer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final Map<Integer, Customer> customerMap = new HashMap<>();

    @PostConstruct
    private void init() {
        customerMap.put(1, new Customer(1, "John", "Smith", 30));
        customerMap.put(2, new Customer(2, "Samantha", "Black", 22));
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getById(int id) {
        return customerMap.get(id);
    }

    @Override
    public Customer save(Customer customer) {
        int lastId = customerMap.keySet().stream().mapToInt(s -> s).max().getAsInt();
        customer.setId(lastId + 1);
        customerMap.put(customer.getId(), customer);
        return customer;
    }
}