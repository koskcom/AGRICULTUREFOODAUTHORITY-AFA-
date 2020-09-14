package co.ke.bsl.pojo;

public class PayCategory implements java.io.Serializable{
	
	private String payCategoryID;

	private String name;


	public String getPayCategoryID() {
		return payCategoryID;
	}

	public void setPayCategoryID(String payCategoryID) {
		this.payCategoryID = payCategoryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString()
	{
		return( this.name  );
	}

}
