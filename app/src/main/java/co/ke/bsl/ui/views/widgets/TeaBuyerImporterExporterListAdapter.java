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
import co.ke.bsl.pojo.TeaBuyerImporterExporterDetails;

public class TeaBuyerImporterExporterListAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<TeaBuyerImporterExporterDetails> teaBuyerImporterExporterDetailsArrayList;
    private LayoutInflater inflater = null;

    public TeaBuyerImporterExporterListAdapter(Activity context, ArrayList<TeaBuyerImporterExporterDetails> teaBuyerImporterExporterDetailsArrayList) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.teaBuyerImporterExporterDetailsArrayList = teaBuyerImporterExporterDetailsArrayList;
    }

    @Override
    public int getCount() {
        return teaBuyerImporterExporterDetailsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return teaBuyerImporterExporterDetailsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemview = convertView;

        itemview = (itemview == null) ? inflater.inflate(R.layout.teabuyer_list_row, null) : itemview;
        TextView textviewdocument_no = (TextView) itemview.findViewById(R.id.textviewdocument_nu_number);
        TextView textviewdocument_date = (TextView) itemview.findViewById(R.id.textviewdocument_dt_date);
        TextView textviewlicence_number = (TextView) itemview.findViewById(R.id.textviewlicence_nu_number);
        TextView textviewapplicant_name = (TextView) itemview.findViewById(R.id.textviewname_of_app_applicant);

        TeaBuyerImporterExporterDetails selecteditem = teaBuyerImporterExporterDetailsArrayList.get(position);
        textviewdocument_no.setText("Document No " + selecteditem.getDocumentDate());
        textviewdocument_date.setText("Doc Date " + selecteditem.getDocumentDate());
        textviewlicence_number.setText("Licence No " + selecteditem.getLicenseNumber());
        textviewapplicant_name.setText("Applicant Name " + selecteditem.getApplicantName());

        return itemview;
    }
}
