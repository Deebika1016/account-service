package com.maveric.accountservice.service;

import com.maveric.accountservice.dto.AccountDto;
import com.maveric.accountservice.model.Account;
import com.maveric.accountservice.repository.AccountRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;


import static com.maveric.accountservice.Methods.MapModelandDto.getCurrentDateTime;


import static com.maveric.accountservice.Methods.MapModelandDto.toDto;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository repository;






    @SneakyThrows
    @Override
    public AccountDto updateaccount(String accountId,AccountDto accountDto)
    {
        Account accountResult=repository.findById(accountId).orElseThrow(() -> new AccountNotFoundException("Account not found"));
       // Account accountResult=repository.findById(accountId).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        accountResult.setAccountId(accountResult.getAccountId());
        accountResult.setCustomerId(accountDto.getCustomerId());
        accountResult.setType(accountDto.getType());
        accountResult.setCreatedAt(accountResult.getCreatedAt());
        accountResult.setUpdatedAt(getCurrentDateTime());
        Account accountUpdated = repository.save(accountResult);
        return toDto(accountUpdated);
    }








}
