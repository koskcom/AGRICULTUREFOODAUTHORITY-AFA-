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
import co.ke.bsl.data.model.TeaPacker;

public class TeaPackerRecyclerAdapter extends RecyclerView.Adapter<TeaPackerRecyclerAdapter.CustomViewHolder> {
    private Context mContext;
    private List<TeaPacker> teaPackerList;

    @NonNull
    @Override
    public TeaPackerRecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tea_packer_list_adapter, null);

        TeaPackerRecyclerAdapter.CustomViewHolder viewHolder = new TeaPackerRecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(@NonNull TeaPackerRecyclerAdapter.CustomViewHolder holder, int position) {
        TeaPacker teaPacker = teaPackerList.get(position);

        holder.textViewDocumentNumber.setText("Document No: " + teaPacker.getDocumentNo());
        holder.textViewDocumentDate.setText("Document Date: " + teaPacker.getDocumentDate());
        holder.textViewApplicantName.setText("Applicant Name: " + teaPacker.getApplicantName());
        holder.textViewLicenceNumber.setText("Licence Number: " + teaPacker.getLicenceNo());
    }

    public TeaPackerRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<TeaPacker> teaPackerList) {
        this.teaPackerList = teaPackerList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return (null != teaPackerList ? teaPackerList.size() : 0);
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
