package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HCDFlowersConsolidators {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int hcd_flowers_Consolidators_id;
    private String document_number;
    private String document_date;
    private String name_of_applicant;
    private String export_licence;
    private String postal_address;
    private String email;
    private String telephone;
    private String localID;
    private String islistofcomapanycertificate;
    private String listofcomapanycertificateAward;
    private String listofcomapanycertificateTimeline;
    private String listofcomapanycertificateRemarks;
    private String isValididtyOfSupplliers;
    private String valididtyOfSupplliersAward;
    private String valididtyOfSupplliersTimeline;
    private String valididtyOfSupplliersRemarks;
    private String isCertificationToksh1758;
    private String certificationToksh1758Award;
    private String certificationToksh1758Timeline;
    private String certificationToksh1758Remarks;
    private String isCopyHcdExportlicence;
    private String copyHcdExportlicenceAward;
    private String copyHcdExportlicenceTimeline;
    private String copyHcdExportlicenceRemarks;
    private String isEvidenceRegistrationNationalTraceability;
    private String evidenceRegistrationNationalTraceabilityAward;
    private String evidenceRegistrationNationalTraceabilityTimeline;
    private String evidenceRegistrationNationalTraceabilityRemarks;
    private String isevidenceOfSingleWindow;
    private String evidenceOfSingleWindowAward;
    private String evidenceOfSingleWindowTimeline;
    private String evidenceOfSingleWindowRemarks;
    private String isEvidenceOfAttendanceAnnualtraning;
    private String evidenceOfAttendanceAnnualtraningAward;
    private String evidenceOfAttendanceAnnualtraningTimeline;
    private String evidenceOfAttendanceAnnualtraningRemarks;
    private String isVettingMarksCert;
    private String vettingMarksCertAward;
    private String vettingMarksCertTimeline;
    private String vettingMarksCertRemarks;
    private String isUtilizationHcd;
    private String utilizationHcdAward;
    private String utilizationHcdTimeline;
    private String utilizationHcdRemarks;
    private String officerrecommendation;
    private String officerrecommendation_remark;
    private boolean is_synced;
    private String remote_id;

    public HCDFlowersConsolidators(int hcd_flowers_Consolidators_id, String document_number, String document_date, String name_of_applicant, String export_licence, String postal_address, String email, String telephone, String localID, String islistofcomapanycertificate, String listofcomapanycertificateAward, String listofcomapanycertificateTimeline, String listofcomapanycertificateRemarks, String isValididtyOfSupplliers, String valididtyOfSupplliersAward, String valididtyOfSupplliersTimeline, String valididtyOfSupplliersRemarks, String isCertificationToksh1758, String certificationToksh1758Award, String certificationToksh1758Timeline, String certificationToksh1758Remarks, String isCopyHcdExportlicence, String copyHcdExportlicenceAward, String copyHcdExportlicenceTimeline, String copyHcdExportlicenceRemarks, String isEvidenceRegistrationNationalTraceability, String evidenceRegistrationNationalTraceabilityAward, String evidenceRegistrationNationalTraceabilityTimeline, String evidenceRegistrationNationalTraceabilityRemarks, String isevidenceOfSingleWindow, String evidenceOfSingleWindowAward, String evidenceOfSingleWindowTimeline, String evidenceOfSingleWindowRemarks, String isEvidenceOfAttendanceAnnualtraning, String evidenceOfAttendanceAnnualtraningAward, String evidenceOfAttendanceAnnualtraningTimeline, String evidenceOfAttendanceAnnualtraningRemarks, String isVettingMarksCert, String vettingMarksCertAward, String vettingMarksCertTimeline, String vettingMarksCertRemarks, String isUtilizationHcd, String utilizationHcdAward, String utilizationHcdTimeline, String utilizationHcdRemarks, String officerrecommendation, String officerrecommendation_remark, boolean is_synced, String remote_id) {
        this.hcd_flowers_Consolidators_id = hcd_flowers_Consolidators_id;
        this.document_number = document_number;
        this.document_date = document_date;
        this.name_of_applicant = name_of_applicant;
        this.export_licence = export_licence;
        this.postal_address = postal_address;
        this.email = email;
        this.telephone = telephone;
        this.localID = localID;
        this.islistofcomapanycertificate = islistofcomapanycertificate;
        this.listofcomapanycertificateAward = listofcomapanycertificateAward;
        this.listofcomapanycertificateTimeline = listofcomapanycertificateTimeline;
        this.listofcomapanycertificateRemarks = listofcomapanycertificateRemarks;
        this.isValididtyOfSupplliers = isValididtyOfSupplliers;
        this.valididtyOfSupplliersAward = valididtyOfSupplliersAward;
        this.valididtyOfSupplliersTimeline = valididtyOfSupplliersTimeline;
        this.valididtyOfSupplliersRemarks = valididtyOfSupplliersRemarks;
        this.isCertificationToksh1758 = isCertificationToksh1758;
        this.certificationToksh1758Award = certificationToksh1758Award;
        this.certificationToksh1758Timeline = certificationToksh1758Timeline;
        this.certificationToksh1758Remarks = certificationToksh1758Remarks;
        this.isCopyHcdExportlicence = isCopyHcdExportlicence;
        this.copyHcdExportlicenceAward = copyHcdExportlicenceAward;
        this.copyHcdExportlicenceTimeline = copyHcdExportlicenceTimeline;
        this.copyHcdExportlicenceRemarks = copyHcdExportlicenceRemarks;
        this.isEvidenceRegistrationNationalTraceability = isEvidenceRegistrationNationalTraceability;
        this.evidenceRegistrationNationalTraceabilityAward = evidenceRegistrationNationalTraceabilityAward;
        this.evidenceRegistrationNationalTraceabilityTimeline = evidenceRegistrationNationalTraceabilityTimeline;
        this.evidenceRegistrationNationalTraceabilityRemarks = evidenceRegistrationNationalTraceabilityRemarks;
        this.isevidenceOfSingleWindow = isevidenceOfSingleWindow;
        this.evidenceOfSingleWindowAward = evidenceOfSingleWindowAward;
        this.evidenceOfSingleWindowTimeline = evidenceOfSingleWindowTimeline;
        this.evidenceOfSingleWindowRemarks = evidenceOfSingleWindowRemarks;
        this.isEvidenceOfAttendanceAnnualtraning = isEvidenceOfAttendanceAnnualtraning;
        this.evidenceOfAttendanceAnnualtraningAward = evidenceOfAttendanceAnnualtraningAward;
        this.evidenceOfAttendanceAnnualtraningTimeline = evidenceOfAttendanceAnnualtraningTimeline;
        this.evidenceOfAttendanceAnnualtraningRemarks = evidenceOfAttendanceAnnualtraningRemarks;
        this.isVettingMarksCert = isVettingMarksCert;
        this.vettingMarksCertAward = vettingMarksCertAward;
        this.vettingMarksCertTimeline = vettingMarksCertTimeline;
        this.vettingMarksCertRemarks = vettingMarksCertRemarks;
        this.isUtilizationHcd = isUtilizationHcd;
        this.utilizationHcdAward = utilizationHcdAward;
        this.utilizationHcdTimeline = utilizationHcdTimeline;
        this.utilizationHcdRemarks = utilizationHcdRemarks;
        this.officerrecommendation = officerrecommendation;
        this.officerrecommendation_remark = officerrecommendation_remark;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

    public int getHcd_flowers_Consolidators_id() {
        return hcd_flowers_Consolidators_id;
    }

    public void setHcd_flowers_Consolidators_id(int hcd_flowers_Consolidators_id) {
        this.hcd_flowers_Consolidators_id = hcd_flowers_Consolidators_id;
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

    public String getName_of_applicant() {
        return name_of_applicant;
    }

    public void setName_of_applicant(String name_of_applicant) {
        this.name_of_applicant = name_of_applicant;
    }

    public String getExport_licence() {
        return export_licence;
    }

    public void setExport_licence(String export_licence) {
        this.export_licence = export_licence;
    }

    public String getPostal_address() {
        return postal_address;
    }

    public void setPostal_address(String postal_address) {
        this.postal_address = postal_address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getIslistofcomapanycertificate() {
        return islistofcomapanycertificate;
    }

    public void setIslistofcomapanycertificate(String islistofcomapanycertificate) {
        this.islistofcomapanycertificate = islistofcomapanycertificate;
    }

    public String getListofcomapanycertificateAward() {
        return listofcomapanycertificateAward;
    }

    public void setListofcomapanycertificateAward(String listofcomapanycertificateAward) {
        this.listofcomapanycertificateAward = listofcomapanycertificateAward;
    }

    public String getListofcomapanycertificateTimeline() {
        return listofcomapanycertificateTimeline;
    }

    public void setListofcomapanycertificateTimeline(String listofcomapanycertificateTimeline) {
        this.listofcomapanycertificateTimeline = listofcomapanycertificateTimeline;
    }

    public String getListofcomapanycertificateRemarks() {
        return listofcomapanycertificateRemarks;
    }

    public void setListofcomapanycertificateRemarks(String listofcomapanycertificateRemarks) {
        this.listofcomapanycertificateRemarks = listofcomapanycertificateRemarks;
    }

    public String getIsValididtyOfSupplliers() {
        return isValididtyOfSupplliers;
    }

    public void setIsValididtyOfSupplliers(String isValididtyOfSupplliers) {
        this.isValididtyOfSupplliers = isValididtyOfSupplliers;
    }

    public String getValididtyOfSupplliersAward() {
        return valididtyOfSupplliersAward;
    }

    public void setValididtyOfSupplliersAward(String valididtyOfSupplliersAward) {
        this.valididtyOfSupplliersAward = valididtyOfSupplliersAward;
    }

    public String getValididtyOfSupplliersTimeline() {
        return valididtyOfSupplliersTimeline;
    }

    public void setValididtyOfSupplliersTimeline(String valididtyOfSupplliersTimeline) {
        this.valididtyOfSupplliersTimeline = valididtyOfSupplliersTimeline;
    }

    public String getValididtyOfSupplliersRemarks() {
        return valididtyOfSupplliersRemarks;
    }

    public void setValididtyOfSupplliersRemarks(String valididtyOfSupplliersRemarks) {
        this.valididtyOfSupplliersRemarks = valididtyOfSupplliersRemarks;
    }

    public String getIsCertificationToksh1758() {
        return isCertificationToksh1758;
    }

    public void setIsCertificationToksh1758(String isCertificationToksh1758) {
        this.isCertificationToksh1758 = isCertificationToksh1758;
    }

    public String getCertificationToksh1758Award() {
        return certificationToksh1758Award;
    }

    public void setCertificationToksh1758Award(String certificationToksh1758Award) {
        this.certificationToksh1758Award = certificationToksh1758Award;
    }

    public String getCertificationToksh1758Timeline() {
        return certificationToksh1758Timeline;
    }

    public void setCertificationToksh1758Timeline(String certificationToksh1758Timeline) {
        this.certificationToksh1758Timeline = certificationToksh1758Timeline;
    }

    public String getCertificationToksh1758Remarks() {
        return certificationToksh1758Remarks;
    }

    public void setCertificationToksh1758Remarks(String certificationToksh1758Remarks) {
        this.certificationToksh1758Remarks = certificationToksh1758Remarks;
    }

    public String getIsCopyHcdExportlicence() {
        return isCopyHcdExportlicence;
    }

    public void setIsCopyHcdExportlicence(String isCopyHcdExportlicence) {
        this.isCopyHcdExportlicence = isCopyHcdExportlicence;
    }

    public String getCopyHcdExportlicenceAward() {
        return copyHcdExportlicenceAward;
    }

    public void setCopyHcdExportlicenceAward(String copyHcdExportlicenceAward) {
        this.copyHcdExportlicenceAward = copyHcdExportlicenceAward;
    }

    public String getCopyHcdExportlicenceTimeline() {
        return copyHcdExportlicenceTimeline;
    }

    public void setCopyHcdExportlicenceTimeline(String copyHcdExportlicenceTimeline) {
        this.copyHcdExportlicenceTimeline = copyHcdExportlicenceTimeline;
    }

    public String getCopyHcdExportlicenceRemarks() {
        return copyHcdExportlicenceRemarks;
    }

    public void setCopyHcdExportlicenceRemarks(String copyHcdExportlicenceRemarks) {
        this.copyHcdExportlicenceRemarks = copyHcdExportlicenceRemarks;
    }

    public String getIsEvidenceRegistrationNationalTraceability() {
        return isEvidenceRegistrationNationalTraceability;
    }

    public void setIsEvidenceRegistrationNationalTraceability(String isEvidenceRegistrationNationalTraceability) {
        this.isEvidenceRegistrationNationalTraceability = isEvidenceRegistrationNationalTraceability;
    }

    public String getEvidenceRegistrationNationalTraceabilityAward() {
        return evidenceRegistrationNationalTraceabilityAward;
    }

    public void setEvidenceRegistrationNationalTraceabilityAward(String evidenceRegistrationNationalTraceabilityAward) {
        this.evidenceRegistrationNationalTraceabilityAward = evidenceRegistrationNationalTraceabilityAward;
    }

    public String getEvidenceRegistrationNationalTraceabilityTimeline() {
        return evidenceRegistrationNationalTraceabilityTimeline;
    }

    public void setEvidenceRegistrationNationalTraceabilityTimeline(String evidenceRegistrationNationalTraceabilityTimeline) {
        this.evidenceRegistrationNationalTraceabilityTimeline = evidenceRegistrationNationalTraceabilityTimeline;
    }

    public String getEvidenceRegistrationNationalTraceabilityRemarks() {
        return evidenceRegistrationNationalTraceabilityRemarks;
    }

    public void setEvidenceRegistrationNationalTraceabilityRemarks(String evidenceRegistrationNationalTraceabilityRemarks) {
        this.evidenceRegistrationNationalTraceabilityRemarks = evidenceRegistrationNationalTraceabilityRemarks;
    }

    public String getIsevidenceOfSingleWindow() {
        return isevidenceOfSingleWindow;
    }

    public void setIsevidenceOfSingleWindow(String isevidenceOfSingleWindow) {
        this.isevidenceOfSingleWindow = isevidenceOfSingleWindow;
    }

    public String getEvidenceOfSingleWindowAward() {
        return evidenceOfSingleWindowAward;
    }

    public void setEvidenceOfSingleWindowAward(String evidenceOfSingleWindowAward) {
        this.evidenceOfSingleWindowAward = evidenceOfSingleWindowAward;
    }

    public String getEvidenceOfSingleWindowTimeline() {
        return evidenceOfSingleWindowTimeline;
    }

    public void setEvidenceOfSingleWindowTimeline(String evidenceOfSingleWindowTimeline) {
        this.evidenceOfSingleWindowTimeline = evidenceOfSingleWindowTimeline;
    }

    public String getEvidenceOfSingleWindowRemarks() {
        return evidenceOfSingleWindowRemarks;
    }

    public void setEvidenceOfSingleWindowRemarks(String evidenceOfSingleWindowRemarks) {
        this.evidenceOfSingleWindowRemarks = evidenceOfSingleWindowRemarks;
    }

    public String getIsEvidenceOfAttendanceAnnualtraning() {
        return isEvidenceOfAttendanceAnnualtraning;
    }

    public void setIsEvidenceOfAttendanceAnnualtraning(String isEvidenceOfAttendanceAnnualtraning) {
        this.isEvidenceOfAttendanceAnnualtraning = isEvidenceOfAttendanceAnnualtraning;
    }

    public String getEvidenceOfAttendanceAnnualtraningAward() {
        return evidenceOfAttendanceAnnualtraningAward;
    }

    public void setEvidenceOfAttendanceAnnualtraningAward(String evidenceOfAttendanceAnnualtraningAward) {
        this.evidenceOfAttendanceAnnualtraningAward = evidenceOfAttendanceAnnualtraningAward;
    }

    public String getEvidenceOfAttendanceAnnualtraningTimeline() {
        return evidenceOfAttendanceAnnualtraningTimeline;
    }

    public void setEvidenceOfAttendanceAnnualtraningTimeline(String evidenceOfAttendanceAnnualtraningTimeline) {
        this.evidenceOfAttendanceAnnualtraningTimeline = evidenceOfAttendanceAnnualtraningTimeline;
    }

    public String getEvidenceOfAttendanceAnnualtraningRemarks() {
        return evidenceOfAttendanceAnnualtraningRemarks;
    }

    public void setEvidenceOfAttendanceAnnualtraningRemarks(String evidenceOfAttendanceAnnualtraningRemarks) {
        this.evidenceOfAttendanceAnnualtraningRemarks = evidenceOfAttendanceAnnualtraningRemarks;
    }

    public String getIsVettingMarksCert() {
        return isVettingMarksCert;
    }

    public void setIsVettingMarksCert(String isVettingMarksCert) {
        this.isVettingMarksCert = isVettingMarksCert;
    }

    public String getVettingMarksCertAward() {
        return vettingMarksCertAward;
    }

    public void setVettingMarksCertAward(String vettingMarksCertAward) {
        this.vettingMarksCertAward = vettingMarksCertAward;
    }

    public String getVettingMarksCertTimeline() {
        return vettingMarksCertTimeline;
    }

    public void setVettingMarksCertTimeline(String vettingMarksCertTimeline) {
        this.vettingMarksCertTimeline = vettingMarksCertTimeline;
    }

    public String getVettingMarksCertRemarks() {
        return vettingMarksCertRemarks;
    }

    public void setVettingMarksCertRemarks(String vettingMarksCertRemarks) {
        this.vettingMarksCertRemarks = vettingMarksCertRemarks;
    }

    public String getIsUtilizationHcd() {
        return isUtilizationHcd;
    }

    public void setIsUtilizationHcd(String isUtilizationHcd) {
        this.isUtilizationHcd = isUtilizationHcd;
    }

    public String getUtilizationHcdAward() {
        return utilizationHcdAward;
    }

    public void setUtilizationHcdAward(String utilizationHcdAward) {
        this.utilizationHcdAward = utilizationHcdAward;
    }

    public String getUtilizationHcdTimeline() {
        return utilizationHcdTimeline;
    }

    public void setUtilizationHcdTimeline(String utilizationHcdTimeline) {
        this.utilizationHcdTimeline = utilizationHcdTimeline;
    }

    public String getUtilizationHcdRemarks() {
        return utilizationHcdRemarks;
    }

    public void setUtilizationHcdRemarks(String utilizationHcdRemarks) {
        this.utilizationHcdRemarks = utilizationHcdRemarks;
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

    public String getOfficerrecommendation() {
        return officerrecommendation;
    }

    public void setOfficerrecommendation(String officerrecommendation) {
        this.officerrecommendation = officerrecommendation;
    }

    public String getOfficerrecommendation_remark() {
        return officerrecommendation_remark;
    }

    public void setOfficerrecommendation_remark(String officerrecommendation_remark) {
        this.officerrecommendation_remark = officerrecommendation_remark;
    }
}
