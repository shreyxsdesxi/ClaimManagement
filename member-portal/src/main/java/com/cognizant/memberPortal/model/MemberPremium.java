package com.cognizant.memberPortal.model;

import java.util.Date;

public class MemberPremium {
	
	private int id;
	private Date due;
	private int amount;
	private int policyId;
	private Date lastPaidDate;
	private int latePaymentCharges;
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
	@Override
	public String toString() {
		return "MemberPremium [id=" + id + ", due=" + due + ", amount=" + amount + ", policyId=" + policyId + "]";
	}
	
	
	
}
