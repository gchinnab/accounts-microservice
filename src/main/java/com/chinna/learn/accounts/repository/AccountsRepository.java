package com.chinna.learn.accounts.repository;

import com.chinna.learn.accounts.entity.Accounts;
import com.chinna.learn.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
}
