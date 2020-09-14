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
import co.ke.bsl.data.model.CoffeePulpingStationPSL;
import co.ke.bsl.data.model.PulpingStationLicenseApplication;

public class CoffeePulpingStationPSLRecyclerAdapter extends RecyclerView.Adapter<CoffeePulpingStationPSLRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<CoffeePulpingStationPSL> coffeePulpingStationPSLList;

    @NonNull
    @Override
    public CoffeePulpingStationPSLRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        CoffeePulpingStationPSLRecyclerAdapter.CustomViewHolder viewHolder = new CoffeePulpingStationPSLRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeePulpingStationPSLRecyclerAdapter.CustomViewHolder holder, int position) {
        CoffeePulpingStationPSL coffeePulpingStationPSL = coffeePulpingStationPSLList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + coffeePulpingStationPSL.getDocument_number());
        holder.textViewDocumentDate.setText("Document Date: " + coffeePulpingStationPSL.getVisited_date());
        holder.textViewApplicantName.setText("Applicant Name: " + coffeePulpingStationPSL.getName_of_applicant());
        holder.textViewLicenceNumber.setText("Licence Number: " + coffeePulpingStationPSL.getLicence_number());
    }

    public CoffeePulpingStationPSLRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<CoffeePulpingStationPSL> coffeePulpingStationPSLList) {
        this.coffeePulpingStationPSLList = coffeePulpingStationPSLList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != coffeePulpingStationPSLList ? coffeePulpingStationPSLList.size() : 0);
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
