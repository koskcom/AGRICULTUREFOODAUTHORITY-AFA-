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
import co.ke.bsl.data.model.HorticultureProduceTransportation;
import co.ke.bsl.data.model.TeaPacker;

public class HorticulturalProduceTransportationRecyclerAdapter extends RecyclerView.Adapter<HorticulturalProduceTransportationRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<HorticultureProduceTransportation> horticultureProduceTransportationList;

    @NonNull
    @Override
    public HorticulturalProduceTransportationRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        HorticulturalProduceTransportationRecyclerAdapter.CustomViewHolder viewHolder = new HorticulturalProduceTransportationRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull HorticulturalProduceTransportationRecyclerAdapter.CustomViewHolder holder, int position) {
        HorticultureProduceTransportation horticultureProduceTransportation = horticultureProduceTransportationList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + horticultureProduceTransportation.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + horticultureProduceTransportation.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + horticultureProduceTransportation.getNameOfApllicant());
        holder.textViewLicenceNumber.setText("Licence Number: " + horticultureProduceTransportation.getExportLicence());
    }

    public HorticulturalProduceTransportationRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<HorticultureProduceTransportation> horticultureProduceTransportationList) {
        this.horticultureProduceTransportationList = horticultureProduceTransportationList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != horticultureProduceTransportationList ? horticultureProduceTransportationList.size() : 0);
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
