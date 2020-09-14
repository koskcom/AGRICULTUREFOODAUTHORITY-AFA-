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
import co.ke.bsl.data.model.CoffeeNurseryCert;
import co.ke.bsl.data.model.TeaPacker;

public class CoffeeNurseryRecyclerAdapter extends RecyclerView.Adapter<CoffeeNurseryRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<CoffeeNurseryCert> coffeeNurseryCertList;

    @NonNull
    @Override
    public CoffeeNurseryRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        CoffeeNurseryRecyclerAdapter.CustomViewHolder viewHolder = new CoffeeNurseryRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeNurseryRecyclerAdapter.CustomViewHolder holder, int position) {
        CoffeeNurseryCert coffeeNurseryCert = coffeeNurseryCertList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + coffeeNurseryCert.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + coffeeNurseryCert.getDocumentaDate());
        holder.textViewApplicantName.setText("Applicant Name: " + coffeeNurseryCert.getApplicantName());
        holder.textViewLicenceNumber.setText("Certificate Number: " + coffeeNurseryCert.getCertificateNumber());
    }

    public CoffeeNurseryRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<CoffeeNurseryCert> coffeeNurseryCertList) {
        this.coffeeNurseryCertList = coffeeNurseryCertList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != coffeeNurseryCertList ? coffeeNurseryCertList.size() : 0);
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
