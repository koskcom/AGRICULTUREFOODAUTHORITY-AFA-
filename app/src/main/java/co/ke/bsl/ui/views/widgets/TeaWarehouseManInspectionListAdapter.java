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
import co.ke.bsl.pojo.TeaWarehouseManInspectionDataCollection;

public class TeaWarehouseManInspectionListAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<TeaWarehouseManInspectionDataCollection> teaWarehouseManInspectionDataCollection;
    private LayoutInflater inflater = null;

    public TeaWarehouseManInspectionListAdapter(Activity context, ArrayList<TeaWarehouseManInspectionDataCollection> teaWarehouseManInspectionDataCollections) {
        this.teaWarehouseManInspectionDataCollection = teaWarehouseManInspectionDataCollections;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return teaWarehouseManInspectionDataCollection.size();
    }

    @Override
    public Object getItem(int position) {
        return teaWarehouseManInspectionDataCollection.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemview = convertView;

        itemview = (itemview == null) ? inflater.inflate(R.layout.tea_warehouse_list_row, null) : itemview;
        TextView textviewdocument_no = (TextView) itemview.findViewById(R.id.tvdocument_number);
        TextView textviewdocument_date = (TextView) itemview.findViewById(R.id.tvdocument_dt);
        TextView textviewlicence_number = (TextView) itemview.findViewById(R.id.tvlicense_number);
        TextView textviewapplicant_name = (TextView) itemview.findViewById(R.id.tvname_of_applicant);

        TeaWarehouseManInspectionDataCollection selecteditem = teaWarehouseManInspectionDataCollection.get(position);
        textviewdocument_no.setText("Document No: "+ selecteditem.getDocument_number());
        textviewdocument_date.setText("Doc Date: "+ selecteditem.getDocument_date());
        textviewlicence_number.setText("License No: "+ selecteditem.getLicense_number());
        textviewapplicant_name.setText("Applicant Name: "+ selecteditem.getName_of_applicant());

        return itemview;
    }
}
