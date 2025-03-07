package com.gthm.cucumber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gthm.cucumber.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
