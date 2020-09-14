package co.ke.bsl.ui.views.adapters;

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
import co.ke.bsl.data.model.FoodProcessing;

public class FoodProcessingAdapterList extends RecyclerView.Adapter<FoodProcessingAdapterList.CustomViewHolder> {
    private Context mContext;
    private List<FoodProcessing> foodProcessingList;

    @NonNull
    @Override
    public FoodProcessingAdapterList.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        FoodProcessingAdapterList.CustomViewHolder viewHolder = new FoodProcessingAdapterList.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodProcessingAdapterList.CustomViewHolder holder, int position) {
        FoodProcessing FoodProcessing = foodProcessingList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + FoodProcessing.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + FoodProcessing.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + FoodProcessing.getNameOfApplicant());
        holder.textViewLicenceNumber.setText("Licence Number: " + FoodProcessing.getFoodCropManufacturingPlanApproval());
    }

    public FoodProcessingAdapterList(Context context) {
        this.mContext = context;
    }

    public void setItems(List<FoodProcessing> foodProcessingList) {
        this.foodProcessingList = foodProcessingList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != foodProcessingList ? foodProcessingList.size() : 0);
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
