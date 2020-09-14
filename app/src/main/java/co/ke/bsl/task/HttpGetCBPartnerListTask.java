package co.ke.bsl.task;

import android.content.res.Resources;
import android.os.AsyncTask;

import org.idempiere.webservice.client.base.DataRow;
import org.idempiere.webservice.client.base.Enums;
import org.idempiere.webservice.client.base.Field;
import org.idempiere.webservice.client.base.LoginRequest;
import org.idempiere.webservice.client.net.WebServiceConnection;
import org.idempiere.webservice.client.request.QueryDataRequest;
import org.idempiere.webservice.client.response.WindowTabDataResponse;

import java.util.ArrayList;

import co.ke.bsl.R;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.task.async.AsyncActivity;

// reviewed
public class HttpGetCBPartnerListTask extends AsyncTask<LoginRequest, Void, ArrayList<CBPartner>> {
	private final HttpJsonGetCBPartnerListTaskCaller<CBPartner> caller;
	private final String uri;
	private final int requestCode;
	private boolean errorOccured;

	public HttpGetCBPartnerListTask(HttpJsonGetCBPartnerListTaskCaller<CBPartner> caller,
                                    String uri, int requestCode) {
		super();

		this.caller = caller;
		this.uri = uri;
		this.requestCode = requestCode;
	}

	@Override
	protected void onPreExecute() {
		caller.showLoadingProgressDialog();
	}

	@Override
	protected ArrayList<CBPartner> doInBackground(LoginRequest... params) {
		LoginRequest loginRequest= params[0];

		QueryDataRequest ws = new QueryDataRequest();
		ws.setWebServiceType("QuerySugarMiller");
		ws.setLogin(getLogin());
		//ws.setLimit(3);
		//ws.setOffset(3);

		DataRow data = new DataRow();
		//data.addField("Name", "%%");
		ws.setDataRow(data);

		WebServiceConnection client = getClient();

		ArrayList<CBPartner> countryArrayList =new ArrayList<>();
		CBPartner cbPartner =null;
		try {
			WindowTabDataResponse response = client.sendRequest(ws);

			if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
				System.out.println(response.getErrorMessage());
			} else {
				System.out.println("Total rows: " + response.getTotalRows());
				System.out.println("Num rows: " + response.getNumRows());
				System.out.println("Start row: " + response.getStartRow());
				System.out.println();
				for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
					cbPartner=new CBPartner();
					System.out.println("Row: " + (i + 1));
					for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
						Field field = response.getDataSet().getRow(i).getFields().get(j);
						System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

						if("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
							cbPartner.setC_bpartner_id(field.getStringValue());
						else if("applicant_name".equalsIgnoreCase(field.getColumn()))
							cbPartner.setName(field.getStringValue());
					}
					countryArrayList.add(cbPartner);
					System.out.println();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return countryArrayList;

	}

	@Override
	protected void onPostExecute(ArrayList<CBPartner> list) {
		caller.dismissProgressDialog();

		if (!errorOccured) {
			caller.onHttpGetTaskSucceeded(requestCode, list);
		}
	}

	public interface HttpJsonGetCBPartnerListTaskCaller<T> extends AsyncActivity {
		void onHttpGetTaskSucceeded(int requestCode, ArrayList<T> serverResponse);
	}

	public LoginRequest getLogin() {

		LoginRequest login = new LoginRequest();
		login.setUser("brisk.afa.mobile@gmail.com");
		login.setPass("abc123");
		login.setClientID(1000000);
		login.setRoleID(1000000);
		login.setOrgID(1000000);
		login.setWarehouseID(1000000);
		return login;
	}

	public WebServiceConnection getClient() {
		WebServiceConnection client = new WebServiceConnection();
		client.setAttempts(3);
		client.setTimeout(5000);
		client.setAttemptsTimeout(5000);
		client.setUrl(uri);
		client.setAppName("Java Test WS Client");
		return client;
	}}