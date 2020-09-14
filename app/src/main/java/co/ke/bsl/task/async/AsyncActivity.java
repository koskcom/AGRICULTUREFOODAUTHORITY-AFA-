package co.ke.bsl.task.async;

// reviewed
public interface AsyncActivity {
	void showLoadingProgressDialog();

	void dismissProgressDialog();

	void onAsyncTaskFailed(Class<?> taskClass, int requestCode,
	                       Throwable throwable);
}
