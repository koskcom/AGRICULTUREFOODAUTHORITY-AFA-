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
import co.ke.bsl.data.model.HCDFlowersConsolidators;
import co.ke.bsl.data.model.TeaPacker;

public class HorticultureFlowerConsolidatorsRecyclerAdapter extends RecyclerView.Adapter<HorticultureFlowerConsolidatorsRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<HCDFlowersConsolidators> hcdFlowersConsolidatorsList;

    @NonNull
    @Override
    public HorticultureFlowerConsolidatorsRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        HorticultureFlowerConsolidatorsRecyclerAdapter.CustomViewHolder viewHolder = new HorticultureFlowerConsolidatorsRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull HorticultureFlowerConsolidatorsRecyclerAdapter.CustomViewHolder holder, int position) {
        HCDFlowersConsolidators hcdFlowersConsolidators = hcdFlowersConsolidatorsList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + hcdFlowersConsolidators.getDocument_number());
        holder.textViewDocumentDate.setText("Document Date: " + hcdFlowersConsolidators.getDocument_date());
        holder.textViewApplicantName.setText("Applicant Name: " + hcdFlowersConsolidators.getName_of_applicant());
        holder.textViewLicenceNumber.setText("Licence Number: " + hcdFlowersConsolidators.getExport_licence());
    }

    public HorticultureFlowerConsolidatorsRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<HCDFlowersConsolidators> hcdFlowersConsolidatorsList) {
        this.hcdFlowersConsolidatorsList = hcdFlowersConsolidatorsList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != hcdFlowersConsolidatorsList ? hcdFlowersConsolidatorsList.size() : 0);
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
