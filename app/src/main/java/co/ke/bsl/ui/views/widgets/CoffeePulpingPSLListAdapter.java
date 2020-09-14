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
import co.ke.bsl.pojo.CoffeePulpinglicenceApllPSL;
import co.ke.bsl.pojo.TeaPackerChecklist;

public class CoffeePulpingPSLListAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<CoffeePulpinglicenceApllPSL> coffeePulpinglicenceApllPSLlist;
    private LayoutInflater inflater = null;

    public CoffeePulpingPSLListAdapter(Activity context, ArrayList<CoffeePulpinglicenceApllPSL> coffeePulpinglicenceApllPSLlist) {
        this.coffeePulpinglicenceApllPSLlist = coffeePulpinglicenceApllPSLlist;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return coffeePulpinglicenceApllPSLlist.size();
    }


    @Override
    public Object getItem(int position) {
        return coffeePulpinglicenceApllPSLlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View contentview, ViewGroup parent) {
        View itemview = contentview;

        itemview = (itemview == null) ? inflater.inflate(R.layout.coffee_list_adapter, null) : itemview;
        TextView textviewdocument_no = (TextView) itemview.findViewById(R.id.textviewdocument_no_no);
        TextView textviewdocument_date = (TextView) itemview.findViewById(R.id.textviewdocument_date_date);
        TextView textviewlicence_number = (TextView) itemview.findViewById(R.id.textviewlicence_number_number);
        TextView textviewapplicant_name = (TextView) itemview.findViewById(R.id.textviewname_of_applicant_applicant);

        CoffeePulpinglicenceApllPSL selecteditem = coffeePulpinglicenceApllPSLlist.get(position);
        textviewdocument_no.setText("Document No: " + selecteditem.getDocument_number());
        textviewdocument_date.setText("Date Visited: " + selecteditem.getVisited_date());
        textviewlicence_number.setText("Licence No: " + selecteditem.getLicence_number());
        textviewapplicant_name.setText("Applicant Name: " + selecteditem.getName_of_applicant());

        return itemview;

    }
}
