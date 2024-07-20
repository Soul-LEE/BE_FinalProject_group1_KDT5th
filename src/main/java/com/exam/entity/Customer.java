package com.exam.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
public class Customer {

   @Id
   int customer_id;
   String username;
   String userid; 
   String userpw; 
   String addr1; 
   String addr2; 
   String post; 
   String email1; 
   String email2;
   String phone1;
   String phone2;
   String phone3; 
   int points;
   LocalDate birthdate;
}
