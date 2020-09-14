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
import co.ke.bsl.data.model.HCDAvocadoQualityInspection;
import co.ke.bsl.data.model.TeaPacker;

public class AvocadoQualityInspectionRecyclerAdapter extends RecyclerView.Adapter<AvocadoQualityInspectionRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<HCDAvocadoQualityInspection> hcdAvocadoQualityInspectionList;

    @NonNull
    @Override
    public AvocadoQualityInspectionRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        AvocadoQualityInspectionRecyclerAdapter.CustomViewHolder viewHolder = new AvocadoQualityInspectionRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull AvocadoQualityInspectionRecyclerAdapter.CustomViewHolder holder, int position) {
        HCDAvocadoQualityInspection hcdAvocadoQualityInspection = hcdAvocadoQualityInspectionList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + hcdAvocadoQualityInspection.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + hcdAvocadoQualityInspection.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + hcdAvocadoQualityInspection.getNameOfApplicant());
        holder.textViewLicenceNumber.setText("Licence Number: " + hcdAvocadoQualityInspection.getHorticultureExporterRequest());
    }

    public AvocadoQualityInspectionRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<HCDAvocadoQualityInspection> hcdAvocadoQualityInspectionList) {
        this.hcdAvocadoQualityInspectionList = hcdAvocadoQualityInspectionList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != hcdAvocadoQualityInspectionList ? hcdAvocadoQualityInspectionList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textViewDocumentNumber)
        TextView textViewDocumentNumber;
        @BindView(R.id.textViewDocumentDate)
        TextView textViewDocumentDate;
        @BindView(R.id.textViewApplicantName)
        TextView textViewApplicantName;
        @BindView(R.id.textViewLicenceNumber)
        TextView textViewLicenceNumber;

        public CustomViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
