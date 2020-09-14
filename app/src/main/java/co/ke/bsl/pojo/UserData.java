package co.ke.bsl.pojo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author kirwa
 *
 */

/**
 * @author kirwa
 *
 */
@JsonIgnoreProperties({ "valid" })
public class UserData implements Serializable {


	private String agentId;


	private City city;

	private WholeSaleBrandLocal wholeSaleBrandLocal;

	private List<WholeSaleImportedSugar> wholeSaleImportedSugarList;


	private List<WholeSaleImportedStockedSugar> wholeSaleImportedStockedSugarList;
	private List<WholeSaleBrandLocal>  wholeSaleBrandLocalList;

	private List<WholeSaleStockedBrandLocal> wholeSaleStockedBrandLocalList;




	private Survey survey;


	private Country  importSugarCountryOfOrigin;


	private Country  importSugarStockedCountryOfOrigin;







	/**
	 * @return the agentId
	 */
	public String getAgentId() {
		return agentId;
	}


	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}




	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}


	/**
	 * @return the wholeSaleBrandLocal
	 */
	public WholeSaleBrandLocal getWholeSaleBrandLocal() {
		return wholeSaleBrandLocal;
	}


	/**
	 * @param wholeSaleBrandLocal the wholeSaleBrandLocal to set
	 */
	public void setWholeSaleBrandLocal(WholeSaleBrandLocal wholeSaleBrandLocal) {
		this.wholeSaleBrandLocal = wholeSaleBrandLocal;
	}


	/**
	 * @return the wholeSaleImportedSugarList
	 */
	public List<WholeSaleImportedSugar> getWholeSaleImportedSugarList() {
		return wholeSaleImportedSugarList;
	}


	/**
	 * @param wholeSaleImportedSugarList the wholeSaleImportedSugarList to set
	 */
	public void setWholeSaleImportedSugarList(List<WholeSaleImportedSugar> wholeSaleImportedSugarList) {
		this.wholeSaleImportedSugarList = wholeSaleImportedSugarList;
	}


	/**
	 * @return the wholeSaleImportedStockedSugarList
	 */
	public List<WholeSaleImportedStockedSugar> getWholeSaleImportedStockedSugarList() {
		return wholeSaleImportedStockedSugarList;
	}


	/**
	 * @param wholeSaleImportedStockedSugarList the wholeSaleImportedStockedSugarList to set
	 */
	public void setWholeSaleImportedStockedSugarList(
			List<WholeSaleImportedStockedSugar> wholeSaleImportedStockedSugarList) {
		this.wholeSaleImportedStockedSugarList = wholeSaleImportedStockedSugarList;
	}


	/**
	 * @return the wholeSaleBrandLocalList
	 */
	public List<WholeSaleBrandLocal> getWholeSaleBrandLocalList() {
		return wholeSaleBrandLocalList;
	}


	/**
	 * @param wholeSaleBrandLocalList the wholeSaleBrandLocalList to set
	 */
	public void setWholeSaleBrandLocalList(List<WholeSaleBrandLocal> wholeSaleBrandLocalList) {
		this.wholeSaleBrandLocalList = wholeSaleBrandLocalList;
	}


	/**
	 * @return the wholeSaleStockedBrandLocalList
	 */
	public List<WholeSaleStockedBrandLocal> getWholeSaleStockedBrandLocalList() {
		return wholeSaleStockedBrandLocalList;
	}


	/**
	 * @param wholeSaleStockedBrandLocalList the wholeSaleStockedBrandLocalList to set
	 */
	public void setWholeSaleStockedBrandLocalList(List<WholeSaleStockedBrandLocal> wholeSaleStockedBrandLocalList) {
		this.wholeSaleStockedBrandLocalList = wholeSaleStockedBrandLocalList;
	}





	/**
	 * @return the survey
	 */
	public Survey getSurvey() {
		return survey;
	}


	/**
	 * @param survey the survey to set
	 */
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}


	/**
	 * @return the importSugarCountryOfOrigin
	 */
	public Country getImportSugarCountryOfOrigin() {
		return importSugarCountryOfOrigin;
	}


	/**
	 * @param importSugarCountryOfOrigin the importSugarCountryOfOrigin to set
	 */
	public void setImportSugarCountryOfOrigin(Country importSugarCountryOfOrigin) {
		this.importSugarCountryOfOrigin = importSugarCountryOfOrigin;
	}


	/**
	 * @return the importSugarStockedCountryOfOrigin
	 */
	public Country getImportSugarStockedCountryOfOrigin() {
		return importSugarStockedCountryOfOrigin;
	}


	/**
	 * @param importSugarStockedCountryOfOrigin the importSugarStockedCountryOfOrigin to set
	 */
	public void setImportSugarStockedCountryOfOrigin(Country importSugarStockedCountryOfOrigin) {
		this.importSugarStockedCountryOfOrigin = importSugarStockedCountryOfOrigin;
	}







}
