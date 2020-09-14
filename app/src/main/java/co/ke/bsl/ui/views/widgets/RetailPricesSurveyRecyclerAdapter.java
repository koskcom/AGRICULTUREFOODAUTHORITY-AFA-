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
import co.ke.bsl.data.model.SugarRetailPricesSurvey;

public class RetailPricesSurveyRecyclerAdapter extends RecyclerView.Adapter<RetailPricesSurveyRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<SugarRetailPricesSurvey> sugarRetailPricesSurveyList;

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_sugar_prices_survey_list, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull RetailPricesSurveyRecyclerAdapter.CustomViewHolder holder, int position) {
        SugarRetailPricesSurvey sugarRetailPricesSurvey = sugarRetailPricesSurveyList.get(position);

        holder.textsurveyTye.setText("Survey Type  " + sugarRetailPricesSurvey.getSurveyType());
        holder.textShop.setText("Shop Name  " + sugarRetailPricesSurvey.getShop());
        holder.textSurveyEnding.setText("Survey Ending  " + sugarRetailPricesSurvey.getSurvey_Ending());
        holder.textViewCity.setText("City Name  " + sugarRetailPricesSurvey.getCity());

    }

    public RetailPricesSurveyRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<SugarRetailPricesSurvey> sugarRetailPricesSurveyList) {
        this.sugarRetailPricesSurveyList = sugarRetailPricesSurveyList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (null != sugarRetailPricesSurveyList ? sugarRetailPricesSurveyList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textsurveyTye)
        TextView textsurveyTye;
        @BindView(R.id.textShop)
        TextView textShop;
        @BindView(R.id.textSurveyEnding)
        TextView textSurveyEnding;
        @BindView(R.id.textViewCity)
        TextView textViewCity;


        public CustomViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
