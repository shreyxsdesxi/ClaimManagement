package com.cognizant.memberPortal.controller;

import java.util.HashMap;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.cognizant.memberPortal.model.MemberClaim;
import com.cognizant.memberPortal.model.MemberPremium;

@Controller
public class MemberPortalController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberPortalController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value = "/viewBills/{policyId}/{MemberId}")
	public String viewBills(@PathVariable int policyId, @PathVariable int MemberId, ModelMap map) {
		
		HashMap<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("policyId", policyId);
		uriVariables.put("MemberId", MemberId);
		
		ResponseEntity<MemberPremium> forEntity = restTemplate.getForEntity("http://localhost:8001/viewBills/{policyId}/{MemberId}", MemberPremium.class, uriVariables);
		MemberPremium result = forEntity.getBody();
		map.put("result", result);
		return "viewBills";
		
	}
	
	@GetMapping(value = "/viewPremium/{MemberId}")
	public String viewPremiums(@PathVariable int MemberId, ModelMap map) {
		
		HashMap<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("memberId", MemberId);
		
		ResponseEntity<MemberPremium[]> forEntity = restTemplate.getForEntity("http://localhost:8001/viewPremium/{memberId}", MemberPremium[].class, uriVariables);
		MemberPremium[] result = forEntity.getBody();
		
		LOGGER.info("result: {}", result);
		
		map.put("result", result);
		return "viewPremium";
		
	}
	
	@GetMapping(value = "/submitClaim/{memberId}")
	public String submitClaim(@PathVariable int memberId, ModelMap map) {
		
		HashMap<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("memberId", memberId);
		
		ResponseEntity<MemberPremium[]> forEntity = restTemplate.getForEntity("http://localhost:8001/viewPremium/{memberId}", MemberPremium[].class, uriVariables);
		MemberPremium[] result = forEntity.getBody();
		
		LOGGER.info("result: {}", result);
		
		map.put("policy", result);
		
		return "submitClaim";
	}
	
	@PostMapping(value = "/submitClaim")
	public String submitClaimPost(@RequestParam int amount,@RequestParam int hospitalId,@RequestParam int policyId, ModelMap map) {
		
		MemberClaim claim = new MemberClaim();
		claim.setHospitalId(hospitalId);
		claim.setAmountClaimed(amount);
		
		HashMap<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("memberId", 1);
		uriVariables.put("policyId", policyId);
		
		String postForObject = restTemplate.postForObject("http://localhost:8001/submitClaim/{policyId}/{memberId}", claim, String.class, uriVariables);
		
		map.put("result", postForObject);
		
		return "submitClaimStatus";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value = "/test")
	public String test() {
		return "test";
	}
	
}
