package com.frank.accountservice.repository;

import com.frank.accountservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
