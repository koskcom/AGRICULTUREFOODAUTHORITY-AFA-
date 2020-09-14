package co.ke.bsl.task.async;

import android.app.ListActivity;

//reviewed
public abstract class AbstractAsyncListActivity extends ListActivity implements
		AsyncActivity {
	private AsyncActivitySupport asyncSupport;

	public AbstractAsyncListActivity() {
		super();
		this.asyncSupport = new AsyncActivitySupport(this);
	}

	@Override
	public void showLoadingProgressDialog() {
		asyncSupport.showLoadingProgressDialog();
	}

	@Override
	public void dismissProgressDialog() {
		asyncSupport.dismissProgressDialog();
	}
}
