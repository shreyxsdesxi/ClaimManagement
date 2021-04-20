package com.cognizant.policyService.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "policies")
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "policy_id")
	private int policyId;
	private String benefits;
	private int premium;
	private int tenure;
	private int elegibleAmount;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "policyList", cascade = CascadeType.ALL)
	private Set<Provider> providerList = new HashSet<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "policyMembersList", cascade = CascadeType.ALL)
	private Set<Member> memberList = new HashSet<>();

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public Policy(int policyId, String benefits, int premium, int tenure) {
		super();
		this.policyId = policyId;
		this.benefits = benefits;
		this.premium = premium;
		this.tenure = tenure;
	}

	public Policy() {
		super();
	}

	
	
	@JsonIgnore
	public Set<Provider> getProviderList() {
		return providerList;
	}

	public void setProviderList(Set<Provider> providerList) {
		this.providerList = providerList;
	}
	
	@JsonIgnore
	public Set<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(Set<Member> memberList) {
		this.memberList = memberList;
	}
	
	public int getElegibleAmount() {
		return elegibleAmount;
	}

	public void setElegibleAmount(int elegibleAmount) {
		this.elegibleAmount = elegibleAmount;
	}

}
