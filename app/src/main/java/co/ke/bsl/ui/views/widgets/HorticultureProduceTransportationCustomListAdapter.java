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
import co.ke.bsl.pojo.HorticultureProduceTransportationDetails;
import co.ke.bsl.pojo.NurseyInspection;

public class HorticultureProduceTransportationCustomListAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<HorticultureProduceTransportationDetails> horticultureProduceTransportationDetailsList;
    private LayoutInflater inflater = null;

    public HorticultureProduceTransportationCustomListAdapter(Activity context, ArrayList<HorticultureProduceTransportationDetails> horticultureProduceTransportationDetailsList) {
        this.horticultureProduceTransportationDetailsList = horticultureProduceTransportationDetailsList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return horticultureProduceTransportationDetailsList.size();
    }


    @Override
    public Object getItem(int position) {
        return horticultureProduceTransportationDetailsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View contentview, ViewGroup parent) {
        View itemview = contentview;

        itemview = (itemview == null) ? inflater.inflate(R.layout.flower_consolidators_list, null) : itemview;
        TextView textviewdocument_no = (TextView) itemview.findViewById(R.id.textviewdocument_no_n);
        TextView textviewdocument_date = (TextView) itemview.findViewById(R.id.textviewdocument_date_d);
        TextView textviewlicence_number = (TextView) itemview.findViewById(R.id.textviewlicence_number_no);
        TextView textviewapplicant_name = (TextView) itemview.findViewById(R.id.textviewname_of_applicantt);

        HorticultureProduceTransportationDetails selecteditem = horticultureProduceTransportationDetailsList.get(position);
        textviewdocument_no.setText("Document No " + selecteditem.getDocumentNumber());
        textviewdocument_date.setText("Doc Date " + selecteditem.getDocumentDate());
        textviewlicence_number.setText("Licence No " + selecteditem.getExportLicence());
        textviewapplicant_name.setText("Applicant Name " + selecteditem.getNameOfApllicant());

        return itemview;

    }
}
