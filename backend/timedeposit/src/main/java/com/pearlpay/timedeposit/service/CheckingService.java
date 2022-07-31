package com.pearlpay.timedeposit.service;

import com.pearlpay.timedeposit.domain.Checking;

import java.util.List;

public interface CheckingService {
    Checking createChecking(Checking checking);

    List<Checking> findAllChecking();

    Checking getCheckin(Long id);

    Checking updateChecking(Checking checking);

    Boolean deleteChecking(Long id);
}
