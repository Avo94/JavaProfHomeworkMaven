package Prof37Homework_04_07_2023.repository;

import Prof37Homework_04_07_2023.model.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> getAll();
    Customer getById(int id);
    Customer save(Customer customer);
}