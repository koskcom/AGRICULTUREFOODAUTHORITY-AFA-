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
import co.ke.bsl.pojo.CottonLintClassingReport;

public class FCDCottonLintClassingReportCusomListAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<CottonLintClassingReport> cottonLintClassingReportArrayList;
    private LayoutInflater inflater = null;

    public FCDCottonLintClassingReportCusomListAdapter(Activity context, ArrayList<CottonLintClassingReport> cottonLintClassingReportArrayList) {
        this.cottonLintClassingReportArrayList = cottonLintClassingReportArrayList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return cottonLintClassingReportArrayList.size();
    }


    @Override
    public Object getItem(int position) {
        return cottonLintClassingReportArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View contentview, ViewGroup parent) {
        View itemview = contentview;

        itemview = (itemview == null) ? inflater.inflate(R.layout.sisal_factory_inspection_list, null) : itemview;
        TextView textviewdocument_no = (TextView) itemview.findViewById(R.id.textviewdocument_no_no);
        TextView textviewdocument_date = (TextView) itemview.findViewById(R.id.textviewdocument_date_date);
        TextView textviewlicence_number = (TextView) itemview.findViewById(R.id.textviewlicence_number);
        TextView textviewapplicant_name = (TextView) itemview.findViewById(R.id.textviewname_of_applicant);

        CottonLintClassingReport selecteditem = cottonLintClassingReportArrayList.get(position);
        textviewdocument_no.setText("Document Number: " + selecteditem.getDocumentNumber());
        textviewdocument_date.setText("Document Date: " + selecteditem.getDocumentDate());
        textviewlicence_number.setText("Cotton Lint Licence: " + selecteditem.getLintLicence());
        textviewapplicant_name.setText("Applicant Name " + selecteditem.getNameOfApplicant());

        return itemview;

    }
}
