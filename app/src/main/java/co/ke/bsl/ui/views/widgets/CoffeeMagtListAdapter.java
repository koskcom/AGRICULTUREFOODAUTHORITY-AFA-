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
import co.ke.bsl.pojo.CoffeeManagementAgentInsp;

public class CoffeeMagtListAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<CoffeeManagementAgentInsp> coffeeManagementAgentInsplist;
    private LayoutInflater inflater = null;

    public CoffeeMagtListAdapter(Activity context, ArrayList<CoffeeManagementAgentInsp> coffeeManagementAgentInsplist) {
        this.coffeeManagementAgentInsplist = coffeeManagementAgentInsplist;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return coffeeManagementAgentInsplist.size();
    }


    @Override
    public Object getItem(int position) {
        return coffeeManagementAgentInsplist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View contentview, ViewGroup parent) {
        View itemview = contentview;

        itemview = (itemview == null) ? inflater.inflate(R.layout.coffee_management_list_row, null) : itemview;
        TextView textviewdocument_no = (TextView) itemview.findViewById(R.id.textviewdocument_nno);
        TextView textviewdocument_date = (TextView) itemview.findViewById(R.id.textviewdocument_ddate);
        TextView textviewapplicant_name = (TextView) itemview.findViewById(R.id.textviewapplicant_nname);
        TextView textviewlicence_number = (TextView) itemview.findViewById(R.id.textviewlicence_nnumber);

        CoffeeManagementAgentInsp selecteditem = coffeeManagementAgentInsplist.get(position);
        textviewdocument_no.setText("Document No "+selecteditem.getDocumnet_number());
        textviewdocument_date.setText("Doc Date "+selecteditem.getDocument_date());
        textviewlicence_number.setText("Licence number "+selecteditem.getLicence_no());
        textviewapplicant_name.setText("Applicant Name "+selecteditem.getC_BPartner_ID());

        return itemview;

    }
}
