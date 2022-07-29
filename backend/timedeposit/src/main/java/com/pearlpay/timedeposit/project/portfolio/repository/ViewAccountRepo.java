package com.pearlpay.timedeposit.project.portfolio.repository;

import com.pearlpay.timedeposit.project.portfolio.domain.TimeDepositAccountDomain;
import com.pearlpay.timedeposit.project.portfolio.domain.ViewAccountDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewAccountRepo extends JpaRepository<TimeDepositAccountDomain, Integer> {}
