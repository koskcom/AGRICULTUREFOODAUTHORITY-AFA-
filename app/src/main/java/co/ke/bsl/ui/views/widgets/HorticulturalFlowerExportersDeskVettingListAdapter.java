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
import co.ke.bsl.pojo.HorticulturalFlowerExportersDeskVettingDetails;

public class HorticulturalFlowerExportersDeskVettingListAdapter extends BaseAdapter {

    Activity context;
    private ArrayList<HorticulturalFlowerExportersDeskVettingDetails> horticulturalFlowerExportersDeskVettingDetailsArrayList;
    private LayoutInflater inflater = null;

    public HorticulturalFlowerExportersDeskVettingListAdapter(Activity context, ArrayList<HorticulturalFlowerExportersDeskVettingDetails> horticulturalFlowerExportersDeskVettingDetailsArrayList) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.horticulturalFlowerExportersDeskVettingDetailsArrayList = horticulturalFlowerExportersDeskVettingDetailsArrayList;
    }

    @Override
    public int getCount() {
        return horticulturalFlowerExportersDeskVettingDetailsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return horticulturalFlowerExportersDeskVettingDetailsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemview = convertView;

        itemview = (itemview == null) ? inflater.inflate(R.layout.horticulture_flower_exporter_list_row, null) : itemview;
        TextView textviewdocument_no = (TextView) itemview.findViewById(R.id.tv_hfedv_document_number);
        TextView textviewdocument_date = (TextView) itemview.findViewById(R.id.tv_hfedv_document_date);
        TextView textviewerect_number = (TextView) itemview.findViewById(R.id.tv_hfedv_export_licence);
        TextView textviewapplicant_name = (TextView) itemview.findViewById(R.id.tv_hfedv_name_of_applicant);

        HorticulturalFlowerExportersDeskVettingDetails selecteditem = horticulturalFlowerExportersDeskVettingDetailsArrayList.get(position);
        textviewdocument_no.setText("Document Number: "+ selecteditem.getDocument_number());
        textviewdocument_date.setText("Document Date: "+ selecteditem.getDocument_date());
        textviewerect_number.setText("Export Licence: "+ selecteditem.getExport_licence());
        textviewapplicant_name.setText("Applicant Name: "+ selecteditem.getName_of_applicant());

        return itemview;
    }
}
