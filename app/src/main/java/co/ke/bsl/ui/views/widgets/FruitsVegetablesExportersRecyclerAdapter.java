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
import co.ke.bsl.data.model.FruitsVegetablesExportersDeskVetting;
import co.ke.bsl.data.model.TeaPacker;

public class FruitsVegetablesExportersRecyclerAdapter extends RecyclerView.Adapter<FruitsVegetablesExportersRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<FruitsVegetablesExportersDeskVetting> fruitsVegetablesExportersDeskVettingList;

    @NonNull
    @Override
    public FruitsVegetablesExportersRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        FruitsVegetablesExportersRecyclerAdapter.CustomViewHolder viewHolder = new FruitsVegetablesExportersRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitsVegetablesExportersRecyclerAdapter.CustomViewHolder holder, int position) {
        FruitsVegetablesExportersDeskVetting fruitsVegetablesExportersDeskVetting = fruitsVegetablesExportersDeskVettingList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + fruitsVegetablesExportersDeskVetting.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + fruitsVegetablesExportersDeskVetting.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + fruitsVegetablesExportersDeskVetting.getNameOfApplicant());
        holder.textViewLicenceNumber.setText("Licence Number: " + fruitsVegetablesExportersDeskVetting.getExportLicence());
    }

    public FruitsVegetablesExportersRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<FruitsVegetablesExportersDeskVetting> fruitsVegetablesExportersDeskVettingList) {
        this.fruitsVegetablesExportersDeskVettingList = fruitsVegetablesExportersDeskVettingList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != fruitsVegetablesExportersDeskVettingList ? fruitsVegetablesExportersDeskVettingList.size() : 0);
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
