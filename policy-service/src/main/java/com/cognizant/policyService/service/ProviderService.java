package com.cognizant.policyService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.policyService.entity.Provider;
import com.cognizant.policyService.repository.ProviderRepository;

@Service
public class ProviderService {
	
	@Autowired
	private ProviderRepository providerRepository;
	
	public List<Provider> getAllProvidersByLocation(String location) {
		return providerRepository.findByLocation(location);
	}
	
	public List<Provider> getAllProviders(){
		return providerRepository.findAll();
	}
	
}
