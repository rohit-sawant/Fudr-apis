package com.fudr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fudr.bean.CustomerAccountBean;
import com.fudr.bean.Response;
import com.fudr.bean.Status;
import com.fudr.service.CustomerAccountService;

@RestController
public class CustomerAccountController {

	@Autowired
	CustomerAccountService customerAccountService;
	
	@PostMapping("/fudr/customerAccountService")
	ResponseEntity<Response> create(@RequestBody CustomerAccountBean customerAccountBean){
		return new ResponseEntity<Response>(new Response(Status.success.name(),"",customerAccountService.create(customerAccountBean)),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/fudr/customerAccountServices")
	ResponseEntity<Response> findAll(){
		return new ResponseEntity<Response>(new Response(Status.success.name(),"",customerAccountService.findAll()),HttpStatus.OK);
		
	}
	
	@GetMapping("/fudr/customerAccountService/{id}/balance")
	ResponseEntity<Response> getAccountBalance(@PathVariable("id") int id){
		return new ResponseEntity<Response>(new Response(Status.success.name(),"",customerAccountService.getAccountBalance(id)),HttpStatus.OK);
		
	}
	
}
