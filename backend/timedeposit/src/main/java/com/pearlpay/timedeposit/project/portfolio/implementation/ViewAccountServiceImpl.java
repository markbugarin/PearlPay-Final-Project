package com.pearlpay.timedeposit.project.portfolio.implementation;

import com.pearlpay.timedeposit.project.portfolio.domain.TimeDepositAccountDomain;
import com.pearlpay.timedeposit.project.portfolio.repository.ViewAccountRepo;
import com.pearlpay.timedeposit.project.portfolio.service.ViewAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
@Slf4j
public class ViewAccountServiceImpl implements ViewAccountService {
    private final ViewAccountRepo viewAccountRepo;

    @Autowired
    public ViewAccountServiceImpl(ViewAccountRepo viewAccountRepo) {
        this.viewAccountRepo = viewAccountRepo;
    }

    @Override
    public List<TimeDepositAccountDomain> findAllAccounts() {
        return viewAccountRepo.findAll();
    }
}
