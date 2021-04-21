package com.cognizant.memberservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.memberservice.model.Members;

@Repository
public interface MembersRepository extends JpaRepository<Members, Integer> {

}
