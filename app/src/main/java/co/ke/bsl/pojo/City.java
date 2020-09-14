package co.ke.bsl.pojo;

public class City  implements java.io.Serializable{
	
	private String c_city_id;
	private String name;
	/**
	 * @return the c_city_id
	 */
	public String getC_city_id() {
		return c_city_id;
	}
	/**
	 * @param c_city_id the c_city_id to set
	 */
	public void setC_city_id(String c_city_id) {
		this.c_city_id = c_city_id;
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
