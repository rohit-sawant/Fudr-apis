package com.fudr.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.fudr.entity.Customer;
@Service
public interface CustomerService {
Map<String,Object> create(Customer customer);
Map<String,Object> update(Customer customer,int id);
Map<String,Object> delete(int id);
Map<String,Object> findAll();
}
