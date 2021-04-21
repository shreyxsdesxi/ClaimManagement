package com.cognizant.memberservice;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cognizant.memberservice.model.MemberPremium;
import com.cognizant.memberservice.model.Members;
import com.cognizant.memberservice.repository.MembersRepository;
import com.cognizant.memberservice.repository.MemberPremiumRepository;

@Component
public class MemberServiceCommandLineRunner implements CommandLineRunner{
	@Autowired
	private MembersRepository membersRepository;
	@Autowired
	private MemberPremiumRepository premiumRepository;
	@Override
     public void run(String... args) throws  Exception{
		 
		 Members member=new Members();
		 member.setFirstname("Shreyas");
		 member.setLastname("Desai");
		 member.setAge(22);
		 member.setEmail("889157@cognizant.com");

		 Members member1=new Members();
		 member1.setFirstname("Rushikesh");
		 member1.setLastname("Chaudhary");
		 member1.setAge(22);
		 member1.setEmail("88989@cognizant.com");
		 
		 Members member2=new Members();
		 member2.setFirstname("William");
		 member2.setLastname("Shakespeare");
		 member2.setAge(200);
		 member2.setEmail("88900@cognizant.com");
		 
		 Members member3=new Members();
		 member3.setFirstname("Harvey");
		 member3.setLastname("Specter");
		 member3.setAge(40);
		 member3.setEmail("20100@cognizant.com");
		 
		 Members member4=new Members();
		 member4.setFirstname("Mike");
		 member4.setLastname("Ross");
		 member4.setAge(39);
		 member4.setEmail("88800@cognizant.com");
		 
		 //-----------------------------------------------------
		 
		 MemberPremium premium = new MemberPremium();
		 premium.setDue(new Date());
		 premium.setAmount(25000);
		 premium.setPolicyId(1234);
		
		 MemberPremium premium1 = new MemberPremium();
		 premium1.setDue(new Date());
	     premium1.setAmount(20000);
		 premium1.setPolicyId(5678);
		 
		 MemberPremium premium2 = new MemberPremium();
		 premium2.setDue(new Date());
	     premium2.setAmount(50000);
		 premium2.setPolicyId(9101);
		 
		 MemberPremium premium3 = new MemberPremium();
		 premium3.setDue(new Date());
		 premium3.setAmount(70000);
		 premium3.setPolicyId(1213);
		
		 MemberPremium premium4 = new MemberPremium();
		 premium4.setDue(new Date());
	     premium4.setAmount(5000);
		 premium4.setPolicyId(1415);
		 
		 MemberPremium premium5 = new MemberPremium();
		 premium5.setDue(new Date());
	     premium5.setAmount(2000);
		 premium5.setPolicyId(1617);
		 
		 MemberPremium premium6 = new MemberPremium();
		 premium6.setDue(new Date());
		 premium6.setAmount(3500);
		 premium6.setPolicyId(1819);
		
		 MemberPremium premium7 = new MemberPremium();
		 premium7.setDue(new Date());
	     premium7.setAmount(4000);
		 premium7.setPolicyId(2021);
		 
		 MemberPremium premium8 = new MemberPremium();
		 premium8.setDue(new Date());
	     premium8.setAmount(10000);
		 premium8.setPolicyId(2223);
		
		//--------------------------------------------------------
		
		member.getPremium().add(premium);
		premium.setMembers(member);
		member.getPremium().add(premium1);
		premium1.setMembers(member);
		membersRepository.save(member);
		premiumRepository.save(premium);
		premiumRepository.save(premium1);

		
		member1.getPremium().add(premium2);
		premium2.setMembers(member1);
		
		member2.getPremium().add(premium3);
		premium3.setMembers(member2);
		member2.getPremium().add(premium4);
		premium4.setMembers(member2);
		
		member3.getPremium().add(premium5);
		premium5.setMembers(member3);
		member3.getPremium().add(premium6);
		premium6.setMembers(member3);
		
		member4.getPremium().add(premium7);
		premium7.setMembers(member4);
		member4.getPremium().add(premium8);
		premium8.setMembers(member4);
//		
		membersRepository.save(member1);
		membersRepository.save(member2);
		membersRepository.save(member3);
		membersRepository.save(member4);
		
				premiumRepository.save(premium2);
		premiumRepository.save(premium3);
		premiumRepository.save(premium4);
		premiumRepository.save(premium5);
		premiumRepository.save(premium6);
		premiumRepository.save(premium7);
		premiumRepository.save(premium8);
		 
//		member.getPremium().add(premium);
//		premium.setMembers(member);
//		member1.getPremium().add(premium1);
//		premium1.setMembers(member1);
//		membersRepository.save(member);
//		membersRepository.save(member1);
//		premiumRepository.save(premium);
//		premiumRepository.save(premium1);
	}

}
