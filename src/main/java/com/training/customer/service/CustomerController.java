package com.training.customer.service;

//import com.training.customer.service.service.impl.CustomerServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountClient accountClient;

    /*
    Create Customer and open its account side by side
     */
    @PostMapping("/add")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer savedCustomer = customerService.saveCustomer(customer);
        accountClient.createAccount(savedCustomer.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.saveCustomer(customer));
    }

    /*
    Get Customer Details
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        Customer user = customerService.getCustomer(id);
        return ResponseEntity.ok(user);
    }

    /*
    Validate customer, used in case of deposit and update
     */
    @GetMapping("/validate/{customerId}")
    public ResponseEntity<Boolean> validateCustomer(@PathVariable Long customerId) {
        boolean exists = customerService.existsById(customerId);
        return ResponseEntity.ok(exists);
    }

    /*
    Delete customer
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        try {
            customerService.deleteCustomer(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /*
    Update customer details on basis of id
     */
    @PutMapping
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return ResponseEntity.ok("Customer and Account Updated Successfully.");
    }

    /*
    Get All customers created
     */
    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> allUser = customerService.getAllCustomers();
        return ResponseEntity.ok(allUser);
    }

}
