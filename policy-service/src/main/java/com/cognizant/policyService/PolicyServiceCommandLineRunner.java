package com.cognizant.policyService;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cognizant.policyService.entity.Member;
import com.cognizant.policyService.entity.Policy;
import com.cognizant.policyService.entity.Provider;
import com.cognizant.policyService.repository.MemberRepository;
import com.cognizant.policyService.repository.PolicyRepository;
import com.cognizant.policyService.repository.ProviderRepository;

@Component
public class PolicyServiceCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	private ProviderRepository providerRepository;
	
	@Autowired
	private PolicyRepository policyRepositoy;
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public void run(String... args) throws Exception {
		Provider provider = new Provider();
		provider.setHospitalName("Red Cross Hospital");
		provider.setLocation("Pune");
		
		Provider provider2 = new Provider();
		provider2.setHospitalName("Cambridge Hospital");
		provider2.setLocation("Bangalore");
		
		Provider provider3 = new Provider();
		provider3.setHospitalName("Newlife Hospital");
		provider3.setLocation("Kolkata");
		
		Provider provider4 = new Provider();
		provider4.setHospitalName("Newlife Hospital");
		provider4.setLocation("Chennai");
		
		Provider provider5 = new Provider();
		provider5.setHospitalName("Newlife Hospital");
		provider5.setLocation("Mumbai");
		
		Policy policy = new Policy();
		policy.setBenefits("Up to 4 family members " + 
				"No of Members Covered " + 
				"Rs. 60 lakhs " + 
				"Maximum sum assured");
		policy.setElegibleAmount(10000);
		policy.setPolicyNumber(1234);
		
		Policy policy2 = new Policy();
		policy2.setBenefits("Up to 6 family members " + 
				"No of Members Covered " + 
				"Rs. 50 lakhs " + 
				"Maximum sum assured");
		policy2.setElegibleAmount(620000);
		policy2.setPolicyNumber(5678);
		
		Policy policy3 = new Policy();
		policy3.setBenefits("Up to 6 family members " + 
				"No of Members Covered " + 
				"Rs. 8 lakhs " + 
				"Maximum sum assured");
		policy3.setElegibleAmount(695202);
		policy3.setPolicyNumber(9101);
		
		Policy policy4 = new Policy();
		policy4.setBenefits("Up to 6 family members " + 
				"No of Members Covered " + 
				"Rs. 8 lakhs " + 
				"Maximum sum assured");
		policy4.setElegibleAmount(50000);
		policy4.setPolicyNumber(1213);
		
		Policy policy5 = new Policy();
		policy5.setBenefits("Up to 6 family members " + 
				"No of Members Covered " + 
				"Rs. 8 lakhs " + 
				"Maximum sum assured");
		policy5.setElegibleAmount(20000);
		policy5.setPolicyNumber(1415);
		
		
		policy.getProviderList().add(provider);
		policy.getProviderList().add(provider2);
		provider.getPolicyList().add(policy);
		provider2.getPolicyList().add(policy);
		
		policy2.getProviderList().add(provider3);
		provider3.getPolicyList().add(policy2);
		
		policy3.getProviderList().add(provider);
		policy3.getProviderList().add(provider3);
		provider.getPolicyList().add(policy3);
		provider3.getPolicyList().add(policy3);
		
		policy4.getProviderList().add(provider4);
		provider4.getPolicyList().add(policy4);
		
		policy5.getProviderList().add(provider5);
		provider5.getPolicyList().add(policy5);
		
		//------------------------------------------------------------
		
		Member member = new Member();
		member.setMemberId(1);
		
		Member member2 = new Member();
		member2.setMemberId(2);
		
		Member member3 = new Member();
		member3.setMemberId(3);
		
		//--------------------------------------------------------------
		
		policy.getMemberList().add(member);
		member.getPolicyMembersList().add(policy);
		policy2.getMemberList().add(member);
		member.getPolicyMembersList().add(policy2);
		
		policy3.getMemberList().add(member2);
		member2.getPolicyMembersList().add(policy3);
		
		
		policy4.getMemberList().add(member3);
		member3.getPolicyMembersList().add(policy4);
		policy5.getMemberList().add(member3);
		member3.getPolicyMembersList().add(policy5);
		
		//------------------------------------------------------------
		
		policyRepositoy.save(policy);
		policyRepositoy.save(policy2);
		
		
		providerRepository.save(provider);
		providerRepository.save(provider2);
		providerRepository.save(provider3);
		providerRepository.save(provider4);
		providerRepository.save(provider5);
		
		memberRepository.save(member);
		memberRepository.save(member2);
		
		//-------------------------------------------------------------
		
		
		
		
	}

}
