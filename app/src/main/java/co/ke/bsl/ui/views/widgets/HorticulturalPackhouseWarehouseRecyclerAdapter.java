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
import co.ke.bsl.data.model.HCDParkhouseWarehouse;
import co.ke.bsl.data.model.TeaPacker;

public class HorticulturalPackhouseWarehouseRecyclerAdapter extends RecyclerView.Adapter<HorticulturalPackhouseWarehouseRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<HCDParkhouseWarehouse> hcdParkhouseWarehouseList;

    @NonNull
    @Override
    public HorticulturalPackhouseWarehouseRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        HorticulturalPackhouseWarehouseRecyclerAdapter.CustomViewHolder viewHolder = new HorticulturalPackhouseWarehouseRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull HorticulturalPackhouseWarehouseRecyclerAdapter.CustomViewHolder holder, int position) {
        HCDParkhouseWarehouse hcdParkhouseWarehouse = hcdParkhouseWarehouseList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + hcdParkhouseWarehouse.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + hcdParkhouseWarehouse.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + hcdParkhouseWarehouse.getNameOfApplicant());
        holder.textViewLicenceNumber.setText("Licence Number: " + hcdParkhouseWarehouse.getLicenceNumber());
    }

    public HorticulturalPackhouseWarehouseRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<HCDParkhouseWarehouse> hcdParkhouseWarehouseList) {
        this.hcdParkhouseWarehouseList = hcdParkhouseWarehouseList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != hcdParkhouseWarehouseList ? hcdParkhouseWarehouseList.size() : 0);
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
