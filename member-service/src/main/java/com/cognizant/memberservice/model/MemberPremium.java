package com.cognizant.memberservice.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="member_premium")
public class MemberPremium {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDue() {
		return due;
	}
	public void setDue(Date due) {
		this.due = due;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
//	public Members getMembers() {
//		return members;
//	}
//	public void setMembers(Members members) {
//		this.members = members;
//	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date due;
	private int amount;
	private int policyId;
	private Date lastPaidDate;
	private int latePaymentCharges;
	@ManyToOne
	@JoinColumn(name="member_id")
	private Members members;
	public MemberPremium() {
		super();
	}
	public Members getMembers() {
		return members;
	}
	public void setMembers(Members members) {
		this.members = members;
	}
	public Date getLastPaidDate() {
		return lastPaidDate;
	}
	public void setLastPaidDate(Date lastPaidDate) {
		this.lastPaidDate = lastPaidDate;
	}
	public int getLatePaymentCharges() {
		return latePaymentCharges;
	}
	public void setLatePaymentCharges(int latePaymentCharges) {
		this.latePaymentCharges = latePaymentCharges;
	}
	
//	@ManyToMany(mappedBy = "premium", cascade = CascadeType.ALL)
//	private Set<Members> membersList = new HashSet<>();
//
//	public Set<Members> getMembersList() {
//		return membersList;
//	}
//	public void setMembersList(Set<Members> membersList) {
//		this.membersList = membersList;
//	}
	
	
	
	
}

