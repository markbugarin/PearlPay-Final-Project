package com.pearlpay.timedeposit.implementation;

import com.pearlpay.timedeposit.domain.Checking;
import com.pearlpay.timedeposit.repo.CheckingRepo;
import com.pearlpay.timedeposit.service.CheckingService;
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
public class CheckingServiceImpl implements CheckingService {

    private final CheckingRepo checkingRepo;

    @Override
    public Checking createChecking(Checking checking) {
        return checkingRepo.save(checking);
    }

    @Override
    public List<Checking> findAllChecking() {
        return checkingRepo.findAll();
    }

    @Override
    public Checking getCheckin(Long id) {
        return checkingRepo.findById(id).get();
    }

    @Override
    public Checking updateChecking(Checking checking) {
        return checkingRepo.save(checking);
    }

    @Override
    public Boolean deleteChecking(Long id) {
        checkingRepo.deleteById(id);
        return TRUE;
    }
}
