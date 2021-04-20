package com.cognizant.claimservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Claims")
public class Claims {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int claimNumber;
    private String status ;
    private String remarks;
    private int policyNumber ;
    private String hospitalDetails ;
    private int hospitalId;
    
    private String benifits ;
    private int amountClaimed;
    private int amountSettled;
    private int memberId;
    private String action;
	public int getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(int claimNumber) {
		this.claimNumber = claimNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getHospitalDetails() {
		return hospitalDetails;
	}
	public void setHospitalDetails(String hospitalDetails) {
		this.hospitalDetails = hospitalDetails;
	}
	public String getBenifits() {
		return benifits;
	}
	public void setBenifits(String benifits) {
		this.benifits = benifits;
	}
	public int getAmountClaimed() {
		return amountClaimed;
	}
	public void setAmountClaimed(int amountClaimed) {
		this.amountClaimed = amountClaimed;
	}
	public int getAmountSettled() {
		return amountSettled;
	}
	public void setAmountSettled(int amountSettled) {
		this.amountSettled = amountSettled;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Claims(int claimNumber, String status, String remarks, int policyNumber, String hospitalDetails,
			String benifits, int amountClaimed, int amountSettled, int memberId, String action) {
		super();
		this.claimNumber = claimNumber;
		this.status = status;
		this.remarks = remarks;
		this.policyNumber = policyNumber;
		this.hospitalDetails = hospitalDetails;
		this.benifits = benifits;
		this.amountClaimed = amountClaimed;
		this.amountSettled = amountSettled;
		this.memberId = memberId;
		this.action = action;
	}
	public Claims() {
		super();
	}
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	
    

}
