package com.fudr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fudr.entity.AccountType;
@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Integer>{

}
