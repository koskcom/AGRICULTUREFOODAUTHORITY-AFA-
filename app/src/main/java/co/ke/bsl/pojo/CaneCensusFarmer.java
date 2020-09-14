package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

public class CaneCensusFarmer implements java.io.Serializable{

	private LoginRequest loginRequest;

	private String serviceType="CreateFarmerDetails";
	
	private String idNo;
	
	private String gender;

	private String countyID;

	private String farmerName;

	private String farmerPhoneNo;

	private String subCountyID;

	private String  AFA_SD_Canecensusscore_ID;

	private String AFA_SD_Canefarmerdetails_ID;

	private String  localID;

	private String  parentID;
	
	public String getIdNo() {
		return idNo;
	}
	
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public String getLocalID() {
		return localID;
	}

	public void setLocalID(String localID) {
		this.localID = localID;
	}

	public String getAFA_SD_Canefarmerdetails_ID() {
		return AFA_SD_Canefarmerdetails_ID;
	}

	public void setAFA_SD_Canefarmerdetails_ID(String AFA_SD_Canefarmerdetails_ID) {
		this.AFA_SD_Canefarmerdetails_ID = AFA_SD_Canefarmerdetails_ID;
	}

	public String getAFA_SD_Canecensusscore_ID() {
		return AFA_SD_Canecensusscore_ID;
	}

	public void setAFA_SD_Canecensusscore_ID(String AFA_SD_Canecensusscore_ID) {
		this.AFA_SD_Canecensusscore_ID = AFA_SD_Canecensusscore_ID;
	}

	public LoginRequest getLoginRequest() {
		return loginRequest;
	}

	public void setLoginRequest(LoginRequest loginRequest) {
		this.loginRequest = loginRequest;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getCountyID() {
		return countyID;
	}

	public void setCountyID(String countyID) {
		this.countyID = countyID;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getFarmerPhoneNo() {
		return farmerPhoneNo;
	}

	public void setFarmerPhoneNo(String farmerPhoneNo) {
		this.farmerPhoneNo = farmerPhoneNo;
	}

	public String getSubCountyID() {
		return subCountyID;
	}

	public void setSubCountyID(String subCountyID) {
		this.subCountyID = subCountyID;
	}
}
