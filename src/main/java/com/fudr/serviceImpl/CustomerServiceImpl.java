package com.fudr.serviceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fudr.entity.Customer;
import com.fudr.exception.EntityNotFoundException;
import com.fudr.repository.CustomerRepository;
import com.fudr.service.CustomerService;
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	@Override
	public Map<String, Object> create(Customer customer) {
		Map<String,Object> response = new HashMap<String, Object>();
		customer  = customerRepository.save(customer);
		response.put("customer", customer);
		// TODO Auto-generated method stub
		return response;
	}

	

	@Override
	public Map<String, Object> delete(int id) {
		Map<String,Object> response = new HashMap<String, Object>();
		Optional<Customer> customerOptional = this.customerRepository.findById(id);
		Customer customer = customerOptional.get();
		customer.setCustomerAccounts(null);
		customer = customerRepository.save(customer);
		customerRepository.delete(customer);
		return response;
	}



	@Override
	public Map<String, Object> update(Customer customer, int id) {
		Map<String,Object> response = new HashMap<String, Object>();
		Optional<Customer> customerOptional = this.customerRepository.findById(id);
		if(!customerOptional.isPresent()) {
			throw new EntityNotFoundException("invalid id",404);
		}
		Customer customerSaved = customerOptional.get();
		customerSaved.setPhoneNumber(customer.getPhoneNumber());
		customerSaved.setEmail(customer.getEmail());
		customerSaved.setAge(customer.getAge());
		customer = customerRepository.save(customer);
		response.put("customer", customer);
		return response;
	}



	@Override
	public Map<String, Object> findAll() {
		// TODO Auto-generated method stub
		return Map.of("customers",customerRepository.findAll());
	}

}
