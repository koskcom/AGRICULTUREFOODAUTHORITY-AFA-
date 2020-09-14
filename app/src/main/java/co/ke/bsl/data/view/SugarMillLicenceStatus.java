package co.ke.bsl.data.view;

public class SugarMillLicenceStatus{
        public boolean isState() {
            return state;
        }

        public void setState(boolean state) {
            this.state = state;
        }

    public String getSugarMillLicenceStatus_id() {
        return sugarMillLicenceStatus_id;
    }

    public void setSugarMillLicenceStatus_id(String sugarMillLicenceStatus_id) {
        this.sugarMillLicenceStatus_id = sugarMillLicenceStatus_id;
    }

    public String getRemote_id() {
            return remote_id;
        }

        public void setRemote_id(String remote_id) {
            this.remote_id = remote_id;
        }

    public SugarMillLicenceStatus(boolean state, String sugarMillLicenceStatus_id, String remote_id) {
        this.state = state;
        this.sugarMillLicenceStatus_id = sugarMillLicenceStatus_id;
        this.remote_id = remote_id;
    }

    private boolean state;
        private String sugarMillLicenceStatus_id;
        private String remote_id;

}