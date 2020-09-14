package co.ke.bsl.pojo;

public class Product implements java.io.Serializable{
	
	private String productID;

	private String productCategoryID;

	private String name;


	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductCategoryID() {
		return productCategoryID;
	}

	public void setProductCategoryID(String productCategoryID) {
		this.productCategoryID = productCategoryID;
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
