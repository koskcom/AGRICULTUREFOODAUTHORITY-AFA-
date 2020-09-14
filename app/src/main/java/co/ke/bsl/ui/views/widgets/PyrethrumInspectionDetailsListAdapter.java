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
import co.ke.bsl.pojo.PyrethrumInspectionChecklist;

public class PyrethrumInspectionDetailsListAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<PyrethrumInspectionChecklist> pyrethrumInspectionChecklistList;
    private LayoutInflater inflater = null;

    public PyrethrumInspectionDetailsListAdapter(Activity context, ArrayList<PyrethrumInspectionChecklist> pyrethrumInspectionDetails) {
        this.pyrethrumInspectionChecklistList = pyrethrumInspectionDetails;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return pyrethrumInspectionChecklistList.size();
    }

    @Override
    public Object getItem(int position) {
        return pyrethrumInspectionChecklistList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemview = convertView;

        itemview = (itemview == null) ? inflater.inflate(R.layout.pyrethrum_list_row, null) : itemview;
        TextView textviewdocument_no = (TextView) itemview.findViewById(R.id.tvdocument_no);
        TextView textviewdocument_date = (TextView) itemview.findViewById(R.id.tvdocument_date);
        TextView textviewnursery_certificate_number = (TextView) itemview.findViewById(R.id.tvnursery_certificate_number);
        TextView textviewapplicant_name = (TextView) itemview.findViewById(R.id.tvapplicant_name);

        PyrethrumInspectionChecklist selecteditem = pyrethrumInspectionChecklistList.get(position);
        textviewdocument_no.setText("Document Number: "+ selecteditem.getDocument_number());
        textviewdocument_date.setText("Document Date: "+ selecteditem.getDocument_date());
        textviewnursery_certificate_number.setText("Cert no: "+ selecteditem.getCertificate_number());
        textviewapplicant_name.setText("Applicant: "+ selecteditem.getName_of_applicant());

        return itemview;

    }
}
