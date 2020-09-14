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
import co.ke.bsl.data.model.NOCDMarketPriceSurvey;
import co.ke.bsl.data.model.TeaPacker;

public class NutsAndOilsSurveyRecyclerAdapter extends RecyclerView.Adapter<NutsAndOilsSurveyRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<NOCDMarketPriceSurvey> nocdMarketPriceSurveyList;

    @NonNull
    @Override
    public NutsAndOilsSurveyRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        NutsAndOilsSurveyRecyclerAdapter.CustomViewHolder viewHolder = new NutsAndOilsSurveyRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull NutsAndOilsSurveyRecyclerAdapter.CustomViewHolder holder, int position) {
        NOCDMarketPriceSurvey nocdMarketPriceSurvey = nocdMarketPriceSurveyList.get(position);

        holder.textViewDocumentNumber.setText("County: " + nocdMarketPriceSurvey.getCountyID());
        holder.textViewDocumentDate.setText("Brand name: " + nocdMarketPriceSurvey.getBrandName());
        holder.textViewApplicantName.setText("Price: " + nocdMarketPriceSurvey.getPrice());
        holder.textViewLicenceNumber.setText("Market Outlet: " + nocdMarketPriceSurvey.getMarketOutlet());
    }

    public NutsAndOilsSurveyRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<NOCDMarketPriceSurvey> nocdMarketPriceSurveyList) {
        this.nocdMarketPriceSurveyList = nocdMarketPriceSurveyList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != nocdMarketPriceSurveyList ? nocdMarketPriceSurveyList.size() : 0);
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
