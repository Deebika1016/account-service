package com.maveric.accountservice.service;
import com.maveric.accountservice.Methods.Type;
import com.maveric.accountservice.model.Account;
import com.maveric.accountservice.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.maveric.accountservice.Methods.Type.valueOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountServiceImpTest {
    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private AccountServiceImp accountService;

    @Test
    void shouldReturnAccountWhenCreateAccountInvoked() {

        when(accountRepository.save(any())).thenReturn(getAccount());


        Account account = accountService.createAccount(getAccount());


        assertNotNull(account);
        assertSame(account.getType(),getAccount().getType());
    }


    private Account getAccount() {
        Account account = new Account();
        account.setAccountId("aswe");
        account.setCustomerId("3");
        account.setType(String.valueOf("CREDIT"));
        account.setCreatedAt("2022-08-27T10:45:49.520Z");
        account.setUpdatedAt("2022-08-27T10:45:49.520Z");

        return account;

    }

}

