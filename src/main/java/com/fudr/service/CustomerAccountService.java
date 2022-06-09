package com.fudr.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.fudr.bean.CustomerAccountBean;
@Service
public interface CustomerAccountService {

Map<String,Object> getAccountBalance(int id) ;
Map<String, Object> create(CustomerAccountBean customerAccountBean);
Map<String,Object> findAll();
Map<String,Object> updateBalance(int balance,int id);
}
