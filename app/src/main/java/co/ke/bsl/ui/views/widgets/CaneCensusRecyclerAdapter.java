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

public class CaneCensusRecyclerAdapter extends RecyclerView.Adapter<CaneCensusRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<CaneCensus> caneCensusList;

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cane_census_list, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull CaneCensusRecyclerAdapter.CustomViewHolder holder, int position) {
        CaneCensus caneCensus = caneCensusList.get(position);

        holder.textViewFarmerNames.setText(caneCensus.getFarmerFullNames());
        holder.textViewHectares.setText(caneCensus.getCropHecterage() + " Ha");
        holder.textViewSugarCompany.setText(caneCensus.getFarmerCounty());
        holder.textViewCropType.setText(caneCensus.getCropClass() + " - " + caneCensus.getCropVariety());
    }

    public CaneCensusRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<CaneCensus> caneCensusList) {
        this.caneCensusList = caneCensusList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != caneCensusList ? caneCensusList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textViewFarmerNames)
        TextView textViewFarmerNames;
        @BindView(R.id.textViewHectares)
        TextView textViewHectares;
        @BindView(R.id.textViewSugarCompany)
        TextView textViewSugarCompany;
        @BindView(R.id.textViewCropType)
        TextView textViewCropType;

        public CustomViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
