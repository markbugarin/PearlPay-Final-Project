package com.pearlpay.timedeposit.repo;

import com.pearlpay.timedeposit.domain.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawRepo extends JpaRepository<Withdraw, Long> {
}
