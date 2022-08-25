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

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        accountDto.setCreatedAt(getCurrentDateTime());
        accountDto.setUpdatedAt(getCurrentDateTime());
        Account account = null;
        account.setCustomerId(accountDto.getCustomerId());
        account.setType(accountDto.getType());
//        Account account = toEntity(accountDto);
//        Account accountResult = repository.save(account);
        return  toDto(account);
    }
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

    @SneakyThrows
    @Override
    public AccountDto getaccountbyId(String accountid) {
        Account accountResult=repository.findById(accountid).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        return toDto(accountResult);

    }

    @Override
    public String deleteAccount(String accountId) {
        repository.deleteById(accountId);
        return "account deleted successfully.";
    }
}
