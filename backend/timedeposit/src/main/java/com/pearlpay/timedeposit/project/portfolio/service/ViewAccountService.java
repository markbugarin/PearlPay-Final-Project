package com.pearlpay.timedeposit.project.portfolio.service;

import com.pearlpay.timedeposit.project.portfolio.domain.TimeDepositAccountDomain;

import java.util.List;

public interface ViewAccountService {
    List<TimeDepositAccountDomain> findAllAccounts();
}
