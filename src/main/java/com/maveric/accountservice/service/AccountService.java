package com.maveric.accountservice.service;

import com.maveric.accountservice.dto.AccountDto;

public interface AccountService {




   
    public AccountDto updateaccount(String accountId,AccountDto accountDto);

    public List<AccountDto> getAccountDetails();


    public AccountDto getaccountbyId(String accountid);




}
