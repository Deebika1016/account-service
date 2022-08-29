package com.maveric.accountservice.service;


import com.maveric.accountservice.model.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface AccountService {

    public List<Account> getAccountDetails();
    public Account createAccount(Account account);
    public Account getAccountById(String accountid) throws AccountNotFoundException;
    public Account upDateAccount(String accountId,Account account) throws AccountNotFoundException;
    public String deleteAccount(String accountId);
}
