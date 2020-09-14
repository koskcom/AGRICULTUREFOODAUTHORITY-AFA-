package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class HCDColdRoomTemperatures {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int hcdColdRoomTemperatures_id;

    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String localID;
    private String coldRoom;
    private String time;
    private String indicatorTempe;
    private String thermometerProbeTem;
    private String serverID;
    private boolean is_synced;
    private String remote_id;

    @Ignore
    public HCDColdRoomTemperatures() {
    }

    public HCDColdRoomTemperatures(int hcdColdRoomTemperatures_id, String documentNumber, String documentDate, String nameOfApplicant, String localID, String coldRoom, String time, String indicatorTempe, String thermometerProbeTem, boolean is_synced, String remote_id) {
        this.hcdColdRoomTemperatures_id = hcdColdRoomTemperatures_id;
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.nameOfApplicant = nameOfApplicant;
        this.localID = localID;
        this.coldRoom = coldRoom;
        this.time = time;
        this.indicatorTempe = indicatorTempe;
        this.thermometerProbeTem = thermometerProbeTem;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

    public int getHcdColdRoomTemperatures_id() {
        return hcdColdRoomTemperatures_id;
    }

    public void setHcdColdRoomTemperatures_id(int hcdColdRoomTemperatures_id) {
        this.hcdColdRoomTemperatures_id = hcdColdRoomTemperatures_id;
    }

    public String getServerID() {
        return serverID;
    }

    public void setServerID(String serverID) {
        this.serverID = serverID;
    }

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
