package com.cognizant.memberservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.memberservice.model.MemberPremium;
import com.cognizant.memberservice.model.Members;

@Repository
public interface MemberPremiumRepository extends JpaRepository<MemberPremium,Integer>{
	
 MemberPremium findByPolicyIdAndMembers(int policyId,Members member);

}
