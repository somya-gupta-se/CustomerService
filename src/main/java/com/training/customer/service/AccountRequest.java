package com.training.customer.service;

import jakarta.persistence.Id;

import java.math.BigDecimal;

public class AccountRequest {
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /*public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }*/

    @Id
    //private Long accountNumber;
    private Long customerId;
    private BigDecimal balance;
}
