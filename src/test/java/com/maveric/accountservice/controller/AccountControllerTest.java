package com.maveric.accountservice.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maveric.accountservice.model.Account;
import com.maveric.accountservice.repository.AccountRepository;
import com.maveric.accountservice.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import javax.ws.rs.core.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    ObjectMapper map;
    @MockBean
    private AccountService mockService;
    @MockBean
    private AccountRepository mockRepo;


    @Test
    void shouldGetAccountsWhenRequestMadeToGetAccounts() throws Exception {
        mvc.perform(get("/api/v1/customers/" + "10" + "/accounts").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

    }

    

    @Test
    void createAccount() throws Exception {
        Account account = new Account();
        account.setAccountId("123");
        account.setCustomerId("123");
        account.setCreatedAt("2022-08-27T10:45:49.520Z");
        account.setUpdatedAt("2022-08-27T10:45:49.520Z");

        mvc.perform(post("/api/v1/customers/" + "10" + "/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(map.writeValueAsBytes(account)))
                .andExpect(status().isCreated())
                .andDo(print());

    }

    @Test
    void shouldGetAccountDetailsbyGetAccountsById() throws Exception {

        mvc.perform(get("/api/v1/customers/" + "10" + "/accounts/" + "123").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void UpdateAccount() throws Exception {
        Account account = new Account();
        account.setAccountId("123");
        account.setCustomerId("123");
        account.setCreatedAt("2022-08-27T10:45:49.520Z");
        account.setUpdatedAt("2022-08-27T10:45:49.520Z");

        mvc.perform(put("/api/v1/customers/" + "10" + "/accounts/" + "10")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(map.writeValueAsBytes(account)))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    void deleteAccount() throws Exception {

        mvc.perform(delete("/api/v1/customers/" + "10" + "/accounts/" + "123").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    void shouldgetMethodNotAllowedForIncorrectUrl() throws Exception {

        mvc.perform(delete("/api/v1/customers/" + "10" + "/accounts/"))
                .andExpect(status().isMethodNotAllowed())
                .andDo(print());
    }

}


