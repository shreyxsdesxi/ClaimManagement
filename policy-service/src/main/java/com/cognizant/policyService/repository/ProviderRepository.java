package com.cognizant.policyService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.policyService.entity.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Integer>{
	
	List<Provider> findByLocation(String location);
	
	
}
