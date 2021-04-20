package com.cognizant.policyService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.policyService.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{

}
