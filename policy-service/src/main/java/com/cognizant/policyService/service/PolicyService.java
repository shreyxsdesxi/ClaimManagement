package com.cognizant.policyService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.policyService.entity.Policy;
import com.cognizant.policyService.repository.PolicyRepository;

@Service
public class PolicyService {
	
	@Autowired
	private PolicyRepository policyRepository;
	
	public Policy getPolicy(int id) {
		return policyRepository.findByPolicyId(id);
	}
}
