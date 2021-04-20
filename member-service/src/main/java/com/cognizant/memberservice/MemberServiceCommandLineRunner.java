package com.cognizant.memberservice;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cognizant.memberservice.model.MemberPremium;
import com.cognizant.memberservice.model.Members;
import com.cognizant.memberservice.repository.MembersRepository;
import com.cognizant.memberservice.repository.PremiumRepository;

@Component
public class MemberServiceCommandLineRunner implements CommandLineRunner{
	@Autowired
	private MembersRepository membersRepository;
	@Autowired
	private PremiumRepository premiumRepository;
	@Override
     public void run(String... args) throws  Exception{
	 Members member=new Members();
		
		 member.setFirstname("Williams");
		 member.setLastname("Smith");
		 Members member1=new Members();
			
		 member1.setFirstname("Williams");
		 member1.setLastname("Shakespeare");
		 /*member.setAge
		 member.setEmail
		 member.setPhone
		 member.setOrganization
		 member.setAddress*/
		MemberPremium premium=new MemberPremium();
		premium.setDue(new Date());
		premium.setAmount(25000);
		premium.setPolicyId(1234);
		MemberPremium premium1=new MemberPremium();
		premium1.setDue(new Date());
		premium1.setAmount(20000);
		premium1.setPolicyId(1235);
		member.getPremium().add(premium);
		premium.setMembers(member);
		member1.getPremium().add(premium1);
		premium1.setMembers(member1);
		membersRepository.save(member);
		membersRepository.save(member1);
		premiumRepository.save(premium);
		premiumRepository.save(premium1);
	}

}
