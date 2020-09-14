package co.ke.bsl.pojo;

public class ProductCategory implements java.io.Serializable{
	
	private String productCategoryID;

	private String name;

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
