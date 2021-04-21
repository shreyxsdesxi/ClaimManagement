package com.cognizant.memberservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="members")
public class Members {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int member_id;
	private String firstname;
	private String lastname;
	private int age;
	public Set<MemberPremium> getPremium() {
		return premium;
	}
	public void setPremium(Set<MemberPremium> premium) {
		this.premium = premium;
	}
	private String email;
	private long phone;
	private String organization;
	private String address;
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Members(int member_id, String firstname, String lastname, int age, String email, long phone,
			String organization, String address) {
		super();
		this.member_id = member_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.organization = organization;
		this.address = address;
	}
	public Members() {
		super();
	}
	@JsonIgnore
	@OneToMany(mappedBy="members")
	private Set<MemberPremium> premium=new HashSet<>();
	
	
	
//	@ManyToMany(cascade = CascadeType)
//	@JoinTable(name = "mem_pre", joinColumns = @JoinColumn(name = "mp_member_id", referencedColumnName = "member_id"), inverseJoinColumns = @JoinColumn(name = "mp_premium_id", referencedColumnName = "id"))
//	private Set<MemberPremium> premium = new HashSet<>();
	
	

}
