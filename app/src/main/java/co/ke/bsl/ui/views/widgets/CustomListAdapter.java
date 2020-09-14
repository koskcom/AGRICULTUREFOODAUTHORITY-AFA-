package co.ke.bsl.ui.views.widgets;

import android.app.Activity;
import android.app.LauncherActivity;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import co.ke.bsl.R;
import co.ke.bsl.pojo.SugarMillDetails;
import co.ke.bsl.ui.views.fragments.AFASugarMillLicenceComplianceVisitChecklist;

public class CustomListAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<SugarMillDetails> sugarMilllist;
    private LayoutInflater inflater = null;

    public CustomListAdapter(Activity context, ArrayList<SugarMillDetails> sugarMilllist) {
        this.sugarMilllist = sugarMilllist;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return sugarMilllist.size();
    }


    @Override
    public Object getItem(int position) {
        return sugarMilllist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View contentview, ViewGroup parent) {
        View itemview = contentview;

        itemview = (itemview == null) ? inflater.inflate(R.layout.list_row, null) : itemview;
        TextView textviewdocument_no = (TextView) itemview.findViewById(R.id.textviewdocument_no);
        TextView textviewdocument_date = (TextView) itemview.findViewById(R.id.textviewdocument_date);
        TextView textviewletter_of_comfort = (TextView) itemview.findViewById(R.id.textviewletter_of_comfort);
        TextView textviewapplicant_name = (TextView) itemview.findViewById(R.id.textviewapplicant_name);

        SugarMillDetails selecteditem = sugarMilllist.get(position);
        textviewdocument_no.setText("Document No: "+selecteditem.getDocument_number());
        textviewdocument_date.setText("Doc Date: "+selecteditem.getDocument_date());
        textviewletter_of_comfort.setText("Sugar Miller licence: "+selecteditem.getLetter_of_comfort());
        textviewapplicant_name.setText("Applicant Name: "+selecteditem.getC_BPartner_ID());

        return itemview;

    }
}
