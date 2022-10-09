
/*
Student Name: Zeynep Ermis
Student ID:u2089064
*/
import java.util.ArrayList;

public class SupplierList {

	// attributes
	private ArrayList<Supplier> supplierList;

	// constructor
	public SupplierList() {
		supplierList = new ArrayList<>();

	}

	// reads the supplier at given position
	// @param position position of the supplier in the supplier list
	// @return Returns the supplier at the given position in the list or null
	// if no supplier at that specific logical position
	public Supplier getSupplier(int position) {
		if (position < 0 || position > getSize()) {
			// check for valid position
			return null;
			// no object found at given position
		} else {
			return supplierList.get(position);
		}
	}

	// Searches for the supplier in the given order
	// @param supplierID The supplierID to search for
	// @return Returns the order in the given supplierID or null if no supplier in
	// the
	// supplierID
	public Supplier searchSupplierID(int supplierID) {
		for (Supplier currentSupplier : supplierList) {
			// find supplier with given supplier id
			if (currentSupplier.getSupplierID() == supplierID) {
				return currentSupplier;
			}
		}
		System.out.println("Supplier ID : " + supplierID + " does not exist in the system");
		return null; // no supplier found with given room number
	}

	// Automatically assigns supplierIDs
	public int generateSupplierId() {
		if (supplierList.isEmpty()) {
			// If the supplier list is empty, the supplierId is given as 1
			return 1;
		}
		// If there is an supplierId in the supplier list, it returns 1 more than the
		// last
		// supplierId
		int lastSupplierId = supplierList.get(getSize() - 1).getSupplierID();
		return lastSupplierId + 1;
	}

	// Reports on whether or not the list is empty
	// @return Returns true if the list is full and false otherwise
	public boolean emptyList() {
		return supplierList.isEmpty();
	}

	// Adds a new supplier to the end of the list
	// @param supplier the Supplier to add
	public void addSupplier(Supplier supplier) {
		supplierList.add(supplier);

	}

	// Gets the total number of suppliers
	// @return Returns the total number of suppliers in the list
	public int getSize() {
		return supplierList.size();
	}

	@Override
	public String toString() {
		return "Supplier List : " + supplierList.toString();
	}
}
