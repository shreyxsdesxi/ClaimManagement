package com.cognizant.policyService.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.policyService.entity.Member;
import com.cognizant.policyService.entity.Policy;
import com.cognizant.policyService.entity.Provider;
import com.cognizant.policyService.service.MemberService;
import com.cognizant.policyService.service.PolicyService;
import com.cognizant.policyService.service.ProviderService;

@RestController

public class PolicyController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PolicyController.class);

	@Autowired
	private PolicyService policyService;

	@Autowired
	private ProviderService providerService;

	@Autowired
	private MemberService memberService;

//	@Autowired
//	private ClaimService claimService;
//	
//	@GetMapping(value = "/{memberId}")
//	public List<Claim> getClaims(@PathVariable int memberId){
//		List<Claim> allClaimsWithMemberId = claimService.getAllClaimsWithMemberId(memberId);
//		LOGGER.info("Claims: {}", allClaimsWithMemberId);
//		return allClaimsWithMemberId;
//	}

//	@GetMapping(value = "/test/{id}")
//	public List<PolicyMember> getPolicy(@PathVariable int id){
//		Policy policy = policyService.getPolicy(id);
//		return policyMemberService.findAllPolicy(policy);
//	}
//	
//	@GetMapping(value = "/policy")
//	public String test() {
//		
//		return "From Policy Service";
//		
//	}

	@GetMapping(value = "/getChainOfProviders")
	public List<Provider> findAllProviders() {
		return providerService.getAllProviders();
	}

//	@GetMapping(value = "/getChainOfProviders/{location}")
//	public List<Provider> findAllProvidersByLocation(@PathVariable String location){
//		return providerService.getAllProvidersByLocation(location);
//	}

	@GetMapping(value = "/getChainOfProviders/{policyId}")
	public List<Provider> findAllProvidersByPolicyId(@PathVariable int policyId) {
		List<Provider> result = new ArrayList<>();
		List<Provider> allProviders = providerService.getAllProviders();
		for (int i = 0; i < allProviders.size(); i++) {
			List<Policy> tempList = new ArrayList<>();
			Set<Policy> setPolicy = allProviders.get(i).getPolicyList();
			for (Policy p : setPolicy) {
				tempList.add(p);
			}
			for (int k = 0; k < tempList.size(); k++) {
				if (tempList.get(k).getPolicyId() == policyId) {
					result.add(allProviders.get(i));
				}
			}
		}
		return result;
	}

	@GetMapping(value = "/getEligibleBenefits/{policyId}/{memberId}")
	public ResponseEntity<String> getBenefitsOfPolicy(@PathVariable int policyId, @PathVariable int memberId) {
		Member member = memberService.getMemberById(memberId);
		Set<Policy> policySet = member.getPolicyMembersList();

		List<Policy> tempPolicy = new ArrayList<>();

		for (Policy p : policySet) {
			tempPolicy.add(p);
		}

		String result = "";

		for (int i = 0; i < tempPolicy.size(); i++) {
			if (tempPolicy.get(i).getPolicyId() == policyId) {
				result = tempPolicy.get(i).getBenefits();
			}
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);

	}

	@GetMapping(value = "/getEligibleClaimAmount/{policyId}/{memberId}")
	public ResponseEntity<Integer> getElegibleClaim(@PathVariable int policyId, @PathVariable int memberId) {
		Member member = memberService.getMemberById(memberId);

		Set<Policy> policySet = member.getPolicyMembersList();

		List<Policy> tempPolicy = new ArrayList<>();

		for (Policy p : policySet) {
			tempPolicy.add(p);
		}
		
		int result = Integer.MIN_VALUE;
		
		for (int i = 0; i < tempPolicy.size(); i++) {
			if (tempPolicy.get(i).getPolicyId() == policyId) {
				result = tempPolicy.get(i).getElegibleAmount();
			}
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);

	}

}
