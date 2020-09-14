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
import co.ke.bsl.data.model.CoffeeGrowerMarketingAgent;
import co.ke.bsl.data.model.TeaPacker;

public class CoffeeGrowerMarketingAgentRecyclerAdapter extends RecyclerView.Adapter<CoffeeGrowerMarketingAgentRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<CoffeeGrowerMarketingAgent> coffeeGrowerMarketingAgentList;

    @NonNull
    @Override
    public CoffeeGrowerMarketingAgentRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        CoffeeGrowerMarketingAgentRecyclerAdapter.CustomViewHolder viewHolder = new CoffeeGrowerMarketingAgentRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeGrowerMarketingAgentRecyclerAdapter.CustomViewHolder holder, int position) {
        CoffeeGrowerMarketingAgent coffeeGrowerMarketingAgent = coffeeGrowerMarketingAgentList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + coffeeGrowerMarketingAgent.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + coffeeGrowerMarketingAgent.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + coffeeGrowerMarketingAgent.getApplicantName());
        holder.textViewLicenceNumber.setText("Licence Number: " + coffeeGrowerMarketingAgent.getLicenceNumber());
    }

    public CoffeeGrowerMarketingAgentRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<CoffeeGrowerMarketingAgent> coffeeGrowerMarketingAgentList) {
        this.coffeeGrowerMarketingAgentList = coffeeGrowerMarketingAgentList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != coffeeGrowerMarketingAgentList ? coffeeGrowerMarketingAgentList.size() : 0);
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
