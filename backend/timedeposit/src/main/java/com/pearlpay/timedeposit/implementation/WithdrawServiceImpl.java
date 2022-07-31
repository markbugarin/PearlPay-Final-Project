package com.pearlpay.timedeposit.implementation;

import com.pearlpay.timedeposit.domain.Withdraw;
import com.pearlpay.timedeposit.repo.WithdrawRepo;
import com.pearlpay.timedeposit.service.WithdrawService;
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
public class WithdrawServiceImpl implements WithdrawService {
    private final WithdrawRepo withdrawRepo;
    @Override
    public Withdraw createWithdraw(Withdraw withdraw) {
        return withdrawRepo.save(withdraw);
    }

    @Override
    public List<Withdraw> findAllWithdraws() {
        return withdrawRepo.findAll();
    }

    @Override
    public Withdraw getWithdraw(Long id) {
        return withdrawRepo.findById(id).get();
    }

    @Override
    public Withdraw updateWithdraw(Withdraw withdraw) {
        return withdrawRepo.save(withdraw);
    }

    @Override
    public Boolean deleteWithdraw(Long id) {
        withdrawRepo.deleteById(id);
        return TRUE;
    }
}
