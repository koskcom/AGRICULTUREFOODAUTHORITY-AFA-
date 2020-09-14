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
import co.ke.bsl.data.model.HorticultureCropExportLicenceFarmInspection;
import co.ke.bsl.data.model.TeaPacker;

public class HorticulturalCropsExportLicenceRecyclerAdapter extends RecyclerView.Adapter<HorticulturalCropsExportLicenceRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<HorticultureCropExportLicenceFarmInspection> horticultureCropExportLicenceFarmInspectionList;

    @NonNull
    @Override
    public HorticulturalCropsExportLicenceRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        HorticulturalCropsExportLicenceRecyclerAdapter.CustomViewHolder viewHolder = new HorticulturalCropsExportLicenceRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull HorticulturalCropsExportLicenceRecyclerAdapter.CustomViewHolder holder, int position) {
        HorticultureCropExportLicenceFarmInspection horticultureCropExportLicenceFarmInspection = horticultureCropExportLicenceFarmInspectionList.get(position);

        holder.textViewDocumentNumber.setText("Applicant name: " + horticultureCropExportLicenceFarmInspection.getNameOfApplicant());
        holder.textViewDocumentDate.setText("County: " + horticultureCropExportLicenceFarmInspection.getCountyId());
        holder.textViewApplicantName.setText("Sub County: " + horticultureCropExportLicenceFarmInspection.getSubCountyId());
        holder.textViewLicenceNumber.setText("Location: " + horticultureCropExportLicenceFarmInspection.getLocation());
    }

    public HorticulturalCropsExportLicenceRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<HorticultureCropExportLicenceFarmInspection> horticultureCropExportLicenceFarmInspectionList) {
        this.horticultureCropExportLicenceFarmInspectionList = horticultureCropExportLicenceFarmInspectionList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != horticultureCropExportLicenceFarmInspectionList ? horticultureCropExportLicenceFarmInspectionList.size() : 0);
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
