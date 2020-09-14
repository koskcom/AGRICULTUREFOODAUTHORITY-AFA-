package co.ke.bsl.pojo;
import org.idempiere.webservice.client.base.LoginRequest;


public class SugarMillLicenceDatacollection implements java.io.Serializable {
    private String longitude;
    private String latitude;

    private LoginRequest loginRequest;

    private String serviceType="sugarmilllicenceFieldScoreDataCollection";

    private String document_number;
    private String document_date;
    private String letter_of_comfort;
    private String applicant_name;

    private  String afa_sd_smillcliancelist_id;

    private String LocalID;

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

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    public String getDocument_date() {
        return document_date;
    }

    public void setDocument_date(String document_date) {
        this.document_date = document_date;
    }

    public String getLetter_of_comfort() {
        return letter_of_comfort;
    }

    public void setLetter_of_comfort(String letter_of_comfort) {
        this.letter_of_comfort = letter_of_comfort;
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
    }

    public String getAfa_sd_smillcliancelist_id() {
        return afa_sd_smillcliancelist_id;
    }

    public void setAfa_sd_smillcliancelist_id(String afa_sd_smillcliancelist_id) {
        this.afa_sd_smillcliancelist_id = afa_sd_smillcliancelist_id;
    }

    public String getLocalID() {
        return LocalID;
    }

    public void setLocalID(String localID) {
        LocalID = localID;
    }
}
