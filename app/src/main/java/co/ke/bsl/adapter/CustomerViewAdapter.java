package co.ke.bsl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import co.ke.bsl.R;
import co.ke.bsl.pojo.Customer;

// reviewed
public class CustomerViewAdapter extends BaseAdapter {
	private final LayoutInflater inflater;
	private final Context context;
	private final List<? extends Customer> customers;

	public CustomerViewAdapter(Context context, List<? extends Customer> customers) {
		super();

		this.context = context;
		this.customers = customers;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return customers.size();
	}

	@Override
	public Customer getItem(int position) {
		return customers.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = inflater.inflate(
					R.layout.customerlist_view_tablelayout, null);

			holder = getViewHolder(convertView);
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		customizeView(position, holder);

		return convertView;
	}
	// Toast
		public void toast(String message) {
			Toast.makeText(context, message, Toast.LENGTH_LONG).show();
		}
	/**
	 * Should be overwritten by <code>CustomerLineItemViewAdapter</code>.
	 */
	protected void customizeView(int position, ViewHolder holder) {
		Customer group = customers.get(position);
		customizeView(group, holder);
	}

	/**
	 * Should be called by <code>CustomerLineItemViewAdapter</code>, which should
	 * also call <code>customizeQuantityTextView(..)</code> from here.
	 */
	protected <T extends Customer> void customizeView(T group, ViewHolder holder) {
	

		holder.getNameView().setText(group.getFirstName()+" "+group.getLastName());

		String groupName = "ID NO:"+group.getIdNo() +" Mobile No: "+group.getMsisdn();
		holder.getIngredientsView().setText(groupName);
		//holder.getDownloadButton().setText("Download "+group.getCustomerName());
	}

	/**
	 * Should be overwritten by <code>CustomerLineItemViewAdapter</code>.
	 */
	protected void customizeQuantityTextView(TextView quantityView, String text) {
		quantityView.setText(text);
		quantityView.setWidth(0);
	}

	/**
	 * Should be overwritten by <code>GroupLineItemViewAdapter</code>.
	 */
	protected void customizeRemoveImage(ImageView removeImage) {
		removeImage.setMaxWidth(0);
		removeImage.setVisibility(View.INVISIBLE);
	}

	private ViewHolder getViewHolder(View view) {

		TextView nameView = (TextView) view.findViewById(R.id.groupsList_name);
		
		TextView ingredientsView = (TextView) view
				.findViewById(R.id.groupsList_ingredients);
		
	

		ViewHolder holder = new ViewHolder(nameView,  ingredientsView);

		return holder;
	}

	protected static class ViewHolder {
	
		private TextView nameView;
	
		private TextView ingredientsView;
		
		//private Button downloadButton;

		public ViewHolder(TextView nameView,
				
				TextView ingredientsView) {
			super();
			
			this.nameView = nameView;
			
			this.ingredientsView = ingredientsView;
			//this.downloadButton=downloadButton;
		}

		

		public TextView getNameView() {
			return nameView;
		}

		

		public TextView getIngredientsView() {
			return ingredientsView;
		}


	}
}
