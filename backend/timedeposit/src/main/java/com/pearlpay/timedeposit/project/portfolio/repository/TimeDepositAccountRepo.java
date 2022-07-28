package com.pearlpay.timedeposit.project.portfolio.repository;

import com.pearlpay.timedeposit.project.portfolio.domain.TimeDepositAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeDepositAccountRepo extends JpaRepository<TimeDepositAccount,Long> {
}
