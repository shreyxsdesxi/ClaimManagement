package com.cognizant.memberservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.memberservice.model.MemberPremium;
import com.cognizant.memberservice.model.Members;
import com.cognizant.memberservice.repository.PremiumRepository;

@Service
public class PremiumServices {
	@Autowired
    PremiumRepository  premiumRepository;
	@Transactional
	public List<MemberPremium> findPremiumDetails() {
		
		List<MemberPremium> premium= premiumRepository.findAll();
		return premium;
	}
	public MemberPremium premium(int policyId,Members member)
	{
		return premiumRepository.findByPolicyIdAndMembers(policyId,member);
	}
}
