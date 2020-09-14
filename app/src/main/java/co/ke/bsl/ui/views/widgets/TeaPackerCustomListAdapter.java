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
import co.ke.bsl.pojo.SugarMillDetails;
import co.ke.bsl.pojo.TeaPackerChecklist;

public class TeaPackerCustomListAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<TeaPackerChecklist> teaPackerChecklistlist;
    private LayoutInflater inflater = null;

    public TeaPackerCustomListAdapter(Activity context, ArrayList<TeaPackerChecklist> teaPackerChecklistlist) {
        this.teaPackerChecklistlist = teaPackerChecklistlist;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return teaPackerChecklistlist.size();
    }


    @Override
    public Object getItem(int position) {
        return teaPackerChecklistlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View contentview, ViewGroup parent) {
        View itemview = contentview;

        itemview = (itemview == null) ? inflater.inflate(R.layout.teapacker_custom_list, null) : itemview;
        TextView textviewdocument_no = (TextView) itemview.findViewById(R.id.textviewdocument_no_no);
        TextView textviewdocument_date = (TextView) itemview.findViewById(R.id.textviewdocument_date_date);
        TextView textviewlicence_number = (TextView) itemview.findViewById(R.id.textviewlicence_number);
        TextView textviewapplicant_name = (TextView) itemview.findViewById(R.id.textviewname_of_applicant);

        TeaPackerChecklist selecteditem = teaPackerChecklistlist.get(position);
        textviewdocument_no.setText("Document No " + selecteditem.getDocumentNo());
        textviewdocument_date.setText("Doc Date " + selecteditem.getDocumentDate());
        textviewlicence_number.setText("Licence No " + selecteditem.getLicenceNo());
        textviewapplicant_name.setText("Applicant Name " + selecteditem.getApplicantName());

        return itemview;

    }
}
