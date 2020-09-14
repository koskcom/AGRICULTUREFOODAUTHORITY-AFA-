package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class HCDPersonalHygene {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int hcd_Personal_Hygiene_id;
    private String ssnameOfApplicant;
    private String localID;
    private String names;
    private String nationalId;
    private String medicalCertNo;
    private String isdustCots;
    private String hgearCaps;
    private String isjewels;
    private String isnailsCut;
    private String isbodyClean;
    private String isshoes;
    private boolean is_synced;
    private String remote_id;

    // variables to assist in posting  to web service.
    private String AFA_HCD_Persanl_Hygiene_ID;
    private String serverID;

    public HCDPersonalHygene(int hcd_Personal_Hygiene_id, String ssnameOfApplicant, String localID, String names, String nationalId, String medicalCertNo, String isdustCots, String hgearCaps, String isjewels, String isnailsCut, String isbodyClean, String isshoes, boolean is_synced, String remote_id) {
        this.hcd_Personal_Hygiene_id = hcd_Personal_Hygiene_id;
        this.ssnameOfApplicant = ssnameOfApplicant;
        this.localID = localID;
        this.names = names;
        this.nationalId = nationalId;
        this.medicalCertNo = medicalCertNo;
        this.isdustCots = isdustCots;
        this.hgearCaps = hgearCaps;
        this.isjewels = isjewels;
        this.isnailsCut = isnailsCut;
        this.isbodyClean = isbodyClean;
        this.isshoes = isshoes;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

    @Ignore
    public HCDPersonalHygene() {
    }

    public int getHcd_Personal_Hygiene_id() {
        return hcd_Personal_Hygiene_id;
    }

    public void setHcd_Personal_Hygiene_id(int hcd_Personal_Hygiene_id) {
        this.hcd_Personal_Hygiene_id = hcd_Personal_Hygiene_id;
    }

    public String getAFA_HCD_Persanl_Hygiene_ID() {
        return AFA_HCD_Persanl_Hygiene_ID;
    }

    public void setAFA_HCD_Persanl_Hygiene_ID(String AFA_HCD_Persanl_Hygiene_ID) {
        this.AFA_HCD_Persanl_Hygiene_ID = AFA_HCD_Persanl_Hygiene_ID;
    }

    public String getServerID() {
        return serverID;
    }

    public void setServerID(String serverID) {
        this.serverID = serverID;
    }

    public String getSsnameOfApplicant() {
        return ssnameOfApplicant;
    }

    public void setSsnameOfApplicant(String ssnameOfApplicant) {
        this.ssnameOfApplicant = ssnameOfApplicant;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getMedicalCertNo() {
        return medicalCertNo;
    }

    public void setMedicalCertNo(String medicalCertNo) {
        this.medicalCertNo = medicalCertNo;
    }

    public String getIsdustCots() {
        return isdustCots;
    }

    public void setIsdustCots(String isdustCots) {
        this.isdustCots = isdustCots;
    }

    public String getHgearCaps() {
        return hgearCaps;
    }

    public void setHgearCaps(String hgearCaps) {
        this.hgearCaps = hgearCaps;
    }

    public String getIsjewels() {
        return isjewels;
    }

    public void setIsjewels(String isjewels) {
        this.isjewels = isjewels;
    }

    public String getIsnailsCut() {
        return isnailsCut;
    }

    public void setIsnailsCut(String isnailsCut) {
        this.isnailsCut = isnailsCut;
    }

    public String getIsbodyClean() {
        return isbodyClean;
    }

    public void setIsbodyClean(String isbodyClean) {
        this.isbodyClean = isbodyClean;
    }

    public String getIsshoes() {
        return isshoes;
    }

    public void setIsshoes(String isshoes) {
        this.isshoes = isshoes;
    }

    public boolean isIs_synced() {
        return is_synced;
    }

    public void setIs_synced(boolean is_synced) {
        this.is_synced = is_synced;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }
}
