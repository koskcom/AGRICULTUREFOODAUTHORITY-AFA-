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
import co.ke.bsl.data.model.HCDColdRoomTemperatures;
import co.ke.bsl.data.model.TeaPacker;

public class ColdRoomTemperatureRecyclerAdapter extends RecyclerView.Adapter<ColdRoomTemperatureRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<HCDColdRoomTemperatures> hcdColdRoomTemperaturesList;

    @NonNull
    @Override
    public ColdRoomTemperatureRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        ColdRoomTemperatureRecyclerAdapter.CustomViewHolder viewHolder = new ColdRoomTemperatureRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull ColdRoomTemperatureRecyclerAdapter.CustomViewHolder holder, int position) {
        HCDColdRoomTemperatures hcdColdRoomTemperatures = hcdColdRoomTemperaturesList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + hcdColdRoomTemperatures.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + hcdColdRoomTemperatures.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + hcdColdRoomTemperatures.getNameOfApplicant());
        holder.textViewLicenceNumber.setText("Cold Room Number: " + hcdColdRoomTemperatures.getColdRoom());
    }

    public ColdRoomTemperatureRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<HCDColdRoomTemperatures> hcdColdRoomTemperaturesList) {
        this.hcdColdRoomTemperaturesList = hcdColdRoomTemperaturesList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != hcdColdRoomTemperaturesList ? hcdColdRoomTemperaturesList.size() : 0);
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
