package com.fudr.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@ManyToOne
	Customer customer;
	
	@ManyToOne
	AccountType accountType;
	
	LocalDateTime createdOn = LocalDateTime.now() ;
	
	
	float balance;
	
	public CustomerAccount(Customer customer,float balance,AccountType accountType){
		this.customer = customer;
		this.balance = balance;
		this.accountType = accountType;
		this.createdOn = LocalDateTime.now();
	}
	
}
