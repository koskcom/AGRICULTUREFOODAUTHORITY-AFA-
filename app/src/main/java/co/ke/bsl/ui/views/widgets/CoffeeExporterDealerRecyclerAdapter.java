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
import co.ke.bsl.data.model.CoffeeExporterDealerInspection;

public class CoffeeExporterDealerRecyclerAdapter extends RecyclerView.Adapter<CoffeeExporterDealerRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<CoffeeExporterDealerInspection> coffeeExporterDealerInspectionList;

    @NonNull
    @Override
    public CoffeeExporterDealerRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        CoffeeExporterDealerRecyclerAdapter.CustomViewHolder viewHolder = new CoffeeExporterDealerRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeExporterDealerRecyclerAdapter.CustomViewHolder holder, int position) {
        CoffeeExporterDealerInspection coffeeExporterDealerInspection = coffeeExporterDealerInspectionList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + coffeeExporterDealerInspection.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + coffeeExporterDealerInspection.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + coffeeExporterDealerInspection.getApplicantName());
        holder.textViewLicenceNumber.setText("Licence Number: " + coffeeExporterDealerInspection.getDealerLicenceNumber());
    }

    public CoffeeExporterDealerRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<CoffeeExporterDealerInspection> coffeeExporterDealerInspectionList) {
        this.coffeeExporterDealerInspectionList = coffeeExporterDealerInspectionList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != coffeeExporterDealerInspectionList ? coffeeExporterDealerInspectionList.size() : 0);
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
