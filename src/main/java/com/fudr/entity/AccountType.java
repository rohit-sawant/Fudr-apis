package com.fudr.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@NotEmpty
	@NotBlank
	@Column(unique = true)
	String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "accountType")
	Set<CustomerAccount> customerAccounts;
	
	
}
