/*
Student Name: Zeynep Ermis
Student ID:u2089064
*/
import java.util.ArrayList;

public class ProductList {

	// attributes
	private ArrayList<Product> productList;

	// constructor
	public ProductList() {
		productList = new ArrayList<>();
	}

	// reads the product at given position
	// @param position position of the product in the product list
	// @return Returns the product at the given position in the list or null
	// if no product at that specific logical position
	public Product getProduct(int position) {
		if (position < 0 || position > getTotalProducts()) {
			// check for valid position
			return null;
			// no object found at given position
		} else {
			return productList.get(position);
		}
	}

	// Searches for the order in the given productID
	// @param productID The productID to search for
	// @return Returns the product in the given productID or null if no product in
	// the productID
	public Product searchProductID(int productID) {
		for (Product currentProduct : productList) {
			// find product with given product id
			if (currentProduct.getProductID() == productID) {
				return currentProduct;
			}
		}
		System.out.println("Product ID : " + productID + " does not exist in the system");
		return null; // no tenant found with given room number
	}

	// Automatically assigns productIDs
	public int generateProductId() {
		// If the product list is empty, the productId is given as 1
		if (productList.isEmpty()) {
			return 1;
		}
		// If there is an productId in the order list, it returns 1 more than the last
		// productId
		int lastProductId = productList.get(getTotalProducts() - 1).getProductID();
		return lastProductId + 1;
	}

	// Reports on whether or not the list is empty
	// @return Returns true if the list is full and false otherwise
	public boolean emptyList() {
		return productList.isEmpty();
	}

	// Adds a new product to the end of the list
	// @param product the Product to add
	public void addProduct(Product product) {
		productList.add(product);

	}

	// gets the total number of products
	// @return Returns the total number of products in the list
	public int getTotalProducts() {
		return productList.size();
	}

	@Override
	public String toString() {
		return "Product List : " + productList.toString();
	}
}
