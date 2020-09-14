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
import co.ke.bsl.pojo.FoodProcessingInpection;

public class FoodProcessingListAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<FoodProcessingInpection> foodProcessingInpectionlist;
    private LayoutInflater inflater = null;

    public FoodProcessingListAdapter(Activity context, ArrayList<FoodProcessingInpection> foodProcessingInpectionlist) {
        this.foodProcessingInpectionlist = foodProcessingInpectionlist;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return foodProcessingInpectionlist.size();
    }


    @Override
    public Object getItem(int position) {
        return foodProcessingInpectionlist.get(position);
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

        FoodProcessingInpection selecteditem = foodProcessingInpectionlist.get(position);
        textviewdocument_no.setText("Document Number: " + selecteditem.getDocumentNumber());
        textviewdocument_date.setText("Document Date: " + selecteditem.getDocumentDate());
        textviewlicence_number.setText("Licence No " + selecteditem.getFoodCropManufacturingPlanApproval());
        textviewapplicant_name.setText("Applicant Name " + selecteditem.getNameOfApplicant());

        return itemview;

    }
}
