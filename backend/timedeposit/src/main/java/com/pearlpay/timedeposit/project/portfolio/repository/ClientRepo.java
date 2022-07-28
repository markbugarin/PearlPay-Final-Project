package com.pearlpay.timedeposit.project.portfolio.repository;

import com.pearlpay.timedeposit.project.portfolio.domain.ClientDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<ClientDomain, Integer > {
}
