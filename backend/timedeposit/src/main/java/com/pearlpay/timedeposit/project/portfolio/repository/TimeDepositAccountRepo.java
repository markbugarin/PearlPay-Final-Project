package com.pearlpay.timedeposit.project.portfolio.repository;

import com.pearlpay.timedeposit.project.portfolio.domain.TimeDepositAccountDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeDepositAccountRepo extends JpaRepository<TimeDepositAccountDomain,Long> {
}
