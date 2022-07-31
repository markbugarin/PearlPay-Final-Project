package com.pearlpay.timedeposit.service;

import com.pearlpay.timedeposit.domain.SecondaryAccount;

import java.util.List;

public interface SecondaryAccountService {
    SecondaryAccount createSecondAccount(SecondaryAccount secondaryAccount);

    List<SecondaryAccount> findAllSecondAccounts();

    SecondaryAccount getSecondAccount(Long id);

    SecondaryAccount updateSecondAccount(SecondaryAccount secondaryAccount);

    Boolean deleteSecondAccount(Long id);
}
