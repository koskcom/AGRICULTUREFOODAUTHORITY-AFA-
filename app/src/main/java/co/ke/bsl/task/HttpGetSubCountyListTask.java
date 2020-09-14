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
import co.ke.bsl.pojo.CaneCensusFarmer;
import co.ke.bsl.pojo.SubCounty;
import co.ke.bsl.task.async.AsyncActivity;

import static android.provider.Settings.Secure.getString;

// reviewed
public class HttpGetSubCountyListTask extends AsyncTask<CaneCensusFarmer, Void, ArrayList<SubCounty>> {
	private final HttpJsonGetSubCountyListTaskCaller<SubCounty> caller;
	private final String uri;
	private final int requestCode;
	private boolean errorOccured;

	public HttpGetSubCountyListTask(HttpJsonGetSubCountyListTaskCaller<SubCounty> caller,
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
	protected ArrayList<SubCounty> doInBackground(CaneCensusFarmer... params) {
		CaneCensusFarmer caneCensusFarmer=new CaneCensusFarmer();

		 caneCensusFarmer= params[0];


		QueryDataRequest ws = new QueryDataRequest();
		ws.setWebServiceType("QuerySubCounty");
		ws.setLogin(getLogin());
		//ws.setLimit(3);
		//ws.setOffset(3);

		System.out.println(caneCensusFarmer.getCountyID());
		DataRow data = new DataRow();

		data.addField("SPD_County_ID",caneCensusFarmer.getCountyID() );
		ws.setDataRow(data);

		WebServiceConnection client = getClient();

		ArrayList<SubCounty> cityArrayList =new ArrayList<>();
		SubCounty city =null;
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
					city=new SubCounty();
					System.out.println("Row: " + (i + 1));
					for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
						Field field = response.getDataSet().getRow(i).getFields().get(j);
						System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

						if("SPD_County_ID".equalsIgnoreCase(field.getColumn()))
							city.setCountyId(field.getStringValue());
						else if("Name".equalsIgnoreCase(field.getColumn()))
							city.setSubCountyName(field.getStringValue());
						else if("SPD_SubCounty_ID".equalsIgnoreCase(field.getColumn()))
							city.setSubCountyId(field.getStringValue());
					}
					cityArrayList.add(city);
					System.out.println();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cityArrayList;

	}

	@Override
	protected void onPostExecute(ArrayList<SubCounty> list) {
		caller.dismissProgressDialog();

		if (!errorOccured) {
			caller.onHttpGetTaskSucceeded(requestCode, list);
		}
	}

	public interface HttpJsonGetSubCountyListTaskCaller<T> extends AsyncActivity {
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
	}
}