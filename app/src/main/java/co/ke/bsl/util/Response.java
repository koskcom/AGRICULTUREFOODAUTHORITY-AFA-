/**
 * 
 */
package co.ke.bsl.sisdo.util;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * Class to Model request responses
 * 
 * @author kirwa
 * 
 */
public class Response implements Serializable{

	private String responseCode;
	private String message;
	private Object content;
	private String ad_user_Id;
	private String name;
	private List<String> countiesList;

	public List<String> getCountiesList() {
		return countiesList;
	}

	public Response setCountiesList(List<String> countiesList) {
		this.countiesList = countiesList;
		return this;
	}

	public Response() {

	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public String getAd_user_Id() {
		return ad_user_Id;
	}

	public void setAd_user_Id(String ad_user_Id) {
		this.ad_user_Id = ad_user_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
