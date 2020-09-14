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
import co.ke.bsl.data.model.PulpingStationLicenseApplication;
import co.ke.bsl.data.model.TeaPacker;

public class CoffeePulpingStationATERecyclerAdapter extends RecyclerView.Adapter<CoffeePulpingStationATERecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<PulpingStationLicenseApplication> pulpingStationLicenseApplicationList;

    @NonNull
    @Override
    public CoffeePulpingStationATERecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        CoffeePulpingStationATERecyclerAdapter.CustomViewHolder viewHolder = new CoffeePulpingStationATERecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeePulpingStationATERecyclerAdapter.CustomViewHolder holder, int position) {
        PulpingStationLicenseApplication pulpingStationLicenseApplication = pulpingStationLicenseApplicationList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + pulpingStationLicenseApplication.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + pulpingStationLicenseApplication.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + pulpingStationLicenseApplication.getApplicantName());
        holder.textViewLicenceNumber.setText("Licence Number: " + pulpingStationLicenseApplication.getAuthorityToErectNumber());
    }

    public CoffeePulpingStationATERecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<PulpingStationLicenseApplication> pulpingStationLicenseApplicationList) {
        this.pulpingStationLicenseApplicationList = pulpingStationLicenseApplicationList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != pulpingStationLicenseApplicationList ? pulpingStationLicenseApplicationList.size() : 0);
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
