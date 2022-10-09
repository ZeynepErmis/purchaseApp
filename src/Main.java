/*
Student Name: Zeynep Ermis
Student ID:u2089064
*/
//the Main class 

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("**************************");
		System.out.println("Welcome to Purchasing App ");
		System.out.println("**************************\n");

		// Initialise Supplier, Product, Order List
		SupplierList sList = new SupplierList();
		ProductList pList = new ProductList();
		OrderList oList = new OrderList();

		// To read the Product, Supplier, Order List records which saved in the system
		purchaseAppFileHandler.readProductRecords(pList);
		purchaseAppFileHandler.readSupplierRecords(sList);
		purchaseAppFileHandler.readOrderRecords(oList);
		System.out.println("\n");

		// char variable (choice) for choosing the menu options
		char choice;
		do {
			// menu options
			System.out.println("Main Menu \n");
			System.out.println("1. Create Supplier ");
			System.out.println("2. List Suppliers");
			System.out.println("3. Create Product ");
			System.out.println("4. List Products");
			System.out.println("5. Create Order ");
			System.out.println("6. Order Details ");
			System.out.println("7. Save and Quit ");
			System.out.println();
			System.out.print("Select an option [1-7]: ");
			// to get input from the user
			choice = Scanners.nextChar();
			System.out.println();

			switch (choice) {
			case '1':
				// creating a new supplier
				System.out.println("Create Supplier");
				// call the addSupplierHandler to add new supplier
				addSupplierHandler(sList);
				break;
			case '2':
				// listing the suppliers
				System.out.println("List Suppliers");
				// calling the listSuppliersHandler to list suppliers
				listSuppliersHandler(sList);
				break;
			case '3':
				// creating a new product in existing supplier id
				System.out.println("Create Product");
				// call the addSupplierHandler to add new supplier
				addProductHandler(pList, sList);
				break;
			case '4':
				// listing the suppliers
				System.out.println("List Products");
				// calling the listProductsHandler to list suppliers
				listProductsHandler(pList);
				break;
			case '5':
				// making a payment and creating an order
				System.out.println("Create Order");
				// calling the makePaymentHandler to continue making money
				makePaymentHandler(pList, sList, oList);
				break;
			case '6':
				// listing the order details
				System.out.println("Order Details");
				// calling the listOrderHandler to show order details
				listOrderHandler(oList);
				break;
			case '7':
				// save ad quit
				System.out.println("Save and Quit");
				// calling the saveAndQuitHandler
				System.out.println("Have a nice day!");
				saveAndQuitHandler(sList, pList, oList);
				break;
			default:
				System.out.println("Please enter a number between 1-7  only\n");

			}
		} while (choice != '7');
	}

	// method to request Supplier Id, Name from the user
	static void addSupplierHandler(SupplierList sList) {
		int supplierId = sList.generateSupplierId();
		System.out.println("Please Enter Supplier Name : ");
		String name = Scanners.nextString();
		// input validation
		do {
			if (name.isEmpty() && name != null) {
				System.out.println("This field cannot be left blank, please re-enter valid Supplier Name : ");
				name = Scanners.nextString();
			}
		} while (name.isEmpty() && name != null);

		// creating a new supplier into the system
		Supplier supplier = new Supplier(supplierId, name);
		// add the supplier in sList
		sList.addSupplier(supplier);
		// printing the new supplier in console
		System.out.println("\n***The Supplier successfully added*** " + "\n" + "Supplier ID : " + supplierId + " "
				+ "Supplier Name :" + name + "\n");
	}

	// method to display Suppliers in the system
	static void listSuppliersHandler(SupplierList sList) {
		// no suppliers to display
		if (sList.emptyList()) {
			System.out.println("There is no Supplier in the system");
			// display suppliers
		} else {
			System.out.println("Supplier ID" + "\t" + "Supplier Name");
			for (int i = 0; i < sList.getSize(); i++) {
				System.out.println(sList.getSupplier(i));
			}
		}
		System.out.println("\n");
	}

	// method to add product in the existing Supplier in the system
	static void addProductHandler(ProductList pList, SupplierList sList) {

		int productId = pList.generateProductId();
		System.out.println("Select Supplier ID : ");
		int supplierId = Scanners.nextInt();
		// checks for existing Supplier Id to create a new product in the existing
		// Supplier
		while (sList.searchSupplierID(supplierId) == null) {
			System.out.println("Please check the Suppliers and re-enter an existing Supplier ID! \n");
			listSuppliersHandler(sList);
			System.out.println("Please re Enter Supplier ID : ");
			supplierId = Scanners.nextInt();
			System.out.println("\n");
		}

		System.out.println("Please Enter Product Name: ");
		String name = Scanners.nextString();
		// input validation
		do {
			if (name.isEmpty() && name != null) {
				System.out.println("This field cannot be left blank, please re-enter valid Product Name : ");
				name = Scanners.nextString();
			}
		} while (name.isEmpty() && name != null);

		Product product = new Product(productId, supplierId, name);
		// creating a new product into the system
		pList.addProduct(product);
		// printing the new product in console
		System.out.println("\n***The Product successfully added*** " + "\n" + " " + "Product ID : " + productId + "  "
				+ "Supplier ID : " + supplierId + " " + "Product Name : " + name + " " + "\n");

	}

	// method to display Products in the system
	static void listProductsHandler(ProductList pList) {
		// no products to display
		if (pList.emptyList()) {
			System.out.println("There is no product in the system");
			// display product
		} else {
			System.out.println("Product ID" + "\t" + "Supplier ID" + "\t" + "Product Name" + "\t");
			for (int j = 0; j < pList.getTotalProducts(); j++) {
				System.out.println(pList.getProduct(j));
			}
		}
		System.out.println("\n");
	}

	// method to make a payment in the existing supplier, product id with creating
	// unique order id
	static void makePaymentHandler(ProductList pList, SupplierList sList, OrderList oList) {

		boolean a = true;
		int orderId = oList.generateOrderId();

		System.out.println("Please enter the date [dd/MM/yyyy] continue making the payment : ");
		String paymentDate = Scanners.nextString();
		while (Scanners.isValid(paymentDate) != a) {
			System.out.println("Please re-enter the date [dd/MM/yyyy] continue making the payment : ");
			paymentDate = Scanners.nextString();
		}

		System.out.println("Select Supplier ID : ");
		int supplierId = Scanners.nextInt();
		// checks for existing Supplier Id to create a new product in the existing
		// Supplier
		while (sList.searchSupplierID(supplierId) == null) {
			System.out.println("Please check the Suppliers and re-enter an existing Supplier Id! \n");
			listSuppliersHandler(sList);
			System.out.println("Please re Enter Supplier ID : ");
			supplierId = Scanners.nextInt();
		}

		System.out.println("Select Product ID : ");
		int productId = Scanners.nextInt();
		// checks for existing Supplier Id to create a new product in the existing
		// Supplier
		while (pList.searchProductID(productId) == null) {
			System.out.println("Please check the Products and re-enter an existing Product Id! \n");
			listProductsHandler(pList);
			System.out.println("Please re Enter Product ID : ");
			productId = Scanners.nextInt();
		}

		System.out.println("Please enter Product Quantity : ");
		int productQuantity = Scanners.nextInt();
		System.out.println("Please Enter Product Unit Price to continue making the payment : ");
		double unitPrice = Scanners.nextDouble();
		double totalprice = productQuantity * unitPrice;

		System.out.println("Please enter your requested delivery date [dd/MM/yyyy] : ");
		String deliveryDate = Scanners.nextString();
		while (Scanners.isValid(deliveryDate) != a) {
			System.out.println("Please re-enter the date [dd/MM/yyyy] continue making the payment : ");
			deliveryDate = Scanners.nextString();
		}

		Order order = new Order(paymentDate, orderId, supplierId, productId, productQuantity, unitPrice, totalprice,
				deliveryDate);
		oList.addOrder(order);
		System.out.println("\n***Payment has been made and order has been created*** \n" + "Order ID :" + orderId + "\t"
				+ "Payment Date : " + paymentDate + "\t" + "Total Price : " + totalprice + "\t" + "Delivery Date : "
				+ deliveryDate);
		System.out.println("Order ID : " + orderId + " --> Your order will be delivered on the date you request.");
		System.out.println("\n");
	}

	// method to display Orders in the system
	private static void listOrderHandler(OrderList oList) {
		if (oList.emptyList()) // no orders to display
		{
			System.out.println("There is no order in the system");
		} else // display orders
		{
			System.out.println("Payment Date " + "\t" + "Order ID" + "\t" + "Supplier ID" + "\t" + "Product ID" + "\t"
					+ "Product Quantity" + "\t" + "Unit Price" + "\t" + "Total Price" + "\t" + "Delivery Day");
			for (int j = 0; j < oList.getSize(); j++) {
				System.out.println(oList.getOrder(j));
			}
		}
		System.out.println("\n");
	}

	// method to save Product, Supplier and Order details
	static void saveAndQuitHandler(SupplierList sList, ProductList pList, OrderList oList) {

		purchaseAppFileHandler.saveProductRecords(pList);
		purchaseAppFileHandler.saveSupplierRecords(sList);
		purchaseAppFileHandler.saveOrderRecords(oList);
		System.out.println("\n");
	}

}
