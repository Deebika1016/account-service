package com.maveric.accountservice.controller;
import com.maveric.accountservice.model.Account;
import com.maveric.accountservice.service.AccountService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;


@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    AccountService accountService;





    @RequestMapping(value = "customers/{customerId}/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<Account> updateAccount(@PathVariable String customerId, @PathVariable String accountId, @RequestBody Account account) throws AccountNotFoundException {

        return new ResponseEntity<Account>(accountService.upDateAccount(accountId,account), HttpStatus.OK);
    }



}
