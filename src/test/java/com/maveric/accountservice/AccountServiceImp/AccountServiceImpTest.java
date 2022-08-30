package com.maveric.accountservice.AccountServiceImp;
import com.maveric.accountservice.Methods.Type;
import com.maveric.accountservice.model.Account;
import com.maveric.accountservice.repository.AccountRepository;
import com.maveric.accountservice.service.AccountServiceImp;
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
    void shouldReturnAccountsWhenAccountsNotEmptyInDb(){
        List<Account> account = new ArrayList<Account>();
        account.add(getAccount());
        when(accountRepository.findAll()).thenReturn(account);
        assertFalse(accountService.getAccountDetails().isEmpty());

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
