package co.ke.bsl.pojo;

public class Survey implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String documentNo;
	private String documentDate;
	private String surveyEndDate;


	private String typeOfSurvey;

	private String afa_sd_sugarprices_survey_id ;


	/**
	 * @return the documentNo
	 */
	public String getDocumentNo() {
		return documentNo;
	}

	/**
	 * @param documentNo the documentNo to set
	 */
	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	/**
	 * @return the documentDate
	 */
	public String getDocumentDate() {
		return documentDate;
	}

	/**
	 * @param documentDate the documentDate to set
	 */
	public void setDocumentDate(String documentDate) {
		this.documentDate = documentDate;
	}

	/**
	 * @return the surveyEndDate
	 */
	public String getSurveyEndDate() {
		return surveyEndDate;
	}

	/**
	 * @param surveyEndDate the surveyEndDate to set
	 */
	public void setSurveyEndDate(String surveyEndDate) {
		this.surveyEndDate = surveyEndDate;
	}



	/**
	 * @return the typeOfSurvey
	 */
	public String getTypeOfSurvey() {
		return typeOfSurvey;
	}

	/**
	 * @param typeOfSurvey the typeOfSurvey to set
	 */
	public void setTypeOfSurvey(String typeOfSurvey) {
		this.typeOfSurvey = typeOfSurvey;
	}


	public String toString()
	{
		return( documentNo  );
	}


	public String getAfa_sd_sugarprices_survey_id() {
		return afa_sd_sugarprices_survey_id;
	}

	public Survey setAfa_sd_sugarprices_survey_id(String afa_sd_sugarprices_survey_id) {
		this.afa_sd_sugarprices_survey_id = afa_sd_sugarprices_survey_id;
		return this;
	}
}
