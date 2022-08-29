package com.maveric.accountservice.service;



import com.maveric.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository repository;



    @Override
    public String deleteAccount(String accountId) {
        repository.deleteById(accountId);
        return "account deleted successfully.";
    }
}
