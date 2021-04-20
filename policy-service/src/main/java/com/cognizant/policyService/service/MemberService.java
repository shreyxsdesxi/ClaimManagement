package com.cognizant.policyService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.policyService.entity.Member;
import com.cognizant.policyService.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	public Member getMemberById(int id) {
		return memberRepository.findById(id).get();
	}
	
}
