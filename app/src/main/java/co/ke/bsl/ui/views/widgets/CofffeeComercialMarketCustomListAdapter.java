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
import co.ke.bsl.pojo.CoffeeCommercialAgent;

public class CofffeeComercialMarketCustomListAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<CoffeeCommercialAgent> coffeeCommercialAgentlist;
    private LayoutInflater inflater = null;

    public CofffeeComercialMarketCustomListAdapter(Activity context, ArrayList<CoffeeCommercialAgent> coffeeCommercialAgentlist) {
        this.coffeeCommercialAgentlist = coffeeCommercialAgentlist;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return coffeeCommercialAgentlist.size();
    }


    @Override
    public Object getItem(int position) {
        return coffeeCommercialAgentlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View contentview, ViewGroup parent) {
        View itemview = contentview;

        itemview = (itemview == null) ? inflater.inflate(R.layout.coffee_market_agent_list, null) : itemview;
        TextView textviewdocument_no = (TextView) itemview.findViewById(R.id.textviewdocument_no);
        TextView textviewdocument_date = (TextView) itemview.findViewById(R.id.textviewdocument_date);
        TextView textviewlicenceno = (TextView) itemview.findViewById(R.id.textviewletter_of_comfort);
        TextView textviewapplicant_name = (TextView) itemview.findViewById(R.id.textviewapplicant_name);

        CoffeeCommercialAgent selecteditem = coffeeCommercialAgentlist.get(position);
        textviewdocument_no.setText("Document No "+selecteditem.getDocument_number());
        textviewdocument_date.setText("Doc Date "+selecteditem.getDocument_date());
        textviewlicenceno.setText("licence No "+selecteditem.getLicence_number());
        textviewapplicant_name.setText("Applicant Name "+selecteditem.getName_of_applicant());

        return itemview;

    }
}
