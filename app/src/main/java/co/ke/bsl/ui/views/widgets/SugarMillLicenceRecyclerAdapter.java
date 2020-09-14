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
import co.ke.bsl.data.model.CaneCensus;
import co.ke.bsl.data.model.SugarMillLicence;

public class SugarMillLicenceRecyclerAdapter extends RecyclerView.Adapter<SugarMillLicenceRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<SugarMillLicence> sugarMillLicenceList;

    @NonNull
    @Override
    public SugarMillLicenceRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }


    @Override
    public void onBindViewHolder(@NonNull SugarMillLicenceRecyclerAdapter.CustomViewHolder holder, int position) {
        SugarMillLicence sugarMillLicence = sugarMillLicenceList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + sugarMillLicence.getDocument_number());
        holder.textViewDocumentDate.setText("Document Date: " + sugarMillLicence.getDocument_date());
        holder.textViewApplicantName.setText("Applicant Name: " + sugarMillLicence.getApplicant_name());
        holder.textViewLicenceNumber.setText("Licence Number: " + sugarMillLicence.getLetter_of_comfort());
    }

    public SugarMillLicenceRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<SugarMillLicence> sugarMillLicenceList) {
        this.sugarMillLicenceList = sugarMillLicenceList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (null != sugarMillLicenceList ? sugarMillLicenceList.size() : 0);
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
