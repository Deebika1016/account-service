package com.maveric.accountservice.service;

import com.maveric.accountservice.dto.AccountDto;
import com.maveric.accountservice.model.Account;
import com.maveric.accountservice.repository.AccountRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.maveric.accountservice.Methods.MapModelandDto.*;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository repository;

    @Override
    public List<AccountDto> getAccountDetails() {
        List<Account> list= repository.findAll();
        List<AccountDto> listdto =new ArrayList<AccountDto>(list.size());
        for(Account account:list)
        {
            listdto.add(toDto(account));
        }
        return  listdto;
    }





}
