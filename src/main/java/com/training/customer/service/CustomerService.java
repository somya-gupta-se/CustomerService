package com.training.customer.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountClient accountClient;

    @Transactional
    public Customer saveCustomer(Customer customer) {
        return customerRepository.saveAndFlush(customer);
    }

    public void deleteCustomer(Long customerId) {
        accountClient.deleteAccount(customerId);
        customerRepository.deleteById(customerId);
    }

    public boolean existsById(Long customerId) {
        return customerRepository.existsById(customerId);
    }

    @Transactional
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer with given id is not found on server"));
    }

    @Transactional
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @Transactional
    public Customer updateCustomer(Customer customerDetails) {
        Customer customer = customerRepository.findById(customerDetails.getId()).orElse(null);
        if (customer != null) {
            customer.setName(customerDetails.getName());
            customer.setEmail(customerDetails.getEmail());
            return customerRepository.save(customer);
        }
        return null;
    }
}
