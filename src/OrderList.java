/*
Student Name: Zeynep Ermis
Student ID:u2089064
*/
import java.util.ArrayList;

public class OrderList {

	// attributes
	private ArrayList<Order> orderList;

	// constructor
	public OrderList() {
		orderList = new ArrayList<>();
	}

	// reads the order at given position
	// @param position position of the order in the order list
	// @return Returns the order at the given position in the list or null
	// if no order at that specific logical position
	public Order getOrder(int position) {
		// check for valid position
		if (position < 0 || position > getSize()) {
			// no object found at given position
			return null;
		} else {
			return orderList.get(position);
		}
	}

	// Searches for the order in the given orderId
	// @param orderId The orderId to search for
	// @return Returns the order in the given orderId or null if no order in the
	// orderId
	public Order searchOrderID(int orderId) {
		for (Order currentOrder : orderList) {
			// find order with given ordeerId
			if (currentOrder.getOrderId() != orderId) {
				System.out.println("Order ID : " + orderId + " Order ID created");
			}
		}
		// no order found with given orderId
		return null;
	}

	// Automatically assigns orderIDs
	public int generateOrderId() {
		// If the order list is empty, the orderId is given as 1
		if (orderList.isEmpty()) {
			return 1;
		}
		// If there is an orderId in the order list, it returns 1 more than the last
		// orderId
		int lastOrderId = orderList.get(getSize() - 1).getOrderId();
		return lastOrderId + 1;
	}

	// reports whether the list is empty
	// @return Returns true if the list is empty and false otherwise
	public boolean emptyList() {
		return orderList.isEmpty();
	}

	// Adds a new order to the end of the list
	// @param order the Order to add
	public void addOrder(Order order) {
		orderList.add(order);
	}

	//Gets the total number of orders
	//@return Returns the total number of orders in the list
	public int getSize() {
		return orderList.size();
	}

	@Override
	public String toString() {
		return "Order List : " + orderList.toString();
	}
}
