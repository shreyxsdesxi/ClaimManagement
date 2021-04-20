package com.cognizant.memberservice.model;

public class MemberPolicy {
	private int policyId;
    private String benefits;
    private int premium;
    int tenure;
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
	public MemberPolicy(int policyId, String benefits, int premium, int tenure) {
		super();
		this.policyId = policyId;
		this.benefits = benefits;
		this.premium = premium;
		this.tenure = tenure;
	}
	

}
