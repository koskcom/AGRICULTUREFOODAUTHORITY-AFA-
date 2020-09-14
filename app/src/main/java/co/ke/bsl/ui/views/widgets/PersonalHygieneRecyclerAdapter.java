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
import co.ke.bsl.data.model.HCDPersonalHygene;
import co.ke.bsl.data.model.TeaPacker;

public class PersonalHygieneRecyclerAdapter extends RecyclerView.Adapter<PersonalHygieneRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<HCDPersonalHygene> hcdPersonalHygeneList;

    @NonNull
    @Override
    public PersonalHygieneRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        PersonalHygieneRecyclerAdapter.CustomViewHolder viewHolder = new PersonalHygieneRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonalHygieneRecyclerAdapter.CustomViewHolder holder, int position) {
        HCDPersonalHygene hcdPersonalHygene = hcdPersonalHygeneList.get(position);

        holder.textViewDocumentNumber.setText("Applicant Name: " + hcdPersonalHygene.getSsnameOfApplicant());
        holder.textViewDocumentDate.setText("Inspectee Name : " + hcdPersonalHygene.getNames());
        holder.textViewApplicantName.setText("Nationional ID: " + hcdPersonalHygene.getNationalId());
        holder.textViewLicenceNumber.setText("Certificate Number: " + hcdPersonalHygene.getMedicalCertNo());
    }

    public PersonalHygieneRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<HCDPersonalHygene> hcdPersonalHygeneList) {
        this.hcdPersonalHygeneList = hcdPersonalHygeneList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != hcdPersonalHygeneList ? hcdPersonalHygeneList.size() : 0);
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
