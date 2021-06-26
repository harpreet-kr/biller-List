package com.eroute.biller.dto;

public class BillerDTO {
	private String blrName;
	private Integer adhocPayment;
	private String billerDescription;
	private String blrId;
	private String billerValue;
	private String supportBillValidation;
	private String blrCatName;
	private Integer blrCatId;
	private Integer billAcceptanceType;
	private String paymentAmtExactness;
	public String getBlrName() {
		return blrName;
	}
	public void setBlrName(String blrName) {
		this.blrName = blrName;
	}
	public Integer getAdhocPayment() {
		return adhocPayment;
	}
	public void setAdhocPayment(Integer adhocPayment) {
		this.adhocPayment = adhocPayment;
	}
	public String getBillerDescription() {
		return billerDescription;
	}
	public void setBillerDescription(String billerDescription) {
		this.billerDescription = billerDescription;
	}
	public String getBlrId() {
		return blrId;
	}
	public void setBlrId(String blrId) {
		this.blrId = blrId;
	}
	public String getBillerValue() {
		return billerValue;
	}
	public void setBillerValue(String billerValue) {
		this.billerValue = billerValue;
	}
	public String getSupportBillValidation() {
		return supportBillValidation;
	}
	public void setSupportBillValidation(String supportBillValidation) {
		this.supportBillValidation = supportBillValidation;
	}
	public String getBlrCatName() {
		return blrCatName;
	}
	public void setBlrCatName(String blrCatName) {
		this.blrCatName = blrCatName;
	}
	public Integer getBlrCatId() {
		return blrCatId;
	}
	public void setBlrCatId(Integer blrCatId) {
		this.blrCatId = blrCatId;
	}
	public Integer getBillAcceptanceType() {
		return billAcceptanceType;
	}
	public void setBillAcceptanceType(Integer billAcceptanceType) {
		this.billAcceptanceType = billAcceptanceType;
	}
	public String getPaymentAmtExactness() {
		return paymentAmtExactness;
	}
	public void setPaymentAmtExactness(String paymentAmtExactness) {
		this.paymentAmtExactness = paymentAmtExactness;
	}
	@Override
	public String toString() {
		return "BillerDTO [blrName=" + blrName + ", adhocPayment=" + adhocPayment + ", billerDescription="
				+ billerDescription + ", blrId=" + blrId + ", billerValue=" + billerValue + ", supportBillValidation="
				+ supportBillValidation + ", blrCatName=" + blrCatName + ", blrCatId=" + blrCatId
				+ ", billAcceptanceType=" + billAcceptanceType + ", paymentAmtExactness=" + paymentAmtExactness + "]";
	}
	
}
