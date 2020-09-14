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
import co.ke.bsl.data.model.HCDMangoQualityInspection;

public class MangoQualityInspectionRecyclerAdapter extends RecyclerView.Adapter<MangoQualityInspectionRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<HCDMangoQualityInspection> hcdMangoQualityInspectionList;

    @NonNull
    @Override
    public MangoQualityInspectionRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        MangoQualityInspectionRecyclerAdapter.CustomViewHolder viewHolder = new MangoQualityInspectionRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull MangoQualityInspectionRecyclerAdapter.CustomViewHolder holder, int position) {
        HCDMangoQualityInspection hcdMangoQualityInspection = hcdMangoQualityInspectionList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + hcdMangoQualityInspection.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + hcdMangoQualityInspection.getDocumentdate());
        holder.textViewApplicantName.setText("Applicant Name: " + hcdMangoQualityInspection.getExportersName());
        holder.textViewLicenceNumber.setText("Licence Number: " + hcdMangoQualityInspection.getInspectionRequestNo());
    }

    public MangoQualityInspectionRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<HCDMangoQualityInspection> hcdMangoQualityInspectionList) {
        this.hcdMangoQualityInspectionList = hcdMangoQualityInspectionList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != hcdMangoQualityInspectionList ? hcdMangoQualityInspectionList.size() : 0);
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
