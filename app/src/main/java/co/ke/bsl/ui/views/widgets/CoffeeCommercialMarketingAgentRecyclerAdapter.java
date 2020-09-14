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
import co.ke.bsl.data.model.CoffeeCommercialMarketingAgent;

public class CoffeeCommercialMarketingAgentRecyclerAdapter extends RecyclerView.Adapter<CoffeeCommercialMarketingAgentRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<CoffeeCommercialMarketingAgent> coffeeCommercialMarketingAgentList;

    @NonNull
    @Override
    public CoffeeCommercialMarketingAgentRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        CoffeeCommercialMarketingAgentRecyclerAdapter.CustomViewHolder viewHolder = new CoffeeCommercialMarketingAgentRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeCommercialMarketingAgentRecyclerAdapter.CustomViewHolder holder, int position) {
        CoffeeCommercialMarketingAgent coffeeCommercialMarketingAgent = coffeeCommercialMarketingAgentList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + coffeeCommercialMarketingAgent.getDocument_number());
        holder.textViewDocumentDate.setText("Document Date: " + coffeeCommercialMarketingAgent.getDocument_date());
        holder.textViewApplicantName.setText("Applicant Name: " + coffeeCommercialMarketingAgent.getName_of_applicant());
        holder.textViewLicenceNumber.setText("Licence Number: " + coffeeCommercialMarketingAgent.getLicence_number());
    }

    public CoffeeCommercialMarketingAgentRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<CoffeeCommercialMarketingAgent> coffeeCommercialMarketingAgentList) {
        this.coffeeCommercialMarketingAgentList = coffeeCommercialMarketingAgentList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != coffeeCommercialMarketingAgentList ? coffeeCommercialMarketingAgentList.size() : 0);
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
