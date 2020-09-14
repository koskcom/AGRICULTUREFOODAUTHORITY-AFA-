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
import co.ke.bsl.data.model.FCDCottonGinneryInspection;
import co.ke.bsl.data.model.TeaPacker;

public class CottonGinneryRecyclerAdapter extends RecyclerView.Adapter<CottonGinneryRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<FCDCottonGinneryInspection> fcdCottonGinneryInspectionList;

    @NonNull
    @Override
    public CottonGinneryRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        CottonGinneryRecyclerAdapter.CustomViewHolder viewHolder = new CottonGinneryRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull CottonGinneryRecyclerAdapter.CustomViewHolder holder, int position) {
        FCDCottonGinneryInspection fcdCottonGinneryInspection = fcdCottonGinneryInspectionList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + fcdCottonGinneryInspection.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + fcdCottonGinneryInspection.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + fcdCottonGinneryInspection.getNameOfApplicant());
        holder.textViewLicenceNumber.setText("Licence Number: " + fcdCottonGinneryInspection.getGinningLicence());
    }

    public CottonGinneryRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<FCDCottonGinneryInspection> fcdCottonGinneryInspectionList) {
        this.fcdCottonGinneryInspectionList = fcdCottonGinneryInspectionList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != fcdCottonGinneryInspectionList ? fcdCottonGinneryInspectionList.size() : 0);
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
