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
import co.ke.bsl.data.model.FoodCrop;


public class FoodCropAdapter extends RecyclerView.Adapter<FoodCropAdapter.CustomViewHolder> {
    private Context mContext;
    private List<FoodCrop> foodCropList;

    @NonNull
    @Override
    public FoodCropAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        FoodCropAdapter.CustomViewHolder viewHolder = new FoodCropAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodCropAdapter.CustomViewHolder holder, int position) {
        FoodCrop foodCrop = foodCropList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + foodCrop.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + foodCrop.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + foodCrop.getNameOfApplicant());
        holder.textViewLicenceNumber.setText("Licence Number: " + foodCrop.getFoodCroplicence());
    }

    public FoodCropAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<FoodCrop> foodCropList) {
        this.foodCropList = foodCropList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != foodCropList ? foodCropList.size() : 0);
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
