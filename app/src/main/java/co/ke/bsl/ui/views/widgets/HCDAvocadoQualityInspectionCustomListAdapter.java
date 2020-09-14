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
import co.ke.bsl.pojo.AvocadoQualityInspection;

public class HCDAvocadoQualityInspectionCustomListAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<AvocadoQualityInspection> avocadoQualityInspectionlist;
    private LayoutInflater inflater = null;

    public HCDAvocadoQualityInspectionCustomListAdapter(Activity context, ArrayList<AvocadoQualityInspection> avocadoQualityInspectionlist) {
        this.avocadoQualityInspectionlist = avocadoQualityInspectionlist;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return avocadoQualityInspectionlist.size();
    }


    @Override
    public Object getItem(int position) {
        return avocadoQualityInspectionlist.get(position);
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

        AvocadoQualityInspection selecteditem = avocadoQualityInspectionlist.get(position);
        textviewdocument_no.setText("Document No "+selecteditem.getDocumentNumber());
        textviewdocument_date.setText("Doc Date "+selecteditem.getDocumentDate());
        textviewletter_of_comfort.setText("letter of comfort "+selecteditem.getHorticultureExporterRequest());
        textviewapplicant_name.setText("Applicant Name "+selecteditem.getNameOfApplicant());

        return itemview;

    }
}
