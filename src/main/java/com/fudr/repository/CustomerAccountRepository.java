package com.fudr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fudr.entity.CustomerAccount;
@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Integer>{

}
