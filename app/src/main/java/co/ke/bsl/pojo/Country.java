package co.ke.bsl.pojo;

import java.io.Serializable;

/**
 * @author kirwa
 *
 */
public class Country  implements Serializable{
	private String c_country_id;
	private String name;




	/**
	 * @return the c_country_id
	 */
	public String getC_country_id() {
		return c_country_id;
	}
	/**
	 * @param c_country_id the c_country_id to set
	 */
	public void setC_country_id(String c_country_id) {
		this.c_country_id = c_country_id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String toString()
	{
		return( name  );
	}



}
