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
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.model.TeaWarehouseManInspection;

public class TeaWarehouseManRecyclerAdapter extends RecyclerView.Adapter<TeaWarehouseManRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<TeaWarehouseManInspection> teaWarehouseManInspectionList;

    @NonNull
    @Override
    public TeaWarehouseManRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        TeaWarehouseManRecyclerAdapter.CustomViewHolder viewHolder = new TeaWarehouseManRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull TeaWarehouseManRecyclerAdapter.CustomViewHolder holder, int position) {
        TeaWarehouseManInspection teaWarehouseManInspection = teaWarehouseManInspectionList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + teaWarehouseManInspection.getDocument_number());
        holder.textViewDocumentDate.setText("Document Date: " + teaWarehouseManInspection.getDocument_date());
        holder.textViewApplicantName.setText("Applicant Name: " + teaWarehouseManInspection.getName_of_applicant());
        holder.textViewLicenceNumber.setText("Licence Number: " + teaWarehouseManInspection.getLicense_number());
    }

    public TeaWarehouseManRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<TeaWarehouseManInspection> teaWarehouseManInspectionList) {
        this.teaWarehouseManInspectionList = teaWarehouseManInspectionList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != teaWarehouseManInspectionList ? teaWarehouseManInspectionList.size() : 0);
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
