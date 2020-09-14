package co.ke.bsl.data.view;

import androidx.annotation.NonNull;

public class ReccomendationsView {
    private String Name;
    private String serverID;

    public ReccomendationsView(String name, String serverID) {
        this.Name = name;
        this.serverID = serverID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getServerID() {
        return serverID;
    }

    public void setServerID(String serverID) {
        this.serverID = serverID;
    }

    @NonNull
    @Override
    public String toString() {
        return this.Name;
    }
}
