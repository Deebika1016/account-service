package com.maveric.accountservice.service;


import com.maveric.accountservice.model.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface AccountService {


    public Account createAccount(Account account);

}
