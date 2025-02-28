package com.training.customer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="account-service", url = "http://localhost:9595/accounts")
public interface AccountClient {
    @DeleteMapping("/customer/{customerId}")
    void deleteAccount(@PathVariable Long customerId);

    @PostMapping("/create/{customerId}")
    void createAccount(@PathVariable Long customerId);

}
