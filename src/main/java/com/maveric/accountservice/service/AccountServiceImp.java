package com.maveric.accountservice.service;


import com.maveric.accountservice.model.Account;
import com.maveric.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import static com.maveric.accountservice.Methods.Methods.*;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository repository;

    @Override
    public List<Account> getAccountDetails() {

        return repository.findAll();}

    @Override
    public Account createAccount(Account account) {
        account.setCreatedAt(getCurrentDateTime());
        account.setUpdatedAt(getCurrentDateTime());

        Account accountResult = repository.save(account);
        return  accountResult;
    }

    @Override
    public Account upDateAccount(String accountId,Account account) throws AccountNotFoundException {
        Account accountResult=repository.findById(accountId).orElseThrow(() -> new AccountNotFoundException("Account not found"));
       accountResult.setAccountId(account.getAccountId());
       accountResult.setCustomerId(account.getCustomerId());
       accountResult.setType(account.getType());
       accountResult.setCreatedAt(account.getCreatedAt());
       accountResult.setUpdatedAt(getCurrentDateTime());
        return repository.save(accountResult);
    }


    @Override
    public Account getAccountById(String accountid) throws AccountNotFoundException {
        Account accountResult=repository.findById(accountid).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        return accountResult;

    }

    @Override
    public String deleteAccount(String accountId) {
        repository.deleteById(accountId);
        return "account deleted successfully.";
    }
}
