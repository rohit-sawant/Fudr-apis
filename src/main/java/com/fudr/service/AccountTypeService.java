package com.fudr.service;

import java.util.Map;

import org.springframework.stereotype.Service;
@Service
public interface AccountTypeService {
Map<String,Object> create(String name);

Map<String,Object> findAll();


}
