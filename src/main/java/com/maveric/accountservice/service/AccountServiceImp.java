package com.maveric.accountservice.service;

import com.maveric.accountservice.dto.AccountDto;
import com.maveric.accountservice.model.Account;
import com.maveric.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.maveric.accountservice.Methods.MapModelandDto.toDto;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository repository;


    @Override
    public List<Account> getAccountDetails() {

        return repository.findAll();}


}
