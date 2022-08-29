package com.maveric.accountservice.service;


import com.maveric.accountservice.model.Account;
import com.maveric.accountservice.repository.AccountRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;


import static com.maveric.accountservice.Methods.Methods.getCurrentDateTime;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository repository;



    @Override
    public Account upDateAccount(String accountId, Account account) throws AccountNotFoundException {
        Account accountResult=repository.findById(accountId).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        accountResult.setAccountId(account.getAccountId());
        accountResult.setCustomerId(account.getCustomerId());
        accountResult.setType(account.getType());
        accountResult.setCreatedAt(account.getCreatedAt());
        accountResult.setUpdatedAt(getCurrentDateTime());
        return repository.save(accountResult);
    }








}
