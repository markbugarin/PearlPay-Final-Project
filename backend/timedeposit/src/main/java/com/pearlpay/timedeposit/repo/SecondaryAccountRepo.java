package com.pearlpay.timedeposit.repo;

import com.pearlpay.timedeposit.domain.SecondaryAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondaryAccountRepo extends JpaRepository<SecondaryAccount, Long> {
}
