package com.fudr.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CustomerAccountBean {

	int customerId;
	int accountTypeId;
	String accountType;
	
}
