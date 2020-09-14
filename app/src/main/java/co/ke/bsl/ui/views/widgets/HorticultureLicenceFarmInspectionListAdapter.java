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
import co.ke.bsl.pojo.HorticultureCropExportLicenceFarmInspectionDetails;

public class HorticultureLicenceFarmInspectionListAdapter extends BaseAdapter {

    Activity context;
    private ArrayList<HorticultureCropExportLicenceFarmInspectionDetails> horticultureCropExportLicenceFarmInspectionDetailsArrayList;
    private LayoutInflater inflater = null;

    public HorticultureLicenceFarmInspectionListAdapter(Activity context, ArrayList<HorticultureCropExportLicenceFarmInspectionDetails> horticultureCropExportLicenceFarmInspectionDetailsArrayList) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.horticultureCropExportLicenceFarmInspectionDetailsArrayList = horticultureCropExportLicenceFarmInspectionDetailsArrayList;
    }

    @Override
    public int getCount() {
        return horticultureCropExportLicenceFarmInspectionDetailsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return horticultureCropExportLicenceFarmInspectionDetailsArrayList.get(position);
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

        HorticultureCropExportLicenceFarmInspectionDetails selecteditem = horticultureCropExportLicenceFarmInspectionDetailsArrayList.get(position);
        textviewdocument_no.setText("Document Number: "+ selecteditem.getDocumentNumber());
        textviewdocument_date.setText("Document Date: "+ selecteditem.getDocumentDate());
        textviewerect_number.setText("County: "+ selecteditem.getCountyId());
        textviewapplicant_name.setText("Applicant Name: "+ selecteditem.getNameOfApplicant());

        return itemview;
    }
}
