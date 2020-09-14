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
import co.ke.bsl.data.model.HCDNurseryInspection;
import co.ke.bsl.data.model.TeaPacker;

public class HorticultureNurseryRecyclerAdapter extends RecyclerView.Adapter<HorticultureNurseryRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<HCDNurseryInspection> hcdNurseryInspectionList;

    @NonNull
    @Override
    public HorticultureNurseryRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        HorticultureNurseryRecyclerAdapter.CustomViewHolder viewHolder = new HorticultureNurseryRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull HorticultureNurseryRecyclerAdapter.CustomViewHolder holder, int position) {
        HCDNurseryInspection hcdNurseryInspection = hcdNurseryInspectionList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + hcdNurseryInspection.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + hcdNurseryInspection.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + hcdNurseryInspection.getNameOfApplicant());
        holder.textViewLicenceNumber.setText("Licence Number: " + hcdNurseryInspection.getNurseryLicence());
    }

    public HorticultureNurseryRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<HCDNurseryInspection> hcdNurseryInspectionList) {
        this.hcdNurseryInspectionList = hcdNurseryInspectionList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != hcdNurseryInspectionList ? hcdNurseryInspectionList.size() : 0);
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
