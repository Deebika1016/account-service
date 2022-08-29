package com.maveric.accountservice.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Document(collection = "Account")
public class Account {
   @Id
   private String accountId;
   private String customerId;
   private String type;
   private String createdAt;
   private String updatedAt;
}
