package co.ke.bsl.pojo;

import java.io.Serializable;

public class ADUser implements Serializable {
    private String ad_user_name;
    private String ad_user_id;
    private String ad_user_email;
    private String c_bpartner_id;
    private String c_activity_id;

    public String getAd_user_name() {
        return ad_user_name;
    }

    public void setAd_user_name(String ad_user_name) {
        this.ad_user_name = ad_user_name;
    }

    public String getC_activity_id() {
        return c_activity_id;
    }

    public void setC_activity_id(String c_activity_id) {
        this.c_activity_id = c_activity_id;
    }

    public String getAd_user_id() {
        return ad_user_id;
    }

    public void setAd_user_id(String ad_user_id) {
        this.ad_user_id = ad_user_id;
    }

    public String getAd_user_email() {
        return ad_user_email;
    }

    public void setAd_user_email(String ad_user_email) {
        this.ad_user_email = ad_user_email;
    }

    public String getC_bpartner_id() {
        return c_bpartner_id;
    }

    public void setC_bpartner_id(String c_bpartner_id) {
        this.c_bpartner_id = c_bpartner_id;
    }
}
