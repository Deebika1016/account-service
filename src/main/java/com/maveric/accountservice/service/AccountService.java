package com.maveric.accountservice.service;

import com.maveric.accountservice.dto.AccountDto;

import java.util.List;

public interface AccountService {

    public List<AccountDto> getAccountDetails();
    public AccountDto createAccount(AccountDto accountDto);
    public AccountDto getaccountbyId(String accountid);
    public AccountDto updateaccount(String accountId,AccountDto accountDto);
    public String deleteAccount(String accountId);
}
