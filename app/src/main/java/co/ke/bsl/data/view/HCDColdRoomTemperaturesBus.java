package co.ke.bsl.data.view;

public class HCDColdRoomTemperaturesBus {
    private static HCDColdRoomTemperaturesBus single_instance = null;

    private HCDColdRoomTemperaturesBus() {
    }

    public static HCDColdRoomTemperaturesBus getInstance() {
        if (single_instance == null)
            single_instance = new HCDColdRoomTemperaturesBus();

        return single_instance;
    }

    public static HCDColdRoomTemperaturesBus getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(HCDColdRoomTemperaturesBus single_instance) {
        HCDColdRoomTemperaturesBus.single_instance = single_instance;
    }

    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String localID;
    private String coldRoom;
    private String time;
    private String indicatorTempe;
    private String thermometerProbeTem;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(String documentDate) {
        this.documentDate = documentDate;
    }

    public String getNameOfApplicant() {
        return nameOfApplicant;
    }

    public void setNameOfApplicant(String nameOfApplicant) {
        this.nameOfApplicant = nameOfApplicant;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getColdRoom() {
        return coldRoom;
    }

    public void setColdRoom(String coldRoom) {
        this.coldRoom = coldRoom;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIndicatorTempe() {
        return indicatorTempe;
    }

    public void setIndicatorTempe(String indicatorTempe) {
        this.indicatorTempe = indicatorTempe;
    }

    public String getThermometerProbeTem() {
        return thermometerProbeTem;
    }

    public void setThermometerProbeTem(String thermometerProbeTem) {
        this.thermometerProbeTem = thermometerProbeTem;
    }
}
