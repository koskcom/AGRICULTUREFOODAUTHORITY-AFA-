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
import co.ke.bsl.data.model.FCDCottonBuyingStoreInspection;
import co.ke.bsl.data.model.TeaPacker;

public class CottonBuyingStoreRecyclerAdapter extends RecyclerView.Adapter<CottonBuyingStoreRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<FCDCottonBuyingStoreInspection> fcdCottonBuyingStoreInspectionList;

    @NonNull
    @Override
    public CottonBuyingStoreRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        CottonBuyingStoreRecyclerAdapter.CustomViewHolder viewHolder = new CottonBuyingStoreRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull CottonBuyingStoreRecyclerAdapter.CustomViewHolder holder, int position) {
        FCDCottonBuyingStoreInspection fcdCottonBuyingStoreInspection = fcdCottonBuyingStoreInspectionList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + fcdCottonBuyingStoreInspection.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + fcdCottonBuyingStoreInspection.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + fcdCottonBuyingStoreInspection.getNameOfApplicant());
        holder.textViewLicenceNumber.setText("Licence Number: " + fcdCottonBuyingStoreInspection.getCottonExportNumber());
    }

    public CottonBuyingStoreRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<FCDCottonBuyingStoreInspection> fcdCottonBuyingStoreInspectionList) {
        this.fcdCottonBuyingStoreInspectionList = fcdCottonBuyingStoreInspectionList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != fcdCottonBuyingStoreInspectionList ? fcdCottonBuyingStoreInspectionList.size() : 0);
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
