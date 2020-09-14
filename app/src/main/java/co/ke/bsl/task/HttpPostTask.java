package co.ke.bsl.task;

import android.os.AsyncTask;

import org.idempiere.webservice.client.base.DataRow;
import org.idempiere.webservice.client.base.Enums;
import org.idempiere.webservice.client.net.WebServiceConnection;
import org.idempiere.webservice.client.request.CreateDataRequest;
import org.idempiere.webservice.client.response.StandardResponse;
import org.springframework.http.MediaType;

import co.ke.bsl.pojo.CaneCensusCropDetails;
import co.ke.bsl.pojo.CaneCensusDataCollection;
import co.ke.bsl.pojo.CaneCensusFarmer;
import co.ke.bsl.pojo.RetailLooseSugarPricesRangeImported;
import co.ke.bsl.pojo.RetailLooseSugarPricesRangeLocal;
import co.ke.bsl.pojo.RetailStockedSugarPricesRangeImported;
import co.ke.bsl.pojo.RetailStockedSugarPricesRangeLocal;
import co.ke.bsl.pojo.RetailSugarPricesRangeLocal;
import co.ke.bsl.pojo.Shop;
import co.ke.bsl.pojo.WholeSaleBrandLocal;
import co.ke.bsl.pojo.WholeSaleImportedStockedSugar;
import co.ke.bsl.pojo.WholeSaleImportedSugar;
import co.ke.bsl.pojo.WholeSaleStockedBrandLocal;
import co.ke.bsl.task.async.AsyncActivity;

// reviewed
public class HttpPostTask<T> extends AsyncTask<MediaType, Void, StandardResponse> {
	private final HttpJsonPostTaskCaller caller;
	private final T objectToPost;
	private final String uri;
	private final int requestCode;
	boolean errorOccured;

	public HttpPostTask(HttpJsonPostTaskCaller caller, T objectToBePosted,
						String uri, int requestCode) {
		super();

		this.caller = caller;
		this.objectToPost = objectToBePosted;
		this.uri = uri;
		this.requestCode = requestCode;
	}

	@Override
	protected void onPreExecute() {
		caller.showLoadingProgressDialog();
	}

	@Override
	protected StandardResponse doInBackground(MediaType... params) {
		StandardResponse response = null;
		CreateDataRequest createData = new CreateDataRequest();
		DataRow data = new DataRow();
		Shop shop = new Shop();

		RetailSugarPricesRangeLocal retailSugarPricesRangeLocal=new RetailSugarPricesRangeLocal();

		RetailLooseSugarPricesRangeLocal retailLooseSugarPricesRangeLocal=new RetailLooseSugarPricesRangeLocal();

		RetailLooseSugarPricesRangeImported retailLooseSugarPricesRangeImported =new RetailLooseSugarPricesRangeImported();

		RetailStockedSugarPricesRangeLocal retailStockedSugarPricesRangeLocal=new RetailStockedSugarPricesRangeLocal();

		RetailStockedSugarPricesRangeImported retailStockedSugarPricesRangeImported =new RetailStockedSugarPricesRangeImported();

        WholeSaleBrandLocal wholeSaleBrandLocal =new WholeSaleBrandLocal();

        WholeSaleImportedSugar wholeSaleImportedSugar=new WholeSaleImportedSugar();

        WholeSaleStockedBrandLocal wholeSaleStockedBrandLocal =new WholeSaleStockedBrandLocal();

        WholeSaleImportedStockedSugar wholeSaleImportedStockedSugar=new WholeSaleImportedStockedSugar();

		CaneCensusDataCollection censusDataCollection =new CaneCensusDataCollection();

		CaneCensusFarmer caneCensusFarmer =new CaneCensusFarmer();
		CaneCensusCropDetails caneCensusCropDetails=new CaneCensusCropDetails();




		boolean instanceOfRetailLooseSugarPricesRangeLocal = retailLooseSugarPricesRangeLocal.getClass().isInstance(objectToPost);

		boolean instance = shop.getClass().isInstance(objectToPost);

		boolean instanceOfRetailLooseSugarPricesRangeImported = retailLooseSugarPricesRangeImported.getClass().isInstance(objectToPost);

		boolean instanceOfRetailSugarPricesRangeLocal = retailSugarPricesRangeLocal.getClass().isInstance(objectToPost);

		boolean instanceOfRetailStockedSugarPricesRangeLocal = retailStockedSugarPricesRangeLocal.getClass().isInstance(objectToPost);

		boolean instanceOfretailStockedSugarPricesRangeImported=retailStockedSugarPricesRangeImported.getClass().isInstance(objectToPost);

        boolean instanceOfWholeSaleBrandLocal=wholeSaleBrandLocal.getClass().isInstance(objectToPost);

        boolean instanceOfWholeSaleImportedSugar=wholeSaleImportedSugar.getClass().isInstance(objectToPost);

        boolean instanceOfWholeSaleStockedBrandLocal=wholeSaleStockedBrandLocal.getClass().isInstance(objectToPost);

        boolean instanceOfWholeSaleImportedStockedSugar=wholeSaleImportedStockedSugar.getClass().isInstance(objectToPost);

        boolean instanceOfCensusDataCollection=censusDataCollection.getClass().isInstance(objectToPost);

        boolean instanceOfCaneCensusFarmer= caneCensusFarmer.getClass().isInstance(objectToPost);

        boolean instanceOfCaneCensusCropDetails=caneCensusCropDetails.getClass().isInstance(objectToPost);



        if(instance ){
			shop=(Shop)objectToPost;


			createData.setLogin(shop.getLoginRequest());
			createData.setWebServiceType(shop.getServiceType());


			data.addField("wholesale_shop", shop.getName());
			data.addField("longitude", shop.getLongitude());
			data.addField("latitude", shop.getLatitude());
			//data.addField("AD_User_ID","@AD_User_ID@" );
			data.addField("AFA_SD_Sugarprices_Survey_ID", shop.getAfa_sd_sugarprices_survey_id());
			createData.setDataRow(data);

			WebServiceConnection client = getClient();

			try {
				response = client.sendRequest(createData);

				if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
					System.out.println(response.getErrorMessage());
				} else {

					System.out.println("RecordID: " + response.getRecordID());
					System.out.println();

					for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
						System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
					}
					System.out.println();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if(instanceOfCensusDataCollection ){
			censusDataCollection=(CaneCensusDataCollection)objectToPost;


			createData.setLogin(censusDataCollection.getLoginRequest());
			createData.setWebServiceType(censusDataCollection.getServiceType());

            System.out.println("sugar_company: " + censusDataCollection.getCompanyName());
            System.out.println("sugar_company: " + censusDataCollection.getLongitude());
            System.out.println("sugar_company: " + censusDataCollection.getLatitude());
            System.out.println("sugar_company: " + censusDataCollection.getCountyID());


			data.addField("SPD_County_ID", censusDataCollection.getCountyID());
			data.addField("longitude", censusDataCollection.getLongitude());
			data.addField("latitude", censusDataCollection.getLatitude());
			//data.addField("AD_User_ID","@AD_User_ID@" );
			data.addField("C_BPartner_ID", censusDataCollection.getCompanyName());
			createData.setDataRow(data);

			WebServiceConnection client = getClient();

			try {
				response = client.sendRequest(createData);

				if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
					System.out.println(response.getErrorMessage());
				} else {

					System.out.println("RecordID: " + response.getRecordID());
					System.out.println();

					for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
						System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
					}
					System.out.println();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}


		if(instanceOfCaneCensusCropDetails ){
			caneCensusCropDetails=(CaneCensusCropDetails) objectToPost;


			createData.setLogin(caneCensusCropDetails.getLoginRequest());
			createData.setWebServiceType(caneCensusCropDetails.getServiceType());

			System.out.println("getCropColour: " + caneCensusCropDetails.getCropColour());
			System.out.println("getCropClass: " + caneCensusCropDetails.getCropClass());
			System.out.println("getVariety: " + caneCensusCropDetails.getVariety());




			data.addField("crop_class", caneCensusCropDetails.getCropClass());
			data.addField("crop_color", Integer.parseInt(caneCensusCropDetails.getCropColour()));
			data.addField("no_of_hectares", caneCensusCropDetails.getHectares());
			data.addField("age_months", caneCensusCropDetails.getaGEmonths());
			data.addField("expected_tch", caneCensusCropDetails.getExpectedTCH());

			data.addField("crop_vigour", caneCensusCropDetails.getCropVigour());
			data.addField("crop_density", caneCensusCropDetails.getCropDensity());
			data.addField("pest_disease_weeds", caneCensusCropDetails.getPestsDiseaseWeeds());
			data.addField("AFA_SD_Canefarmerdetails_ID", caneCensusCropDetails.getAFA_SD_Canefarmerdetails_ID());
			data.addField("M_Product_ID", caneCensusCropDetails.getVariety());
			createData.setDataRow(data);

			WebServiceConnection client = getClient();

			try {
				response = client.sendRequest(createData);

				if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
					System.out.println(response.getErrorMessage());
				} else {

					System.out.println("RecordID: " + response.getRecordID());
					System.out.println();

					for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
						System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
					}
					System.out.println();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}


		if(instanceOfCaneCensusFarmer ){
			caneCensusFarmer=(CaneCensusFarmer) objectToPost;


			createData.setLogin(caneCensusFarmer.getLoginRequest());
			createData.setWebServiceType(caneCensusFarmer.getServiceType());

			System.out.println("getAFA_HC_Produce_Trans_Insp_ID: " + caneCensusFarmer.getAFA_SD_Canecensusscore_ID());
			System.out.println("setCountyID: " + caneCensusFarmer.getCountyID());
			System.out.println("getSubCountyID: " + caneCensusFarmer.getSubCountyID());
			System.out.println("getFarmerName: " + caneCensusFarmer.getFarmerName());
			System.out.println("getFarmerPhoneNo: " + caneCensusFarmer.getFarmerPhoneNo());




			data.addField("SPD_County_ID", caneCensusFarmer.getCountyID());
			data.addField("famername", caneCensusFarmer.getFarmerName());
			data.addField("farmerphoneno", caneCensusFarmer.getFarmerPhoneNo());
			//data.addField("AD_User_ID","@AD_User_ID@" );
			data.addField("SPD_SubCounty_ID", caneCensusFarmer.getSubCountyID());
			data.addField("AFA_SD_Canecensusscore_ID", caneCensusFarmer.getAFA_SD_Canecensusscore_ID());
			//data.addField("SPD_SubCounty_ID_Sub-County", censusDataCollection.getCompanyName());
			createData.setDataRow(data);

			WebServiceConnection client = getClient();

			try {
				response = client.sendRequest(createData);

				if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
					System.out.println(response.getErrorMessage());
				} else {

					System.out.println("RecordID: " + response.getRecordID());
					System.out.println();

					for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
						System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
					}
					System.out.println();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if(instanceOfRetailLooseSugarPricesRangeLocal){
		     retailLooseSugarPricesRangeLocal=(RetailLooseSugarPricesRangeLocal)objectToPost;


			createData.setLogin(retailLooseSugarPricesRangeLocal.getLoginRequest());
			createData.setWebServiceType(retailLooseSugarPricesRangeLocal.getServiceType());


			data.addField("lssugarlocal_2kg", retailLooseSugarPricesRangeLocal.getLooseSugarLocal2kg());
			data.addField("lssugarlocal_1kg", retailLooseSugarPricesRangeLocal.getLooseSugarLocal1kg());
			data.addField("lssugarlocal_brand_own", retailLooseSugarPricesRangeLocal.getBrand());
			//data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
			data.addField("AFA_SD_SGR_Surveyshops_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
			createData.setDataRow(data);

			WebServiceConnection client = getClient();

			try {
				response = client.sendRequest(createData);

				if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
					System.out.println(response.getErrorMessage());
				} else {

					System.out.println("RecordID: " + response.getRecordID());
					System.out.println();

					for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
						System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
					}
					System.out.println();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if(instanceOfRetailLooseSugarPricesRangeImported){
		retailLooseSugarPricesRangeImported=(RetailLooseSugarPricesRangeImported)objectToPost;


			createData.setLogin(retailLooseSugarPricesRangeImported.getLoginRequest());
			createData.setWebServiceType(retailLooseSugarPricesRangeImported.getServiceType());


			data.addField("lssugarimported_2kg", retailLooseSugarPricesRangeImported.getLooseSugarLocal2kg());
			data.addField("lssugarimported_1kg", retailLooseSugarPricesRangeImported.getLooseSugarLocal1kg());
			data.addField("lssugarimported_cntryoforigin", retailLooseSugarPricesRangeImported.getCountryID());
			//data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
			data.addField("AFA_SD_SGR_Surveyshops_ID",retailLooseSugarPricesRangeImported.getAFA_SD_SGR_Surveyshops_ID());
			createData.setDataRow(data);

			WebServiceConnection client = getClient();

			try {
				response = client.sendRequest(createData);

				if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
					System.out.println(response.getErrorMessage());
				} else {

					System.out.println("RecordID: " + response.getRecordID());
					System.out.println();

					for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
						System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
					}
					System.out.println();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}


		if(instanceOfRetailSugarPricesRangeLocal){
			retailSugarPricesRangeLocal=(RetailSugarPricesRangeLocal)objectToPost;


			createData.setLogin(retailSugarPricesRangeLocal.getLoginRequest());
			createData.setWebServiceType(retailSugarPricesRangeLocal.getServiceType());



			data.addField("localbrandedsugar_2kg", retailSugarPricesRangeLocal.getLooseSugarLocal2kg());
			data.addField("localbrandedsugar_1kg", retailSugarPricesRangeLocal.getLooseSugarLocal1kg());
			data.addField("localbrandedsugar_brand_own", retailSugarPricesRangeLocal.getBrand());
			//data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
			//data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
			data.addField("AFA_SD_SGR_Surveyshops_ID",retailSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
			createData.setDataRow(data);

			WebServiceConnection client = getClient();

			try {
				response = client.sendRequest(createData);

				if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
					System.out.println(response.getErrorMessage());
				} else {

					System.out.println("RecordID: " + response.getRecordID());
					System.out.println();

					for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
						System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
					}
					System.out.println();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}



		if(instanceOfRetailStockedSugarPricesRangeLocal){
			retailStockedSugarPricesRangeLocal=(RetailStockedSugarPricesRangeLocal)objectToPost;


			createData.setLogin(retailStockedSugarPricesRangeLocal.getLoginRequest());
			createData.setWebServiceType(retailStockedSugarPricesRangeLocal.getServiceType());



			data.addField("localsugar_20kgbale", retailStockedSugarPricesRangeLocal.getLocalSugar20kgBale());
			data.addField("localsugar_24kgbale", retailStockedSugarPricesRangeLocal.getLocalSugar24kgBale());
			data.addField("localsugar_brand_own", retailSugarPricesRangeLocal.getBrand());
			data.addField("localsugar_50kgbag",retailStockedSugarPricesRangeLocal.getLocalSugar50kgBag());
			//data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
			data.addField("AFA_SD_SGR_Surveyshops_ID",retailStockedSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
			createData.setDataRow(data);

			WebServiceConnection client = getClient();

			try {
				response = client.sendRequest(createData);

				if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
					System.out.println(response.getErrorMessage());
				} else {

					System.out.println("RecordID: " + response.getRecordID());
					System.out.println();

					for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
						System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
					}
					System.out.println();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}



		if(instanceOfretailStockedSugarPricesRangeImported){
			retailStockedSugarPricesRangeImported=(RetailStockedSugarPricesRangeImported) objectToPost;


			createData.setLogin(retailStockedSugarPricesRangeImported.getLoginRequest());
			createData.setWebServiceType(retailStockedSugarPricesRangeImported.getServiceType());



			data.addField("importedsugar_20kgbale", retailStockedSugarPricesRangeImported.getLocalSugar20kgBale());
			data.addField("importedsugar_24kgbale", retailStockedSugarPricesRangeImported.getLocalSugar24kgBale());
			data.addField("importedsugar_cntryoforigin", retailStockedSugarPricesRangeImported.getCountryID());
			data.addField("importedsugar_50kgbag",retailStockedSugarPricesRangeImported.getLocalSugar50kgBag());
			//data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
			data.addField("AFA_SD_SGR_Surveyshops_ID",retailStockedSugarPricesRangeImported.getAFA_SD_SGR_Surveyshops_ID());
			createData.setDataRow(data);

			WebServiceConnection client = getClient();

			try {
				response = client.sendRequest(createData);

				if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
					System.out.println(response.getErrorMessage());
				} else {

					System.out.println("RecordID: " + response.getRecordID());
					System.out.println();

					for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
						System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
					}
					System.out.println();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}


        if(instanceOfWholeSaleBrandLocal){
           wholeSaleBrandLocal=(WholeSaleBrandLocal) objectToPost;


            createData.setLogin(wholeSaleBrandLocal.getLoginRequest());
            createData.setWebServiceType(wholeSaleBrandLocal.getServiceType());


            data.addField("whlsllssugarprice_20kgbale", wholeSaleBrandLocal.getPriceOfTwentykgBale());
            data.addField("whlsllssugarprice_24kgbale", wholeSaleBrandLocal.getPriceOfTwentyFOurkgBale());
            data.addField("whlsllssugarprice_50kgbag", wholeSaleBrandLocal.getPriceOfFiftykgBag());
            data.addField("whlsllocalsgr_brand_own",wholeSaleBrandLocal.getBrand());
            //data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
            data.addField("AFA_SD_SGR_Surveyshops_ID",wholeSaleBrandLocal.getAFA_SD_SGR_Surveyshops_ID());
            createData.setDataRow(data);

            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createData);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());
                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if(instanceOfWholeSaleImportedSugar){
        wholeSaleImportedSugar=(WholeSaleImportedSugar) objectToPost;


            createData.setLogin(wholeSaleImportedSugar.getLoginRequest());
            createData.setWebServiceType(wholeSaleImportedSugar.getServiceType());



            data.addField("whlslimportedsugar_20kgbale", wholeSaleImportedSugar.getPriceOf20kgBale());
            data.addField("whlslimportedsugar_24kgbale", wholeSaleImportedSugar.getPriceOf24kgBale());
            data.addField("whlslimprtdsgr_cntryoforigin", wholeSaleImportedSugar.getC_country_id());
            data.addField("whlslimportedsugar_50kgbag",wholeSaleImportedSugar.getPriceOf50kgBag());
            //data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
            data.addField("AFA_SD_SGR_Surveyshops_ID",wholeSaleImportedSugar.getAFA_SD_SGR_Surveyshops_ID());
            createData.setDataRow(data);

            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createData);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());
                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }



       /* if(instanceOfWholeSaleBrandLocal){
            wholeSaleBrandLocal=(WholeSaleBrandLocal) objectToPost;


            createData.setLogin(wholeSaleBrandLocal.getLoginRequest());
            createData.setWebServiceType(wholeSaleBrandLocal.getServiceType());


            data.addField("whlsllssugarprice_20kgbale", wholeSaleBrandLocal.getPriceOfTwentykgBale());
            data.addField("whlsllssugarprice_24kgbale", wholeSaleBrandLocal.getPriceOfTwentyFOurkgBale());
            data.addField("whlsllssugarprice_50kgbag", wholeSaleBrandLocal.getPriceOfFiftykgBag());
            data.addField(" whlsllocalsgr_brand_own",wholeSaleBrandLocal.getBrand());
            //data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
            data.addField("AFA_SD_SGR_Surveyshops_ID",wholeSaleBrandLocal.getAFA_SD_SGR_Surveyshops_ID());
            createData.setDataRow(data);

            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createData);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());
                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
*/
        if(instanceOfWholeSaleStockedBrandLocal){
            wholeSaleStockedBrandLocal=(WholeSaleStockedBrandLocal) objectToPost;


            createData.setLogin(wholeSaleStockedBrandLocal.getLoginRequest());
            createData.setWebServiceType(wholeSaleStockedBrandLocal.getServiceType());



            data.addField("stknglocalsugar_20kgbale", wholeSaleStockedBrandLocal.getPriceOf20kgBale());
            data.addField("stknglocalsugar_24kgbale", wholeSaleStockedBrandLocal.getPriceOf24kgBale());
            data.addField("stcknglocalsgr_brand_own", wholeSaleStockedBrandLocal.getBrand());
            data.addField("stknglocalsugar_50kgbag",wholeSaleStockedBrandLocal.getPriceOf50kgBag());
            //data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
            data.addField("AFA_SD_SGR_Surveyshops_ID",wholeSaleStockedBrandLocal.getAFA_SD_SGR_Surveyshops_ID());
            createData.setDataRow(data);

            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createData);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());
                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if(instanceOfWholeSaleImportedStockedSugar){
            wholeSaleImportedStockedSugar=(WholeSaleImportedStockedSugar) objectToPost;


            createData.setLogin(wholeSaleImportedStockedSugar.getLoginRequest());
            createData.setWebServiceType(wholeSaleImportedStockedSugar.getServiceType());



            data.addField("stkngimportedsugar_20kgbale", wholeSaleImportedStockedSugar.getPriceOf20kgBale());
            data.addField("stkngimportedsugar_24kgbale", wholeSaleImportedStockedSugar.getPriceOf24kgBale());
            data.addField("stckngimprtdsgr_cntryoforigin", wholeSaleImportedStockedSugar.getC_country_id());
            data.addField("stkngimportedsugar_50kgbag",wholeSaleImportedStockedSugar.getPriceOf50kgBag());
            //data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
            data.addField("AFA_SD_SGR_Surveyshops_ID",wholeSaleImportedStockedSugar.getAFA_SD_SGR_Surveyshops_ID());
            createData.setDataRow(data);

            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createData);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());
                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }





        return response;

	}

	@Override
	protected void onPostExecute(StandardResponse serverMessage) {
		caller.dismissProgressDialog();


		if (!errorOccured) {
			caller.onHttpPostTaskSucceeded(requestCode, serverMessage);
		}
	}

	public interface HttpJsonPostTaskCaller extends AsyncActivity {
		void onHttpPostTaskSucceeded(int requestCode, StandardResponse serverMessage);
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