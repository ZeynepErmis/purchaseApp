/*
Student Name: Zeynep Ermis
Student ID:u2089064
*/
public class Supplier {
	private int supplierId;
	private String supplierName;

	public Supplier(int supplierId, String supplierName ) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
	}

	/**
	 * @return the supplierId
	 */
	public int getSupplierID() {
		return supplierId;
	}

	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierID(int supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * @return the supplierName
	 */
	public String getSupplierName() {
		return supplierName;
	}

	/**
	 * @param supplierName the supplierName to set
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Override
	public String toString() {
		return supplierId +  "\t\t " + supplierName;
	}

}
