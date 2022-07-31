package com.pearlpay.timedeposit.repo;

import com.pearlpay.timedeposit.domain.PrimaryAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryAccountRepo extends JpaRepository<PrimaryAccount, Long> {
}
