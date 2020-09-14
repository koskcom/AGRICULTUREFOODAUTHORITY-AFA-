package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

public class CaneCensusDataCollection implements java.io.Serializable{

	private String longitude;
	private String latitude;

	private LoginRequest loginRequest;

	private String serviceType="CreateCaneCensusFieldScoreDataCollection";

	private String countyID;

	private String c_bpartnerID;

	private String companyName;

	private String AFA_SD_Canecensusscore_ID;

	private String LocalID;

	public String getC_bpartnerID() {
		return c_bpartnerID;
	}

	public void setC_bpartnerID(String c_bpartnerID) {
		this.c_bpartnerID = c_bpartnerID;
	}

	public String getLocalID() {
		return LocalID;
	}

	public void setLocalID(String localID) {
		LocalID = localID;
	}

	public String getAFA_SD_Canecensusscore_ID() {
		return AFA_SD_Canecensusscore_ID;
	}

	public void setAFA_SD_Canecensusscore_ID(String AFA_SD_Canecensusscore_ID) {
		this.AFA_SD_Canecensusscore_ID = AFA_SD_Canecensusscore_ID;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
