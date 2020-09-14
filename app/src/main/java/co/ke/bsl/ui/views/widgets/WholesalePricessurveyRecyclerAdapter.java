package co.ke.bsl.ui.views.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.R;
import co.ke.bsl.data.DateConverter;
import co.ke.bsl.data.model.SugarWholesalePricesSurvey;

public class WholesalePricessurveyRecyclerAdapter extends RecyclerView.Adapter<WholesalePricessurveyRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<SugarWholesalePricesSurvey> sugarWholesalePricesSurveyList;

    @NonNull
    @Override
    public WholesalePricessurveyRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wholesale_prices_survey_list, null);
        WholesalePricessurveyRecyclerAdapter.CustomViewHolder viewHolder = new WholesalePricessurveyRecyclerAdapter.CustomViewHolder(view);

        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull WholesalePricessurveyRecyclerAdapter.CustomViewHolder holder, int position) {
        SugarWholesalePricesSurvey sugarWholesalePricesSurvey = sugarWholesalePricesSurveyList.get(position);

        Date date = DateConverter.toDate(sugarWholesalePricesSurvey.getSurvey_Ending());

        holder.textsurveyTyeType.setText("Survey Type  " + sugarWholesalePricesSurvey.getSurveyType());
        holder.textShopShop.setText("Shop Name  " + sugarWholesalePricesSurvey.getShop());
        holder.textSurveyEndingDate.setText("Survey Ending  " + sugarWholesalePricesSurvey.getSurvey_Ending());
        holder.textViewCityCity.setText("City Name  " + sugarWholesalePricesSurvey.getCity());

    }

    public WholesalePricessurveyRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<SugarWholesalePricesSurvey> sugarWholesalePricesSurveyList) {
        this.sugarWholesalePricesSurveyList = sugarWholesalePricesSurveyList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (null != sugarWholesalePricesSurveyList ? sugarWholesalePricesSurveyList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textsurveyTyeType)
        TextView textsurveyTyeType;
        @BindView(R.id.textShopShop)
        TextView textShopShop;
        @BindView(R.id.textSurveyEndingDate)
        TextView textSurveyEndingDate;
        @BindView(R.id.textViewCityCity)
        TextView textViewCityCity;


        public CustomViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
