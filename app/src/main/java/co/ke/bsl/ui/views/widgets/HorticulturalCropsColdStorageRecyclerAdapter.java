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
import co.ke.bsl.data.model.HCDHorticulturalCropsColdStorage;
import co.ke.bsl.data.model.TeaPacker;

public class HorticulturalCropsColdStorageRecyclerAdapter extends RecyclerView.Adapter<HorticulturalCropsColdStorageRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<HCDHorticulturalCropsColdStorage> hcdHorticulturalCropsColdStorageList;

    @NonNull
    @Override
    public HorticulturalCropsColdStorageRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        HorticulturalCropsColdStorageRecyclerAdapter.CustomViewHolder viewHolder = new HorticulturalCropsColdStorageRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull HorticulturalCropsColdStorageRecyclerAdapter.CustomViewHolder holder, int position) {
        HCDHorticulturalCropsColdStorage hcdHorticulturalCropsColdStorage = hcdHorticulturalCropsColdStorageList.get(position);

        holder.textViewDocumentNumber.setText("Applicant name: " + hcdHorticulturalCropsColdStorage.getNameOfApplicant());
        holder.textViewDocumentDate.setText("Product Category: " + hcdHorticulturalCropsColdStorage.getProductsCategory());
        holder.textViewApplicantName.setText("Product: " + hcdHorticulturalCropsColdStorage.getProduct());
        holder.textViewLicenceNumber.setText("Date Brought in: " + hcdHorticulturalCropsColdStorage.getDateBrouught());
    }

    public HorticulturalCropsColdStorageRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<HCDHorticulturalCropsColdStorage> hcdHorticulturalCropsColdStorageList) {
        this.hcdHorticulturalCropsColdStorageList = hcdHorticulturalCropsColdStorageList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != hcdHorticulturalCropsColdStorageList ? hcdHorticulturalCropsColdStorageList.size() : 0);
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
