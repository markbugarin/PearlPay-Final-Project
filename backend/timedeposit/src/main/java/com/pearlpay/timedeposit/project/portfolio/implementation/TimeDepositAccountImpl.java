package com.pearlpay.timedeposit.project.portfolio.implementation;

import com.pearlpay.timedeposit.project.portfolio.domain.TimeDepositAccount;
import com.pearlpay.timedeposit.project.portfolio.repository.TimeDepositAccountRepo;
import com.pearlpay.timedeposit.project.portfolio.service.TimeDepositAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class TimeDepositAccountImpl implements TimeDepositAccountService {

    private final TimeDepositAccountRepo timeDepositAccountRepo;

    @Autowired
    public TimeDepositAccountImpl(TimeDepositAccountRepo timeDepositAccountRepo) {
        this.timeDepositAccountRepo = timeDepositAccountRepo;
    }

    @Override
    public TimeDepositAccount createAccount(TimeDepositAccount timeDepositAccount) {
        return timeDepositAccountRepo.save(timeDepositAccount);
    }
}
