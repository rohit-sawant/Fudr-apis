package com.fudr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fudr.bean.Response;
import com.fudr.bean.Status;
import com.fudr.entity.Customer;
import com.fudr.service.CustomerService;
@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/fudr/customer")
	ResponseEntity<Response> create(@RequestBody Customer customer){
		
		return new ResponseEntity<Response>(new Response(Status.success.name(),"",customerService.create(customer)),HttpStatus.CREATED);
		
	}
	
	@PutMapping("/fudr/customer/{id}")
	ResponseEntity<Response> update(@RequestBody Customer customer,@PathVariable("id")int id){
		return new ResponseEntity<Response>(new Response(Status.success.name(),"",customerService.update(customer,id)),HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/fudr/customer/{id}")
	ResponseEntity<Response> delete(@PathVariable("id")int id){
		return new ResponseEntity<Response>(new Response(Status.success.name(),"",customerService.delete(id)),HttpStatus.OK);
		
	}
	
	@GetMapping("/fudr/customers")
	ResponseEntity<Response> findAll(){
		return new ResponseEntity<Response>(new Response(Status.success.name(),"",customerService.findAll()),HttpStatus.OK);
		
	}
}
