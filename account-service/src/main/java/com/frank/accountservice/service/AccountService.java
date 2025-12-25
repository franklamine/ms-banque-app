package com.frank.accountservice.service;

import com.frank.accountservice.clients.CustomerRestClient;
import com.frank.accountservice.entities.Account;
import com.frank.accountservice.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class AccountService {
    final private AccountRepository accountRepository;
    final private CustomerRestClient customerRestClient;


    public List<Account> getAllAccounts() {
        List<Account> accounts =  accountRepository.findAll();
        accounts.forEach(account1 -> {
            account1.setCustomer(customerRestClient.getCustomerById(account1.getCustomerId()));
        });
        return accounts;
    }

    public Account getAccountById(String id) {
        Account account = accountRepository.findById(id).get();
        account.setCustomer(customerRestClient.getCustomerById(account.getCustomerId()));
        return account;
    }
}
