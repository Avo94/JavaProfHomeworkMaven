package Prof37Homework_04_07_2023.service;

import Prof37Homework_04_07_2023.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();
    Customer getById(int id);
    Customer save(Customer customer);
}