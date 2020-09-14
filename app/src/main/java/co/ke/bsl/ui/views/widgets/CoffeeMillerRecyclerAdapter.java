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
import co.ke.bsl.data.model.CoffeeMillerLicenceApplication;
import co.ke.bsl.data.model.TeaPacker;

public class CoffeeMillerRecyclerAdapter extends RecyclerView.Adapter<CoffeeMillerRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<CoffeeMillerLicenceApplication> coffeeMillerLicenceApplicationList;

    @NonNull
    @Override
    public CoffeeMillerRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        CoffeeMillerRecyclerAdapter.CustomViewHolder viewHolder = new CoffeeMillerRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeMillerRecyclerAdapter.CustomViewHolder holder, int position) {
        CoffeeMillerLicenceApplication coffeeMillerLicenceApplication = coffeeMillerLicenceApplicationList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + coffeeMillerLicenceApplication.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + coffeeMillerLicenceApplication.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + coffeeMillerLicenceApplication.getApplicantName());
        holder.textViewLicenceNumber.setText("Licence Number: " + coffeeMillerLicenceApplication.getLicenceNumber());
    }

    public CoffeeMillerRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<CoffeeMillerLicenceApplication> coffeeMillerLicenceApplicationList) {
        this.coffeeMillerLicenceApplicationList = coffeeMillerLicenceApplicationList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != coffeeMillerLicenceApplicationList ? coffeeMillerLicenceApplicationList.size() : 0);
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
