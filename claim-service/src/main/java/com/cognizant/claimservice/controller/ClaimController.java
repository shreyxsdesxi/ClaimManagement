package com.cognizant.claimservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cognizant.claimservice.model.Claims;
import com.cognizant.claimservice.model.Provider;
import com.cognizant.claimservice.service.ClaimService;

import antlr.collections.List;

@RestController
public class ClaimController {
	
	@Autowired
	private ClaimService claimService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClaimController.class); 
	
	@GetMapping ("/getClaimStatus/{claimId}")
	public <Claim> List findAllClaimByClaimID(@PathVariable int claimId) {
		return ClaimService.getALLClaimByClaimId(claimId);
		
	}

	@GetMapping ("/getClaimStatus/{memberId}")
	public <Claim> List findAllClaimByMemberID(@PathVariable int memberId) {
		return ClaimService.getALLClaimByMemberId(memberId);	
	}
	@GetMapping ("/getClaimStatus/{policyId}")
	public <Claim> List findAllClaimByPolicyID(@PathVariable int policyId) {
		return ClaimService.getALLClaimByPolicyId(policyId);
		
	}
	
	@GetMapping(value = "/getClaimStatus/{policyId}/{memberId}/{claimNumber}")
	public String getStatus(@PathVariable String policyId, @PathVariable String memberId, @PathVariable String claimNumber) {
		int c  = Integer.parseInt(claimNumber);
		int p = Integer.parseInt(policyId);
		int m = Integer.parseInt(memberId);
		Claims claim = claimService.getClaim(c, m, p);
		return claim.getStatus();
	}
	
	@PostMapping(value = "/submitClaim/{policyId}/{memberId}")
	public String submitClaim(@PathVariable int policyId, @PathVariable int memberId, @RequestBody Claims claim) {
		//claimService.saveClaim(claim);
		
		HashMap<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("policyId", policyId);
		uriVariables.put("memberId", memberId);
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Integer> forEntity = rt.getForEntity("http://localhost:8002/getEligibleClaimAmount/{policyId}/{memberId}", Integer.class, uriVariables);
		int elegibleAmount = forEntity.getBody();
		
		ResponseEntity<Provider[]> forEntity2 = rt.getForEntity("http://localhost:8002/getChainOfProviders/{policyId}", Provider[].class, uriVariables);
		Provider[] body = forEntity2.getBody();
		
		int claimedAmount = claim.getAmountClaimed();
		int hospitalId  = claim.getHospitalId();
		
		LOGGER.info("Elegible amount: {}", elegibleAmount);
		LOGGER.info("Hospitals: {}", body);
		LOGGER.info("claimedAmount: {}", claimedAmount);
		LOGGER.info("hospitalId {}", hospitalId);
		
		boolean claimFlag = false;
		boolean hospitalFlag = false;
		
		if(elegibleAmount >= claimedAmount) {
			claimFlag = true;
		}
		
		for(int i = 0; i < body.length; i++) {
			if(body[i].getHospitalId() == hospitalId) {
				hospitalFlag = true;
				break;
			}
		}
		
		String result = "In process";
		
		if(claimFlag == true && hospitalFlag ==true) {
			result = "Approved";
		}
		else {
			result = "Disapproved";
		}
		claim.setStatus(result);
		claim.setPolicyNumber(policyId);
		claim.setMemberId(memberId);
		claimService.saveClaim(claim);
		return result;
		
		
	}
}
