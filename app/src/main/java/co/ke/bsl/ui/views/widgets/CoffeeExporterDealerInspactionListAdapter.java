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
import co.ke.bsl.pojo.CoffeeExporterDealerInspectionDetails;

public class CoffeeExporterDealerInspactionListAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<CoffeeExporterDealerInspectionDetails> coffeeExporterDealerInspectionDetailsArrayList;
    private LayoutInflater inflater = null;

    public CoffeeExporterDealerInspactionListAdapter(Activity context, ArrayList<CoffeeExporterDealerInspectionDetails> coffeeExporterDealerInspectionDetailsArrayList) {
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.coffeeExporterDealerInspectionDetailsArrayList = coffeeExporterDealerInspectionDetailsArrayList;
    }

    @Override
    public int getCount() {
        return coffeeExporterDealerInspectionDetailsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return coffeeExporterDealerInspectionDetailsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemview = convertView;

        itemview = (itemview == null) ? inflater.inflate(R.layout.coffee_exporter_list_row, null) : itemview;
        TextView textviewdocument_no = (TextView) itemview.findViewById(R.id.tv_ce_document_number);
        TextView textviewdocument_date = (TextView) itemview.findViewById(R.id.tv_ce_document_date);
        TextView textviewlicence_number = (TextView) itemview.findViewById(R.id.tv_ce_licence_number);
        TextView textviewapplicant_name = (TextView) itemview.findViewById(R.id.tv_ce_name_of_applicant);

        CoffeeExporterDealerInspectionDetails selecteditem = coffeeExporterDealerInspectionDetailsArrayList.get(position);
        textviewdocument_no.setText("Document Number: "+ selecteditem.getDocumentNumber());
        textviewdocument_date.setText("Document Date: "+ selecteditem.getDocumentDate());
        textviewlicence_number.setText("Dealer Licence Number: "+ selecteditem.getDealerLicenceNumber());
        textviewapplicant_name.setText("Applicant Name: "+ selecteditem.getApplicantName());

        return itemview;
    }
}
