package co.ke.bsl.data.retrofit;

public class ClientResponse {
    private String physician_id;
    private String kin_telephone;
    private String kin_relationship;
    private String client_nhif;
    private String client_sex;
    private String created_at;
    private String active;
    private String client_national_id;
    private String facility_name;
    private String created_by;
    private String client_id;
    private String record_id;
    private String client_age;
    private String facility_address;
    private String kin_name;
    private String client_telephone;
    private String client_county;
    private String client_address;
    private String client_name;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getRecord_id() {
        return record_id;
    }

    public void setRecord_id(String record_id) {
        this.record_id = record_id;
    }
}