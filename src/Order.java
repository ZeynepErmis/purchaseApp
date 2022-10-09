/*
Student Name: Zeynep Ermis
Student ID:u2089064
*/

public class Order {

	// attributes
	private String paymentDate;
	private int orderId;
	private int supplierId;
	private int productId;
	private int quantity;
	private double unitPrice;
	private double totalPrice;
	private String orderDeliveryDate;

	// constructor
	public Order(String paymentDate, int orderId, int supplierId, int productId, int quantity, double unitPrice,
			double totalPrice, String orderDeliveryDate) {
		super();
		this.orderId = orderId;
		this.supplierId = supplierId;
		this.productId = productId;
		this.quantity = quantity;
		this.paymentDate = paymentDate;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.orderDeliveryDate = orderDeliveryDate;
	}

	/**
	 * @return the orderDate
	 */
	public String getPaymentDate() {
		return paymentDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the supplierId
	 */
	public int getSupplierId() {
		return supplierId;
	}

	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/**
	 * @return the orderDeliveryDate
	 */
	public String getOrderDeliveryDate() {
		return orderDeliveryDate;
	}

	/**
	 * @param orderDeliveryDate the orderDeliveryDate to set
	 */
	public void setOrderDeliveryDate(String orderDeliveryDate) {
		this.orderDeliveryDate = orderDeliveryDate;
	}

	@Override
	public String toString() {
		return paymentDate + "\t\t " + orderId + "\t\t" + supplierId + "\t\t" + productId + "\t\t" + quantity + "\t\t"
				+ unitPrice + "\t\t" + totalPrice + "\t\t" + orderDeliveryDate ;
	}

}