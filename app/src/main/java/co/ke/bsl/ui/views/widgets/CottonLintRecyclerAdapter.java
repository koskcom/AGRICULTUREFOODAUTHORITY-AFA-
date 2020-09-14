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
import co.ke.bsl.data.model.FCDCottonLintClassingReport;
import co.ke.bsl.data.model.FCDCottonLintClassingReport;

public class CottonLintRecyclerAdapter extends RecyclerView.Adapter<CottonLintRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<FCDCottonLintClassingReport> fcdCottonLintClassingReportList;

    @NonNull
    @Override
    public CottonLintRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        CottonLintRecyclerAdapter.CustomViewHolder viewHolder = new CottonLintRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull CottonLintRecyclerAdapter.CustomViewHolder holder, int position) {
        FCDCottonLintClassingReport fcdCottonLintClassingReport = fcdCottonLintClassingReportList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + fcdCottonLintClassingReport.getDocumentNumber());
        holder.textViewDocumentDate.setText("Document Date: " + fcdCottonLintClassingReport.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + fcdCottonLintClassingReport.getNameOfApplicant());
        holder.textViewLicenceNumber.setText("Cotton Lint Licence: " + fcdCottonLintClassingReport.getLintLicence());
    }

    public CottonLintRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<FCDCottonLintClassingReport> fcdCottonLintClassingReportList) {
        this.fcdCottonLintClassingReportList = fcdCottonLintClassingReportList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != fcdCottonLintClassingReportList ? fcdCottonLintClassingReportList.size() : 0);
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
