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
import co.ke.bsl.pojo.FlowersConsolidators;
import co.ke.bsl.pojo.TeaPackerChecklist;

public class HCDFlowerConsolidatorsCustomListAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<FlowersConsolidators> flowersConsolidatorslist;
    private LayoutInflater inflater = null;

    public HCDFlowerConsolidatorsCustomListAdapter(Activity context, ArrayList<FlowersConsolidators> flowersConsolidatorslist) {
        this.flowersConsolidatorslist = flowersConsolidatorslist;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return flowersConsolidatorslist.size();
    }


    @Override
    public Object getItem(int position) {
        return flowersConsolidatorslist.get(position);
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

        FlowersConsolidators selecteditem = flowersConsolidatorslist.get(position);
        textviewdocument_no.setText("Document No " + selecteditem.getDocument_number());
        textviewdocument_date.setText("Doc Date " + selecteditem.getDocument_date());
        textviewlicence_number.setText("Licence No " + selecteditem.getExport_licence());
        textviewapplicant_name.setText("Applicant Name " + selecteditem.getName_of_applicant());

        return itemview;

    }
}
