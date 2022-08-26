package com.maveric.accountservice.service;

import com.maveric.accountservice.dto.AccountDto;

public interface AccountService {


    public List<AccountDto> getAccountDetails();


    public AccountDto getaccountbyId(String accountid);



}
