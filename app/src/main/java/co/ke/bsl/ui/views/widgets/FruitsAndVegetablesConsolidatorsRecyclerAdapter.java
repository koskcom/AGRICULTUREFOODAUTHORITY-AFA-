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
import co.ke.bsl.data.model.FruitVegetableConsolidators;
import co.ke.bsl.data.model.TeaPacker;

public class FruitsAndVegetablesConsolidatorsRecyclerAdapter extends RecyclerView.Adapter<FruitsAndVegetablesConsolidatorsRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<FruitVegetableConsolidators> fruitVegetableConsolidatorsList;

    @NonNull
    @Override
    public FruitsAndVegetablesConsolidatorsRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        FruitsAndVegetablesConsolidatorsRecyclerAdapter.CustomViewHolder viewHolder = new FruitsAndVegetablesConsolidatorsRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitsAndVegetablesConsolidatorsRecyclerAdapter.CustomViewHolder holder, int position) {
        FruitVegetableConsolidators fruitVegetableConsolidators = fruitVegetableConsolidatorsList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + fruitVegetableConsolidators.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + fruitVegetableConsolidators.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + fruitVegetableConsolidators.getNameOfApplicant());
        holder.textViewLicenceNumber.setText("Licence Number: " + fruitVegetableConsolidators.getExportLicence());
    }

    public FruitsAndVegetablesConsolidatorsRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<FruitVegetableConsolidators> fruitVegetableConsolidatorsList) {
        this.fruitVegetableConsolidatorsList = fruitVegetableConsolidatorsList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != fruitVegetableConsolidatorsList ? fruitVegetableConsolidatorsList.size() : 0);
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
