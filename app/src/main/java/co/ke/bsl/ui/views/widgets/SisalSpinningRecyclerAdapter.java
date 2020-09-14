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
import co.ke.bsl.data.model.FCDSisalSpinningFactoryInspection;


public class SisalSpinningRecyclerAdapter extends RecyclerView.Adapter<SisalSpinningRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<FCDSisalSpinningFactoryInspection> fCDSisalSpinningFactoryInspectionList;

    @NonNull
    @Override
    public SisalSpinningRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        SisalSpinningRecyclerAdapter.CustomViewHolder viewHolder = new SisalSpinningRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull SisalSpinningRecyclerAdapter.CustomViewHolder holder, int position) {
        FCDSisalSpinningFactoryInspection fCDSisalSpinningFactoryInspection = fCDSisalSpinningFactoryInspectionList.get(position);

        holder.textViewDocumentNumber.setText("Document Number:"+ fCDSisalSpinningFactoryInspection.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date:"+fCDSisalSpinningFactoryInspection.getDocumentDate());
        holder.textViewApplicantName.setText( "Applicant Name:"+fCDSisalSpinningFactoryInspection.getNameOfApplicant());
        holder.textViewLicenceNumber.setText("Licence No:"+fCDSisalSpinningFactoryInspection.getSisalSpinningExportNumber());
    }

    public SisalSpinningRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<FCDSisalSpinningFactoryInspection> fCDSisalSpinningFactoryInspectionList) {
        this.fCDSisalSpinningFactoryInspectionList = fCDSisalSpinningFactoryInspectionList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != fCDSisalSpinningFactoryInspectionList ? fCDSisalSpinningFactoryInspectionList.size() : 0);
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
