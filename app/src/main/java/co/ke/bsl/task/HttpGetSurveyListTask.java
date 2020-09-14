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
import co.ke.bsl.pojo.LoginService;
import co.ke.bsl.pojo.Survey;
import co.ke.bsl.task.async.AsyncActivity;


// reviewed
public class HttpGetSurveyListTask extends AsyncTask<LoginService, Void, ArrayList<Survey>> {
	private final HttpJsonGetSurveyListTaskCaller<Survey> caller;
	private final String uri;
	private final int requestCode;
	private boolean errorOccured;

	public HttpGetSurveyListTask(HttpJsonGetSurveyListTaskCaller<Survey> caller,
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
	protected ArrayList<Survey> doInBackground(LoginService... params) {
		LoginService loginService= params[0];
		LoginRequest loginRequest =loginService.getLoginRequest();



		QueryDataRequest ws = new QueryDataRequest();
		ws.setWebServiceType("QuerySurvey");
		ws.setLogin(getLogin());

		DataRow data = new DataRow();
		data.addField("C_City_ID", loginService.getC_City_ID());
		data.addField("typeofsugarpricessurvey", loginService.getTypeOfSugarPricesSurvey());

		ws.setDataRow(data);

		WebServiceConnection client = getClient();

		ArrayList<Survey> surveyArrayList =new ArrayList<>();
		Survey survey =null;
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
					survey=new Survey();
					System.out.println("Row: " + (i + 1));
					for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
						Field field = response.getDataSet().getRow(i).getFields().get(j);
						System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

						if("AFA_SD_Sugarprices_Survey_ID".equalsIgnoreCase(field.getColumn()))
							survey.setAfa_sd_sugarprices_survey_id(field.getStringValue());
						else if("documentdate".equalsIgnoreCase(field.getColumn()))
							survey.setDocumentDate(field.getStringValue());
						else if("DocumentNo".equalsIgnoreCase(field.getColumn()))
							survey.setDocumentNo(field.getStringValue());
						else if("surveyending".equalsIgnoreCase(field.getColumn()))
							survey.setSurveyEndDate(field.getStringValue());

					}
					surveyArrayList.add(survey);
					System.out.println();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return surveyArrayList;

	}

	@Override
	protected void onPostExecute(ArrayList<Survey> list) {
		caller.dismissProgressDialog();

		if (!errorOccured) {
			caller.onHttpGetTaskSucceeded(requestCode, list);
		}
	}

	public interface HttpJsonGetSurveyListTaskCaller<T> extends AsyncActivity {
		void onHttpGetTaskSucceeded(int requestCode, ArrayList<T> serverResponse);
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
	
}