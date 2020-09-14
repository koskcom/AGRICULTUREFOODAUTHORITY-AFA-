package co.ke.bsl.data.view;

public class PersanlHygieneBus {
    private static PersanlHygieneBus single_instance = null;

    private PersanlHygieneBus() {
    }

    public static PersanlHygieneBus getInstance() {
        if (single_instance == null)
            single_instance = new PersanlHygieneBus();

        return single_instance;
    }

    public static PersanlHygieneBus getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(PersanlHygieneBus single_instance) {
        PersanlHygieneBus.single_instance = single_instance;
    }
    private String ssnameOfApplicant;
    private String localID;
    private String names;
    private String nationalId;
    private String medicalCertNo;
    private String isdustCots;
    private String isjewels;
    private String isnailsCut;
    private String isbodyClean;
    private String isshoes;

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
}
