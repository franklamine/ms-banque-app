package com.frank.accountservice;

import com.frank.accountservice.clients.CustomerRestClient;
import com.frank.accountservice.entities.Account;
import com.frank.accountservice.enums.AccountType;
import com.frank.accountservice.model.Customer;
import com.frank.accountservice.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerRestClient customerRestClient) {
        return args -> {
            List<Customer> customers = customerRestClient.getAllCustomers();
            customers.forEach(customer -> {
                Account account1 = Account.builder()
                        .accountId(UUID.randomUUID().toString())
                        .balance(Math.random() * 8000)
                        .creationDate(LocalDate.now())
                        .currency("CAD")
                        .accountType(AccountType.CURRENT_ACCOUNT)
                        .customerId(customer.getId())
                        .build();
                Account account2 = Account.builder()
                        .accountId(UUID.randomUUID().toString())
                        .balance(Math.random() * 8000)
                        .creationDate(LocalDate.now())
                        .currency("CAD")
                        .accountType(AccountType.SAVING_ACCOUNT)
                        .customerId(customer.getId())
                        .build();

                accountRepository.save(account1);
                accountRepository.save(account2);

            });
        };

    }
}