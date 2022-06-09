package com.fudr.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fudr.bean.Response;
import com.fudr.bean.Status;
import com.fudr.entity.Customer;
import com.fudr.service.AccountTypeService;

@RestController
public class AccountTypeController {

	@Autowired
	AccountTypeService accountTypeService;
	
	@PostMapping("/fudr/accountType")
	ResponseEntity<Response> create(@RequestBody Map<String,String> request){
		return new ResponseEntity<Response>(new Response(Status.success.name(),"",accountTypeService.create(request.get("name"))),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/fudr/accountTypes")
	ResponseEntity<Response> findAll(){
		return new ResponseEntity<Response>(new Response(Status.success.name(),"",accountTypeService.findAll()),HttpStatus.OK);
		
	}
	
	
}
