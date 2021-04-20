package com.cognizant.memberservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.memberservice.model.Members;
import com.cognizant.memberservice.repository.MembersRepository;

@Service
public class MembersServices {
	@Autowired
    MembersRepository  membersRepository;
	@Transactional
	public List<Members> getAllMembers() {
		
		List<Members> memberss= membersRepository.findAll();
		return memberss;
	}
	public Members getMemberById(int id)
	{
		return membersRepository.findById(id).get();
		
	}

}
