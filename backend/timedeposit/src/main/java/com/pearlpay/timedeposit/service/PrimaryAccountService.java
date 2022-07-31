package com.pearlpay.timedeposit.service;

import com.pearlpay.timedeposit.domain.PrimaryAccount;

import java.util.List;

public interface PrimaryAccountService {
    PrimaryAccount createAccount(PrimaryAccount primaryAccount);

    List<PrimaryAccount> findAllAccounts();

    PrimaryAccount getAccount(Long id);

    PrimaryAccount updateAccount(PrimaryAccount primaryAccount);

    Boolean deleteAccount(Long id);
}
