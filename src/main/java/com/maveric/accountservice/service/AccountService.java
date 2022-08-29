package com.maveric.accountservice.service;


import com.maveric.accountservice.model.Account;
import lombok.SneakyThrows;

import javax.security.auth.login.AccountNotFoundException;

public interface AccountService {



    Account upDateAccount(String accountId, Account account) throws AccountNotFoundException;
}
