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
import co.ke.bsl.pojo.CoffeeMillerLicenceApplicationDetails;

public class CoffeeMillerLicenseApplicationListAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<CoffeeMillerLicenceApplicationDetails> coffeeMillerLicenceApplicationDetailsArrayList;
    private LayoutInflater inflater = null;

    public CoffeeMillerLicenseApplicationListAdapter(Activity context, ArrayList<CoffeeMillerLicenceApplicationDetails> coffeeMillerLicenceApplicationDetailsArrayList) {
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.coffeeMillerLicenceApplicationDetailsArrayList = coffeeMillerLicenceApplicationDetailsArrayList;
    }

    @Override
    public int getCount() {
        return coffeeMillerLicenceApplicationDetailsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return coffeeMillerLicenceApplicationDetailsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemview = convertView;

        itemview = (itemview == null) ? inflater.inflate(R.layout.coffee_miller_list_row, null) : itemview;
        TextView textviewdocument_no = (TextView) itemview.findViewById(R.id.tv_cm_document_number);
        TextView textviewdocument_date = (TextView) itemview.findViewById(R.id.tv_cm_document_date);
        TextView textviewlicence_number = (TextView) itemview.findViewById(R.id.tv_cm_licence_number);
        TextView textviewapplicant_name = (TextView) itemview.findViewById(R.id.tv_cm_name_of_applicant);

        CoffeeMillerLicenceApplicationDetails selecteditem = coffeeMillerLicenceApplicationDetailsArrayList.get(position);
        textviewdocument_no.setText("Document Number: "+ selecteditem.getDocumentNumber());
        textviewdocument_date.setText("Document Date: "+ selecteditem.getDocumentDate());
        textviewlicence_number.setText("Licence Number: "+ selecteditem.getLicenceNumber());
        textviewapplicant_name.setText("Applicant Name: "+ selecteditem.getApplicantName());

        return itemview;
    }
}
