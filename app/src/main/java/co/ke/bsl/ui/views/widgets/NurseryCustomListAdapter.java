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
import co.ke.bsl.data.model.HorticultureProduceTransportation;
import co.ke.bsl.pojo.FlowersConsolidators;
import co.ke.bsl.pojo.HorticultureProduceTransportationDetails;
import co.ke.bsl.pojo.NurseyInspection;

public class NurseryCustomListAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<NurseyInspection> nurseyInspectionsList;
    private LayoutInflater inflater = null;

    public NurseryCustomListAdapter(Activity context, ArrayList<NurseyInspection> nurseyInspectionsList) {
        this.nurseyInspectionsList = nurseyInspectionsList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return nurseyInspectionsList.size();
    }


    @Override
    public Object getItem(int position) {
        return nurseyInspectionsList.get(position);
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

        NurseyInspection selecteditem = nurseyInspectionsList.get(position);
        textviewdocument_no.setText("Document No " + selecteditem.getDocumentNumber());
        textviewdocument_date.setText("Doc Date " + selecteditem.getDocumentDate());
        textviewlicence_number.setText("Licence No " + selecteditem.getNurseryLicence());
        textviewapplicant_name.setText("Applicant Name " + selecteditem.getNameOfApplicant());

        return itemview;

    }
}
