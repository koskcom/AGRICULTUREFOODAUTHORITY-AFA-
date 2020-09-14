package co.ke.bsl.ui.views.widgets;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import co.ke.bsl.R;
import co.ke.bsl.pojo.PulpingStationLicenseApplicationDetails;

public class PulpingStationLicenseApplicationListAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<PulpingStationLicenseApplicationDetails> pulpingStationLicenseApplicationDetailsArrayList;
    private LayoutInflater inflater = null;

    public PulpingStationLicenseApplicationListAdapter(Activity context, ArrayList<PulpingStationLicenseApplicationDetails> pulpingStationLicenseApplicationDetailsArrayList) {
        this.pulpingStationLicenseApplicationDetailsArrayList = pulpingStationLicenseApplicationDetailsArrayList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return pulpingStationLicenseApplicationDetailsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return pulpingStationLicenseApplicationDetailsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemview = convertView;

        itemview = (itemview == null) ? inflater.inflate(R.layout.pulping_station_list_row, null) : itemview;
        TextView textviewdocument_no = (TextView) itemview.findViewById(R.id.tv_ps_document_number);
        TextView textviewdocument_date = (TextView) itemview.findViewById(R.id.tv_ps_document_date);
        TextView textviewerect_number = (TextView) itemview.findViewById(R.id.tv_ps_authority_to_erect_number);
        TextView textviewapplicant_name = (TextView) itemview.findViewById(R.id.tv_ps_name_of_applicant);

        PulpingStationLicenseApplicationDetails selecteditem = pulpingStationLicenseApplicationDetailsArrayList.get(position);
        textviewdocument_no.setText("Document Number: "+ selecteditem.getDocumentNumber());
        textviewdocument_date.setText("Document Date: "+ selecteditem.getDocumentDate());
        textviewerect_number.setText("Authority to Erect Number: "+ selecteditem.getAuthorityToErectNumber());
        textviewapplicant_name.setText("Applicant Name: "+ selecteditem.getApplicantName());

        return itemview;
    }
}
