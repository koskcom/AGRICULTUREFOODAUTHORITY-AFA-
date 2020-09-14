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
import co.ke.bsl.data.model.FoodWarehouse;

public class FoodWareHouseAdapter extends RecyclerView.Adapter<FoodWareHouseAdapter.CustomViewHolder> {
    private Context mContext;
    private List<FoodWarehouse> foodWarehouseList;

    @NonNull
    @Override
    public FoodWareHouseAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        FoodWareHouseAdapter.CustomViewHolder viewHolder = new FoodWareHouseAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodWareHouseAdapter.CustomViewHolder holder, int position) {
        FoodWarehouse foodWarehouse = foodWarehouseList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + foodWarehouse.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + foodWarehouse.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + foodWarehouse.getNameOfApplicant());
        holder.textViewLicenceNumber.setText("Licence Number: " + foodWarehouse.getFoodWarehouselicence());
    }

    public FoodWareHouseAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<FoodWarehouse> foodWarehouseList) {
        this.foodWarehouseList = foodWarehouseList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != foodWarehouseList ? foodWarehouseList.size() : 0);
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
