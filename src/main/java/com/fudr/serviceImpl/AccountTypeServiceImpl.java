package com.fudr.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fudr.entity.AccountType;
import com.fudr.repository.AccountTypeRepository;
import com.fudr.service.AccountTypeService;
@Service("AccountTypeService")
public class AccountTypeServiceImpl implements AccountTypeService {

	@Autowired
	AccountTypeRepository accountTypeRepository;
	@Override
	public Map<String, Object> create(String name) {
		Map<String,Object> response = new HashMap<String, Object>();
		AccountType accountType = new AccountType(0, name.toLowerCase(), null);
		accountType = accountTypeRepository.save(accountType);
		response.put("accountType",accountType);
		return response;
	}
	@Override
	public Map<String, Object> findAll() {
		// TODO: get all the account type
		return Map.of("accountTypes",accountTypeRepository.findAll());
	}

}
