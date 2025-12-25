package com.frank.accountservice.entities;

import com.frank.accountservice.enums.AccountType;
import com.frank.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Account {
    @Id
    private String accountId;
    private double balance;
    private LocalDate creationDate;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Transient
    private Customer customer;
    private Long customerId;
}
