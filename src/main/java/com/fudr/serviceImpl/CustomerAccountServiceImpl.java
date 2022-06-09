package com.fudr.serviceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.fudr.bean.CustomerAccountBean;
import com.fudr.entity.AccountType;
import com.fudr.entity.Customer;
import com.fudr.entity.CustomerAccount;
import com.fudr.exception.BadRequestException;
import com.fudr.exception.EntityNotFoundException;
import com.fudr.repository.AccountTypeRepository;
import com.fudr.repository.CustomerAccountRepository;
import com.fudr.repository.CustomerRepository;
import com.fudr.service.CustomerAccountService;
@Service("CustomerAccountService")
public class CustomerAccountServiceImpl implements CustomerAccountService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountTypeRepository accountTypeRepository;
	
	@Autowired
	CustomerAccountRepository customerAccountRepository;
	
	@Override
	public Map<String, Object> create(CustomerAccountBean customerAccountBean)  {
		Map<String,Object> response = new HashMap<>();
		Optional<Customer> customerOptional = this.customerRepository.findById(customerAccountBean.getCustomerId());
		Optional<AccountType> accountTypeOptional = this.accountTypeRepository.findById(customerAccountBean.getAccountTypeId());
		if(!customerOptional.isPresent()) {
			throw new EntityNotFoundException("customer id invalid",404);
			
		}
		if(!accountTypeOptional.isPresent())
		{
			throw new EntityNotFoundException("account id invalid",404);
		}
		System.out.println("created");
		CustomerAccount customerAccount = new CustomerAccount(customerOptional.get(),0,accountTypeOptional.get());
		customerAccount = this.customerAccountRepository.save(customerAccount);
		
		response.put("customerAccount", customerAccount);
		return response;
	}

	@Override
	public Map<String, Object> getAccountBalance(int id)  {
		Map<String,Object> response = new HashMap<>();
		Optional<CustomerAccount> customerAccountOptional = this.customerAccountRepository.findById(id);
		if(!customerAccountOptional.isPresent()) {
			throw new EntityNotFoundException("invalid Account id",404);
		}
		CustomerAccount customerAccount = customerAccountOptional.get();
		if(customerAccount.getAccountType().getName().equalsIgnoreCase("loan")) {
			throw new BadRequestException("it is loan account",400);
		}
		response.put("balance",customerAccount.getBalance());
		return response;
	}

	@Override
	public Map<String, Object> findAll() {
		// TODO Auto-generated method stub
		return Map.of("accounts",customerAccountRepository.findAll());
		
	}

	@Override
	public Map<String, Object> updateBalance(int balance, int id) {
		// TODO Auto-generated method stub
//		Opional<CustomerAccount> update = this.customerAccountRepository.findById(id);
//		
//		Optional<CustomerAccount> customerAccountOptional = this.customerAccountRepository.findById(id);
//		if(!customerAccountOptional.isPresent()) {
//			throw new EntityNotFoundException("invalid Account id",404);
//		}
//		CustomerAccount customeAccount =  customerAccountOptional.get();
//		customeAccount.setBalance(balance);
		return Map.of();
	}

}
