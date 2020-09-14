package co.ke.bsl.pojo;

import java.util.ArrayList;

public class GroupLoan {
	
	private Integer groupId;
	
	private String groupMSIDN;
	
	private double totalAmount;
	
	private String transactionCode;
	
	private String datePosted;
	
	private Integer agentId;
	
	private String savingType;
	
	private double totalSavingAmount;
	
	
	
	private ArrayList<Customer> customerList;

	/**
	 * @return the groupId
	 */
	public Integer getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the groupMSIDN
	 */
	public String getGroupMSIDN() {
		return groupMSIDN;
	}

	/**
	 * @param groupMSIDN the groupMSIDN to set
	 */
	public void setGroupMSIDN(String groupMSIDN) {
		this.groupMSIDN = groupMSIDN;
	}

	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the customerList
	 */
	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	/**
	 * @param customerList the customerList to set
	 */
	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}

	/**
	 * @return the agentId
	 */
	public Integer getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return the transactionCode
	 */
	public String getTransactionCode() {
		return transactionCode;
	}

	/**
	 * @param transactionCode the transactionCode to set
	 */
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	/**
	 * @return the savingType
	 */
	public String getSavingType() {
		return savingType;
	}

	/**
	 * @param savingType the savingType to set
	 */
	public void setSavingType(String savingType) {
		this.savingType = savingType;
	}

	/**
	 * @return the datePosted
	 */
	public String getDatePosted() {
		return datePosted;
	}

	/**
	 * @param datePosted the datePosted to set
	 */
	public void setDatePosted(String datePosted) {
		this.datePosted = datePosted;
	}

	/**
	 * @return the totalSavingAmount
	 */
	public double getTotalSavingAmount() {
		return totalSavingAmount;
	}

	/**
	 * @param totalSavingAmount the totalSavingAmount to set
	 */
	public void setTotalSavingAmount(double totalSavingAmount) {
		this.totalSavingAmount = totalSavingAmount;
	}

}
