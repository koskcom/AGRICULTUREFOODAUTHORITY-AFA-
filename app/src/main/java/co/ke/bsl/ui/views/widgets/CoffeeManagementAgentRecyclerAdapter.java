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
import co.ke.bsl.data.model.CoffeeManagementAgent;
import co.ke.bsl.data.model.TeaPacker;

public class CoffeeManagementAgentRecyclerAdapter extends RecyclerView.Adapter<CoffeeManagementAgentRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<CoffeeManagementAgent> coffeeManagementAgentList;

    @NonNull
    @Override
    public CoffeeManagementAgentRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        CoffeeManagementAgentRecyclerAdapter.CustomViewHolder viewHolder = new CoffeeManagementAgentRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeManagementAgentRecyclerAdapter.CustomViewHolder holder, int position) {
        CoffeeManagementAgent coffeeManagementAgent = coffeeManagementAgentList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + coffeeManagementAgent.getDocumnet_number());
        holder.textViewDocumentDate.setText("Document Date: " + coffeeManagementAgent.getDocument_date());
        holder.textViewApplicantName.setText("Applicant Name: " + coffeeManagementAgent.getName_of_applicant());
        holder.textViewLicenceNumber.setText("Licence Number: " + coffeeManagementAgent.getLicence_no());
    }

    public CoffeeManagementAgentRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<CoffeeManagementAgent> coffeeManagementAgentList) {
        this.coffeeManagementAgentList = coffeeManagementAgentList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != coffeeManagementAgentList ? coffeeManagementAgentList.size() : 0);
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
