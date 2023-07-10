package Prof37Homework_04_07_2023.service;

import Prof37Homework_04_07_2023.model.Customer;
import Prof37Homework_04_07_2023.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        List<Customer> customerList = customerRepository.getAll();
        if (customerList.isEmpty()) {
            System.out.println("Customer list is empty");
        }
        return customerList;
    }

    @Override
    public Customer getById(int id) {
        if (id == 0) {
            System.out.println("Incorrect id " + id);
            return null;
        }
        Customer customer = customerRepository.getById(id);
        if (customer == null) {
            System.out.println("Customer with id " + id + " no found");
        }
        return customer;
    }

    @Override
    public Customer save(Customer customer) {
        if (customer.getFirstName().isEmpty()) {
            System.out.println("First name is empty");
            return null;
        } else if (customer.getLastName().isEmpty()) {
            System.out.println("Last name is empty");
            return null;
        } else if (customer.getAge() < 0) {
            System.out.println("Age is wrong");
            return null;
        }
        return customerRepository.save(customer);
    }
}