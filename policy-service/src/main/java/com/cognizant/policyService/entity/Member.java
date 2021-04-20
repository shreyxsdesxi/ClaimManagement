package com.cognizant.policyService.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.type.SerializableType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "members")

public class Member implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "member_id")
	private int memberId;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "member_policy", joinColumns = @JoinColumn(name="mp_member_id", referencedColumnName = "member_id"), inverseJoinColumns = @JoinColumn(name="mp_policy_id", referencedColumnName = "policy_id"))
	private Set<Policy> policyMembersList = new HashSet<>();

	public Member() {
		super();
	}

	public Member(int id, int memberId, Set<Policy> policyMembersList) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.policyMembersList = policyMembersList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Set<Policy> getPolicyMembersList() {
		return policyMembersList;
	}

	public void setPolicyMembersList(Set<Policy> policyMembersList) {
		this.policyMembersList = policyMembersList;
	}
	
	
	
}
