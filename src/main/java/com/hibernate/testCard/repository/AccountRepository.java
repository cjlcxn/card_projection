package com.hibernate.testCard.repository;

import com.hibernate.testCard.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
