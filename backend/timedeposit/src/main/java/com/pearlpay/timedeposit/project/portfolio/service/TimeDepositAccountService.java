package com.pearlpay.timedeposit.project.portfolio.service;

import com.pearlpay.timedeposit.project.portfolio.domain.ClientDomain;
import com.pearlpay.timedeposit.project.portfolio.domain.TimeDepositAccount;

public interface TimeDepositAccountService {
    TimeDepositAccount createAccount(TimeDepositAccount timeDepositAccount);
}
