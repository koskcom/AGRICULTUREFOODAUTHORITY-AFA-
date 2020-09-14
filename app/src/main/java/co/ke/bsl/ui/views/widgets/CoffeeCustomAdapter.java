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

import co.ke.bsl.pojo.CoffeeNursercertInsp;


public class CoffeeCustomAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<CoffeeNursercertInsp> coffeeNursercertInsplist;
    private LayoutInflater inflater = null;

    public CoffeeCustomAdapter(Activity context, ArrayList<CoffeeNursercertInsp> coffeeNursercertInsplist) {
        this.coffeeNursercertInsplist = coffeeNursercertInsplist;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return coffeeNursercertInsplist.size();
    }


    @Override
    public Object getItem(int position) {
        return coffeeNursercertInsplist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View contentview, ViewGroup parent) {
        View itemview = contentview;

        itemview = (itemview == null) ? inflater.inflate(R.layout.coffenurseryinspectioncustomlist, null) : itemview;
        TextView textviewdocument_no = (TextView) itemview.findViewById(R.id.textviewdocument_no_number);
        TextView textviewdocument_date = (TextView) itemview.findViewById(R.id.textviewdocumentdatedate);
        TextView textviewcertifcateno = (TextView) itemview.findViewById(R.id.textviewcert_numbernumber);
        TextView textviewapplicant_name = (TextView) itemview.findViewById(R.id.textviewname_of_applicant_name);

        CoffeeNursercertInsp selecteditem = coffeeNursercertInsplist.get(position);
        textviewdocument_no.setText("Document No: " + selecteditem.getDocumentNumber());
        textviewdocument_date.setText("Document Date: " + selecteditem.getDocumentaDate());
        textviewcertifcateno.setText("Certificate No: " + selecteditem.getCertificateNumber());
        textviewapplicant_name.setText("Applicant Name: " + selecteditem.getApplicantName());

        return itemview;

    }
}
