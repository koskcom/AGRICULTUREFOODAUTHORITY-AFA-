package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

public class CaneCensusCropDetails implements java.io.Serializable{



	private LoginRequest loginRequest;

	private String serviceType="CreateCensusDropDetails";


	private String  cropClass;
	private String variety;
	private String hectares;
	private String aGEmonths;
	private String cropVigour;
	private String cropColour;
	private String cropDensity;
	private String pestsDiseaseWeeds;
	private String expectedTCH;

	private String  localID;

	private String  parentID;

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



	public String getExpectedTCH() {
		return expectedTCH;
	}

	public void setExpectedTCH(String expectedTCH) {
		this.expectedTCH = expectedTCH;
	}

	private String  AFA_SD_Canefarmerdetails_ID;

	public String getAFA_SD_Canefarmerdetails_ID() {
		return AFA_SD_Canefarmerdetails_ID;
	}

	public void setAFA_SD_Canefarmerdetails_ID(String AFA_SD_Canefarmerdetails_ID) {
		this.AFA_SD_Canefarmerdetails_ID = AFA_SD_Canefarmerdetails_ID;
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

	public String getCropClass() {
		return cropClass;
	}

	public void setCropClass(String cropClass) {
		this.cropClass = cropClass;
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public String getHectares() {
		return hectares;
	}

	public void setHectares(String hectares) {
		this.hectares = hectares;
	}

	public String getaGEmonths() {
		return aGEmonths;
	}

	public void setaGEmonths(String aGEmonths) {
		this.aGEmonths = aGEmonths;
	}

	public String getCropVigour() {
		return cropVigour;
	}

	public void setCropVigour(String cropVigour) {
		this.cropVigour = cropVigour;
	}

	public String getCropColour() {
		return cropColour;
	}

	public void setCropColour(String cropColour) {
		this.cropColour = cropColour;
	}

	public String getCropDensity() {
		return cropDensity;
	}

	public void setCropDensity(String cropDensity) {
		this.cropDensity = cropDensity;
	}

	public String getPestsDiseaseWeeds() {
		return pestsDiseaseWeeds;
	}

	public void setPestsDiseaseWeeds(String pestsDiseaseWeeds) {
		this.pestsDiseaseWeeds = pestsDiseaseWeeds;
	}
}
