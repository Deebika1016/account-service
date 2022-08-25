package com.maveric.accountservice.service;

import com.maveric.accountservice.dto.AccountDto;
import com.maveric.accountservice.model.Account;
import com.maveric.accountservice.repository.AccountRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;

import static com.maveric.accountservice.Methods.MapModelandDto.toDto;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository repository;








    @SneakyThrows
    @Override
    public AccountDto getaccountbyId(String accountid) {
        Account accountResult=repository.findById(accountid).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        return toDto(accountResult);

    }


}
