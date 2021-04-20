package com.cognizant.policyService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.policyService.entity.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer>{
	
	Policy findByPolicyId(int id);
	
}
