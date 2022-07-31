package com.pearlpay.timedeposit.implementation;

import com.pearlpay.timedeposit.domain.PrimaryAccount;
import com.pearlpay.timedeposit.repo.PrimaryAccountRepo;
import com.pearlpay.timedeposit.service.PrimaryAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class PrimaryAccountServiceImpl implements PrimaryAccountService {
    private final PrimaryAccountRepo primaryAccountRepo;
    @Override
    public PrimaryAccount createAccount(PrimaryAccount primaryAccount) {
        return primaryAccountRepo.save(primaryAccount);
    }

    @Override
    public List<PrimaryAccount> findAllAccounts() {
        return primaryAccountRepo.findAll();
    }

    @Override
    public PrimaryAccount getAccount(Long id) {
        return primaryAccountRepo.findById(id).get();
    }

    @Override
    public PrimaryAccount updateAccount(PrimaryAccount primaryAccount) {
        return primaryAccountRepo.save(primaryAccount);
    }

    @Override
    public Boolean deleteAccount(Long id) {
        primaryAccountRepo.deleteById(id);
        return TRUE;
    }
}
