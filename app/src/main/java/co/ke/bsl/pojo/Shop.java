package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

public class Shop implements java.io.Serializable{

	private String longitude;
	private String latitude;
	private String afa_sd_sugarprices_survey_id ;

	private LoginRequest loginRequest;
	private String sentStatus;

	private String serviceType="CreateShopSurvey";

	private String shopID;

	private String name;

	private String serverRecordID;
	
	
	public String getSentStatus() {
		return sentStatus;
	}
	
	public void setSentStatus(String sentStatus) {
		this.sentStatus = sentStatus;
	}
	
	public String getServerRecordID() {
		return serverRecordID;
	}

	public void setServerRecordID(String serverRecordID) {
		this.serverRecordID = serverRecordID;
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

	public String getShopID() {
		return shopID;
	}

	public void setShopID(String shopID) {
		this.shopID = shopID;
	}

	public String getLongitude() {
		return longitude;
	}

	public Shop setLongitude(String longitude) {
		this.longitude = longitude;
		return this;
	}

	public String getLatitude() {
		return latitude;
	}

	public Shop setLatitude(String latitude) {
		this.latitude = latitude;
		return this;
	}

	public String getAfa_sd_sugarprices_survey_id() {
		return afa_sd_sugarprices_survey_id;
	}

	public Shop setAfa_sd_sugarprices_survey_id(String afa_sd_sugarprices_survey_id) {
		this.afa_sd_sugarprices_survey_id = afa_sd_sugarprices_survey_id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Shop setName(String name) {
		this.name = name;
		return this;
	}
}
