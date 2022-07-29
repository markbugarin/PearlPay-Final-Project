package com.pearlpay.timedeposit.project.portfolio.implementation;

import com.pearlpay.timedeposit.project.portfolio.domain.TimeDepositAccountDomain;
import com.pearlpay.timedeposit.project.portfolio.repository.TimeDepositAccountRepo;
import com.pearlpay.timedeposit.project.portfolio.service.TimeDepositAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
    public TimeDepositAccountDomain createAccount(TimeDepositAccountDomain timeDepositAccount) {
        return timeDepositAccountRepo.save(timeDepositAccount);
    }

    @Override
    public List<TimeDepositAccountDomain> findAllViewAccount() {
        return timeDepositAccountRepo.findAll();
    }
}
