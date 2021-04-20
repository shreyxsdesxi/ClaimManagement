package com.cognizant.policyService.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "providers")
public class Provider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hospital_id")
	private int hospitalId;
	private String hospitalName;
	private String location;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "provider_policy", joinColumns = @JoinColumn(name = "pp_hospital_id", referencedColumnName = "hospital_id"), inverseJoinColumns = @JoinColumn(name = "pp_policy_id", referencedColumnName = "policy_id" ) )
	private Set<Policy> policyList = new HashSet<>();

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
		
	@JsonIgnore
	public Set<Policy> getPolicyList() {
		return policyList;
	}

	public void setPolicyList(Set<Policy> policyList) {
		this.policyList = policyList;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Provider(int hospitalId, String hospitalName, Set<Policy> policyList) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.policyList = policyList;
	}

	public Provider() {
		super();
	}
	
	
}
