package com.fudr.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
@Entity
@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Customer {
// name, email, phoneNumber, age
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@NotEmpty(message = "Name cannot be empty")
	@NotBlank(message = "Name cannot be blank")
	String name;
	
	@Email(message = "invalid email")
	@Column(unique=true)
	String email;
	
	@Pattern(regexp = "(^$|[0-9]{10})",message = "invalid phone number")
	@Column(unique=true)
	String phoneNumber;
	
	@Positive(message = "Please enter valid age")
	int age;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	Set<CustomerAccount> customerAccounts;
}
