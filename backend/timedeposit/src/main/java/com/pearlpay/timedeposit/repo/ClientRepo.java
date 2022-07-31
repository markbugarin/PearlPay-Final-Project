package com.pearlpay.timedeposit.repo;

import com.pearlpay.timedeposit.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
