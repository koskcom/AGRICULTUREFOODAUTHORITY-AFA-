package co.ke.bsl.ui.views.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.R;
import co.ke.bsl.data.model.PyrethrumInspection;

public class PyrethrumInspectionRecyclerAdapter extends RecyclerView.Adapter<PyrethrumInspectionRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<PyrethrumInspection> pyrethrumInspectionList;

    @NonNull
    @Override
    public PyrethrumInspectionRecyclerAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pyrethrum_inspection_list_adapter, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull PyrethrumInspectionRecyclerAdapter.CustomViewHolder holder, int position) {
        PyrethrumInspection pyrethrumInspection = pyrethrumInspectionList.get(position);

        holder.textApplicant_name.setText("Applicant name: " + pyrethrumInspection.getName_of_applicant());
        holder.textdoc_number.setText("Document Number: " + pyrethrumInspection.getDocument_number());
        holder.textdocument_date.setText("Document Date: " + pyrethrumInspection.getDocument_date());
        holder.textnursery_cert_number.setText("Certificate Number: " + pyrethrumInspection.getCertificate_number());
    }

    public PyrethrumInspectionRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<PyrethrumInspection> pyrethrumInspectionList) {
        this.pyrethrumInspectionList = pyrethrumInspectionList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (null != pyrethrumInspectionList ? pyrethrumInspectionList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtApplicant_name)
        TextView textApplicant_name;
        @BindView(R.id.txtdocument_date)
        TextView textdocument_date;
        @BindView(R.id.txtnursery_certificate_number)
        TextView textnursery_cert_number;
        @BindView(R.id.txtdoc_number)
        TextView textdoc_number;


        public CustomViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
