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
import co.ke.bsl.data.model.HorticulturalFlowerExportersDeskVetting;
import co.ke.bsl.data.model.TeaPacker;

public class HorticulturalFlowerExportersRecyclerAdapter extends RecyclerView.Adapter<HorticulturalFlowerExportersRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<HorticulturalFlowerExportersDeskVetting> horticulturalFlowerExportersDeskVettingList;

    @NonNull
    @Override
    public HorticulturalFlowerExportersRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        HorticulturalFlowerExportersRecyclerAdapter.CustomViewHolder viewHolder = new HorticulturalFlowerExportersRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull HorticulturalFlowerExportersRecyclerAdapter.CustomViewHolder holder, int position) {
        HorticulturalFlowerExportersDeskVetting horticulturalFlowerExportersDeskVetting = horticulturalFlowerExportersDeskVettingList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + horticulturalFlowerExportersDeskVetting.getDocument_number());
        holder.textViewDocumentDate.setText("Document Date: " + horticulturalFlowerExportersDeskVetting.getDocument_date());
        holder.textViewApplicantName.setText("Applicant Name: " + horticulturalFlowerExportersDeskVetting.getName_of_applicant());
        holder.textViewLicenceNumber.setText("Licence Number: " + horticulturalFlowerExportersDeskVetting.getExport_licence());
    }

    public HorticulturalFlowerExportersRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<HorticulturalFlowerExportersDeskVetting> horticulturalFlowerExportersDeskVettingList) {
        this.horticulturalFlowerExportersDeskVettingList = horticulturalFlowerExportersDeskVettingList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != horticulturalFlowerExportersDeskVettingList ? horticulturalFlowerExportersDeskVettingList.size() : 0);
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
