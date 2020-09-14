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
import co.ke.bsl.data.model.FCDSisalFactoryInspection;
import co.ke.bsl.data.model.TeaPacker;

public class SisalFactoryInspectionRecyclerAdapter extends RecyclerView.Adapter<SisalFactoryInspectionRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<FCDSisalFactoryInspection> fcdSisalFactoryInspectionList;

    @NonNull
    @Override
    public SisalFactoryInspectionRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        SisalFactoryInspectionRecyclerAdapter.CustomViewHolder viewHolder = new SisalFactoryInspectionRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull SisalFactoryInspectionRecyclerAdapter.CustomViewHolder holder, int position) {
        FCDSisalFactoryInspection fcdSisalFactoryInspection = fcdSisalFactoryInspectionList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + fcdSisalFactoryInspection.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + fcdSisalFactoryInspection.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + fcdSisalFactoryInspection.getNameOfApplicant());
        holder.textViewLicenceNumber.setText("Licence Number: " + fcdSisalFactoryInspection.getSisalSpinningExportNumber());
    }

    public SisalFactoryInspectionRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<FCDSisalFactoryInspection> fcdSisalFactoryInspectionList) {
        this.fcdSisalFactoryInspectionList = fcdSisalFactoryInspectionList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != fcdSisalFactoryInspectionList ? fcdSisalFactoryInspectionList.size() : 0);
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
