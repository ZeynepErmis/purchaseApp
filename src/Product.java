/*
Student Name: Zeynep Ermis
Student ID:u2089064
*/
public class Product {

	// attributes
	private int productId;
	private int supplierId;
	private String productName;

	// attributes
	public Product(int productId, int supplierId, String productName) {
		super();
		this.productId = productId;
		this.supplierId = supplierId;
		this.productName = productName;
	}

	/**
	 * @return the productId
	 */
	public int getProductID() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductID(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the supplierId
	 */
	public int getSupplier() {
		return supplierId;
	}

	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplier(int supplierId) {
		this.supplierId = supplierId;
	}

	@Override
	public String toString() {
		return productId + "\t\t " + supplierId + "\t\t" + productName + "\t\t";
	}

}
