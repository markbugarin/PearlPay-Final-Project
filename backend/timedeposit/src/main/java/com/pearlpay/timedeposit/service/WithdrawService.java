package com.pearlpay.timedeposit.service;

import com.pearlpay.timedeposit.domain.Withdraw;

import java.util.List;

public interface WithdrawService {
    Withdraw createWithdraw(Withdraw withdraw);

    List<Withdraw> findAllWithdraws();

    Withdraw getWithdraw(Long id);

    Withdraw updateWithdraw(Withdraw withdraw);

    Boolean deleteWithdraw(Long id);
}
