package com.maveric.accountservice.controller;

import com.maveric.accountservice.model.Account;
import com.maveric.accountservice.service.AccountService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    AccountService accountService;
    @GetMapping("/customers/{customerId}/accounts")
    public ResponseEntity<List<Account>> getAccountdetails(@PathVariable String customerId, @RequestParam(defaultValue = "0") Integer page,
                                                           @RequestParam(defaultValue = "10") Integer pageSize) {

  
   @PostMapping("/customers/{customerId}/accounts")
   public ResponseEntity<Account> createAccount(@PathVariable String customerId, @RequestBody Account account) {
       Account accountdtoresult = accountService.createAccount(account);
       return new ResponseEntity<Account>(accountdtoresult, HttpStatus.CREATED);
   }
   @GetMapping("/customers/{customerId}/accounts/{accountId}")
   public ResponseEntity<Account> getaccountbtId(@PathVariable String customerId ,@PathVariable String accountId) throws AccountNotFoundException {
        Account result = accountService.getAccountById(accountId);
        return new ResponseEntity<Account>(result,HttpStatus.OK);
   }
   @DeleteMapping("/customers/{customerId}/accounts/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable String customerId, @PathVariable String accountId){
        String result = accountService.deleteAccount(accountId);
       return new ResponseEntity<String>(result, HttpStatus.OK);
   }
    
    @RequestMapping(value = "customers/{customerId}/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<Account> updateAccount(@PathVariable String customerId,@PathVariable String accountId,@RequestBody Account account) throws Exception {

        return new ResponseEntity<Account>(accountService.upDateAccount(accountId,account), HttpStatus.OK);

    }



  

}
