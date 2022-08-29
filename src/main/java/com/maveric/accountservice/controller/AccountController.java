package com.maveric.accountservice.controller;

import com.maveric.accountservice.model.Account;
import com.maveric.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    AccountService accountService;
    @GetMapping("/customers/{customerId}/accounts")
    public ResponseEntity<List<Account>> getAccountdetails(@PathVariable String customerId, @RequestParam(defaultValue = "0") Integer page,
                                                           @RequestParam(defaultValue = "10") Integer pageSize) {
        List<Account> accountresult = accountService.getAccountDetails();
        return new ResponseEntity<>(accountresult, HttpStatus.OK);
    }



  

}
