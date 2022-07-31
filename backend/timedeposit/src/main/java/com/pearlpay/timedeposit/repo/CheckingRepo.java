package com.pearlpay.timedeposit.repo;

import com.pearlpay.timedeposit.domain.Checking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckingRepo extends JpaRepository<Checking, Long> {
}
