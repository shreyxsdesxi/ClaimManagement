package com.cognizant.claimservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cognizant.claimservice.model.Claims;
import com.cognizant.claimservice.repository.ClaimRepo;

@Component
public class ClaimServiceCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private ClaimRepo claimRepo;

	@Override
	public void run(String... args) throws Exception {
		Claims claim= new Claims();
		claim.setMemberId(1);
		claim.setStatus("Approved");
		claim.setPolicyNumber(123);
		
		
		Claims claim2= new Claims();
		claim2.setMemberId(2);
		claim2.setStatus("Rejected");
		claim2.setPolicyNumber(567);
		
		claimRepo.save(claim);
		claimRepo.save(claim2);
		
	}

}
