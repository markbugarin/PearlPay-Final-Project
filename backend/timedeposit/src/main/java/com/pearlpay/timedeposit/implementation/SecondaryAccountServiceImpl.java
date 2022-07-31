package com.pearlpay.timedeposit.implementation;

import com.pearlpay.timedeposit.domain.SecondaryAccount;
import com.pearlpay.timedeposit.repo.SecondaryAccountRepo;
import com.pearlpay.timedeposit.service.SecondaryAccountService;
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
public class SecondaryAccountServiceImpl implements SecondaryAccountService {
    private final SecondaryAccountRepo secondaryAccountRepo;
    @Override
    public SecondaryAccount createSecondAccount(SecondaryAccount secondaryAccount) {
        return secondaryAccountRepo.save(secondaryAccount);
    }

    @Override
    public List<SecondaryAccount> findAllSecondAccounts() {
        return secondaryAccountRepo.findAll();
    }

    @Override
    public SecondaryAccount getSecondAccount(Long id) {
        return secondaryAccountRepo.findById(id).get();
    }

    @Override
    public SecondaryAccount updateSecondAccount(SecondaryAccount secondaryAccount) {
        return secondaryAccountRepo.save(secondaryAccount);
    }

    @Override
    public Boolean deleteSecondAccount(Long id) {
        secondaryAccountRepo.deleteById(id);
        return TRUE;
    }
}
