
/*
Student Name: Zeynep Ermis
Student ID:u2089064
GUI for the Purchase Application
*/
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Purchase extends Application {

	// the fields

	private final int WIDTH = 800;
	private final int HEIGHT = 800;

	// visual components
	private Label headingLabel = new Label("Purchase Application");

	// visual components for supplier
	private Label supplierHeadingLabel = new Label("Supplier");
	private Label supplierLabel = new Label("Supplier Name");
	private TextField supplierField = new TextField();
	private Button createSupplierButton = new Button("Create Supplier");
	private Button listSupplierButton = new Button("List Suppliers");
	private TextArea displayArea1 = new TextArea();

	// visual components for product
	private Label productHeadingLabel = new Label("Product");
	private Label productLabel1 = new Label("Supplier ID");
	private TextField productField1 = new TextField();
	private Label productLabel2 = new Label("Product Name");
	private TextField productField2 = new TextField();
	private Button createProductButton = new Button("Create Product");
	private Button listProductButton = new Button("List Products");
	private TextArea displayArea2 = new TextArea();

	// visual components for order
	private Label orderHeadingLabel = new Label("Order");
	private Label orderLabel1 = new Label("Order Date");
	private TextField orderField1 = new TextField();
	private Label orderLabel2 = new Label("Supplier ID");
	private TextField orderField2 = new TextField();
	private Label orderLabel3 = new Label("Product ID");
	private TextField orderField3 = new TextField();
	private Label orderLabel4 = new Label("Product Quantity");
	private TextField orderField4 = new TextField();
	private Label orderLabel5 = new Label("Unit Price");
	private TextField orderField5 = new TextField();
	private Label orderLabel6 = new Label("Delivery Day");
	private TextField orderField6 = new TextField();
	private Button createOrderButton = new Button("Create Order");
	private Button listOrderButton = new Button("List Orders");
	private Button saveQuitButton = new Button("Save and Quit");
	private TextArea displayArea3 = new TextArea();

	// initialises the screen
	@Override
	public void start(Stage stage) {

		// initialise the SupplierList, ProductList and OrderList
		SupplierList sList = new SupplierList();
		ProductList pList = new ProductList();
		OrderList oList = new OrderList();

		// To read the Product, Supplier, Order List records which saved in the system
		purchaseAppFileHandler.readProductRecords(pList);
		purchaseAppFileHandler.readSupplierRecords(sList);
		purchaseAppFileHandler.readOrderRecords(oList);

		// create HBoxes
		HBox hBoxSupplier1 = new HBox(10);
		HBox hBoxSupplier2 = new HBox(10);
		HBox hBoxSupplier3 = new HBox(10);

		HBox hBoxProduct1 = new HBox(10);
		HBox hBoxProduct2 = new HBox(10);
		HBox hBoxProduct3 = new HBox(10);

		HBox hBoxOrder1 = new HBox(10);
		HBox hBoxOrder2 = new HBox(10);
		HBox hBoxOrder3 = new HBox(10);
		HBox hBoxOrder4 = new HBox(10);

		// components to add HBoxes
		hBoxSupplier1.getChildren().addAll(supplierHeadingLabel);
		hBoxSupplier2.getChildren().addAll(supplierLabel, supplierField);
		hBoxSupplier3.getChildren().addAll(createSupplierButton, listSupplierButton);

		hBoxProduct1.getChildren().addAll(productHeadingLabel);
		hBoxProduct2.getChildren().addAll(productLabel1, productField1, productLabel2, productField2);
		hBoxProduct3.getChildren().addAll(createProductButton, listProductButton);

		hBoxOrder1.getChildren().addAll(orderHeadingLabel);
		hBoxOrder2.getChildren().addAll(orderLabel1, orderField1, orderLabel2, orderField2, orderLabel3, orderField3,
				orderLabel4, orderField4, orderLabel5, orderField5, orderLabel6, orderField6);
		hBoxOrder3.getChildren().addAll(orderLabel4, orderField4, orderLabel5, orderField5, orderLabel6, orderField6);
		hBoxOrder4.getChildren().addAll(createOrderButton, listOrderButton, saveQuitButton);

		// create vBox
		VBox vBox = new VBox(5);
		// set padding for vBox
		vBox.setPadding(new Insets(20, 20, 50, 20));
		vBox.setSpacing(10);

		// add all HBox components into vBox
		vBox.getChildren().addAll(headingLabel, hBoxSupplier1, hBoxSupplier2, hBoxSupplier3, displayArea1, hBoxProduct1,
				hBoxProduct2, hBoxProduct3, displayArea2, hBoxOrder1, hBoxOrder2, hBoxOrder3, hBoxOrder4, displayArea3);

		// creates the scene

		Scene scene = new Scene(vBox, Color.web("#ced4da"));

		// set font for heading 1
		Font font1 = new Font("Calibri", 34);
		headingLabel.setFont(font1);

		// set font for heading 2
		Font font2 = new Font("Calibri", 20);
		supplierHeadingLabel.setFont(font2);
		productHeadingLabel.setFont(font2);
		orderHeadingLabel.setFont(font2);

		// set font for heading 3
		Font font3 = new Font("Calibri", 15);
		supplierLabel.setFont(font3);
		productLabel1.setFont(font3);
		productLabel2.setFont(font3);
		orderLabel1.setFont(font3);
		orderLabel2.setFont(font3);
		orderLabel3.setFont(font3);
		orderLabel4.setFont(font3);
		orderLabel5.setFont(font3);
		orderLabel6.setFont(font3);

		// set color for headings
		headingLabel.setTextFill(Color.web("#264653"));

		supplierHeadingLabel.setTextFill(Color.web("#264653"));
		supplierLabel.setTextFill(Color.web("#264653"));

		productHeadingLabel.setTextFill(Color.web("#264653"));
		productLabel1.setTextFill(Color.web("#264653"));
		productLabel2.setTextFill(Color.web("#264653"));

		orderLabel1.setTextFill(Color.web("#264653"));
		orderLabel2.setTextFill(Color.web("#264653"));
		orderLabel3.setTextFill(Color.web("#264653"));
		orderLabel4.setTextFill(Color.web("#264653"));
		orderLabel5.setTextFill(Color.web("#264653"));
		orderLabel6.setTextFill(Color.web("#264653"));

		// set alignment for hBox
		hBoxSupplier1.setAlignment(Pos.BOTTOM_CENTER);
		hBoxSupplier2.setAlignment(Pos.BOTTOM_CENTER);
		hBoxSupplier3.setAlignment(Pos.BOTTOM_CENTER);

		hBoxProduct1.setAlignment(Pos.BOTTOM_CENTER);
		hBoxProduct2.setAlignment(Pos.BOTTOM_CENTER);
		hBoxProduct3.setAlignment(Pos.BOTTOM_CENTER);

		hBoxOrder1.setAlignment(Pos.BOTTOM_CENTER);
		hBoxOrder2.setAlignment(Pos.BOTTOM_CENTER);
		hBoxOrder3.setAlignment(Pos.BOTTOM_CENTER);
		hBoxOrder4.setAlignment(Pos.BOTTOM_CENTER);

		// set alignment for vBox
		vBox.setAlignment(Pos.CENTER);

		// set maximum width for components
		supplierField.setMaxWidth(150);

		productField1.setMaxWidth(150);
		productField2.setMaxWidth(150);

		orderField1.setMaxWidth(150);
		orderField2.setMaxWidth(150);
		orderField3.setMaxWidth(150);
		orderField4.setMaxWidth(150);
		orderField5.setMaxWidth(150);
		orderField6.setMaxWidth(150);

		vBox.setMinSize(WIDTH, HEIGHT);
		vBox.setMaxSize(WIDTH, HEIGHT);
		vBox.setBackground(Background.EMPTY);

		displayArea1.setMaxSize(WIDTH - 5, HEIGHT / 7);
		displayArea2.setMaxSize(WIDTH - 5, HEIGHT / 7);
		displayArea3.setMaxSize(WIDTH - 5, HEIGHT / 3);

		stage.setWidth(WIDTH);
		stage.setHeight(HEIGHT);

		// customise the button style
		createSupplierButton.setStyle("-fx-base: #bb3e03;");
		createSupplierButton.setMinHeight(30);
		createSupplierButton.setMinWidth(140);

		listSupplierButton.setStyle("-fx-base: #0096C7;");
		listSupplierButton.setMinHeight(30);
		listSupplierButton.setMinWidth(140);

		createProductButton.setStyle("-fx-base: #bb3e03;");
		createProductButton.setMinHeight(30);
		createProductButton.setMinWidth(140);

		listProductButton.setStyle("-fx-base: #0096C7;");
		listProductButton.setMinHeight(30);
		listProductButton.setMinWidth(140);

		createOrderButton.setStyle("-fx-base: #bb3e03;");
		createOrderButton.setMinHeight(30);
		createOrderButton.setMinWidth(140);

		listOrderButton.setStyle("-fx-base: #0096C7;");
		listOrderButton.setMinHeight(30);
		listOrderButton.setMinWidth(140);

		saveQuitButton.setStyle("-fx-base: #0096C7;");
		saveQuitButton.setMinHeight(30);
		saveQuitButton.setMinWidth(140);

		// calling methods for buttons
		createSupplierButton.setOnAction(e -> addSupplierHandler(sList));
		listSupplierButton.setOnAction(e -> listSuppliersHandler(sList));
		createProductButton.setOnAction(e -> addProductHandler(pList, sList));
		listProductButton.setOnAction(e -> listProductsHandler(pList));
		createOrderButton.setOnAction(e -> makePaymentHandler(pList, sList, oList));
		listOrderButton.setOnAction(e -> listOrderHandler(oList));
		saveQuitButton.setOnAction(e -> saveAndQuitHandler(pList, sList, oList));

		// set stage
		stage.setScene(scene);
		stage.setTitle("Purchase Applicaton");
		stage.setResizable(false); // see discussion below
		stage.show();

	}

	// EVENT HANDLER METHODS

	// method to request Supplier Name from the user
	private void addSupplierHandler(SupplierList sList) {
		int supplierId = sList.generateSupplierId();
		String supplierName = supplierField.getText();
		if (supplierName.isEmpty() && supplierName != null || supplierName.length() == 0) {
			displayArea1.setText("This field cannot be left blank, please enter Supplier Name");
			supplierName = supplierField.getText();
		} else {
			// creating a new supplier into the system
			Supplier supplier = new Supplier(supplierId, supplierName);
			// add the supplier in sList
			sList.addSupplier(supplier);
			supplierField.setText("");
			// printing the new supplier in displayArea1
			displayArea1.setText("The supplier is successfully added" + "\n" + "Supplier ID : " + supplierId + "\n"
					+ "Suppiler Name : " + supplierName);
		}

	}

	// method to display Suppliers in the system
	private void listSuppliersHandler(SupplierList sList) {
		// no suppliers to display
		if (sList.emptyList()) {
			displayArea1.setText("There is no Supplier in the system");
			// display suppliers
		} else {
			displayArea1.setText("Supplier ID  " + "\t" + "Supplier Name  " + "\n");
			for (int i = 0; i < sList.getSize(); i++) {
				displayArea1.appendText(sList.getSupplier(i).getSupplierID() + "\t\t\t"
						+ sList.getSupplier(i).getSupplierName() + "\n");
			}
		}

	}

	// method to add product in the existing Supplier in the system
	private void addProductHandler(ProductList pList, SupplierList sList) {
		int productId = pList.generateProductId();
		String supplierId = productField1.getText();
		String productName = productField2.getText();

		if (supplierId.length() == 0 || productName.length() == 0) {
			displayArea2.setText("These fields cannot be left blank, please enter Supplier ID and Product Name ");
		} else if (sList.searchSupplierID(Integer.parseInt(supplierId)) == null) {
			displayArea2.setText("Please check the Suppliers and re-enter an existing Supplier ID! \n");
			listSuppliersHandler(sList);
		} else if (productName.isEmpty() && productName != null) {
			displayArea2.setText("This field cannot be left blank, please re-enter Product Name ");
		} else {
			Product product = new Product(productId, Integer.parseInt(supplierId), productName);
			pList.addProduct(product);

			displayArea2.setText("Product successfully added" + "\n" + "Product ID : " + productId + "\n"
					+ "Supplier ID : " + supplierId + "\n" + "Product Name : " + productName + "\n");
		}

	}

	// method to display Products in the system
	private void listProductsHandler(ProductList pList) {
		if (pList.emptyList()) {
			displayArea2.setText("There is no product in the system");
			// display suppliers
		} else {
			displayArea2.setText("Product ID" + "\t" + "Supplier ID" + "\t" + "Product Name" + "\n");
			for (int i = 0; i < pList.getTotalProducts(); i++) {
				displayArea2.appendText(pList.getProduct(i).getProductID() + "\t\t\t"
						+ pList.getProduct(i).getSupplier() + "\t\t\t" + pList.getProduct(i).getProductName() + "\n");
			}
		}

	}

	// method to create order
	private void makePaymentHandler(ProductList pList, SupplierList sList, OrderList oList) {
		boolean a = true;
		int orderId = oList.generateOrderId();
		String supplierId = orderField2.getText();
		String paymentDate = orderField1.getText();
		String productId = orderField3.getText();
		String productQuantity = orderField4.getText();
		String unitPrice = orderField5.getText();
		String deliveryDate = orderField6.getText();

		if (supplierId.length() == 0 || paymentDate.length() == 0 || productId.length() == 0
				|| productQuantity.length() == 0 || deliveryDate.length() == 0) {
			displayArea3.setText("These fields cannot be left blank, please fill in all the fields above");
		} else if (Scanners.isValid(paymentDate) != a) {
			displayArea3.setText("Please re-enter the date [dd/MM/yyyy] continue making the payment");
		} else if (sList.searchSupplierID(Integer.parseInt(supplierId)) == null) {
			listSuppliersHandler(sList);
			displayArea3.setText("Please check the Suppliers and re-enter an existing Supplier ID! \n");
		} else if (pList.searchProductID(Integer.parseInt(productId)) == null) {
			listProductsHandler(pList);
			displayArea3.setText("Please check the Products and re-enter an existing Product ID! \n");
		} else if (Scanners.isValid(deliveryDate) != a) {
			displayArea3.setText("Please re-enter the date [dd/MM/yyyy] continue making the payment");
		} else {

			double totalPrice = Double.parseDouble(productQuantity) * Double.parseDouble(unitPrice);

			Order order = new Order(paymentDate, orderId, Integer.parseInt(supplierId), Integer.parseInt(productId),
					Integer.parseInt(productQuantity), Double.parseDouble(unitPrice), totalPrice, deliveryDate);
			oList.addOrder(order);

			displayArea3.setText("Payment has been made and order has been created\n" + "Order ID :" + orderId + "\t"
					+ "\n" + "Payment Date : " + paymentDate + "\t" + "\n" + "Total Price : " + totalPrice + "\t" + "\n"
					+ "Delivery Date : " + deliveryDate);
		}

	}

	// method to display orders in the system
	private void listOrderHandler(OrderList oList) {
		if (oList.emptyList()) // no orders to display
		{
			displayArea3.setText("There is no order in the system");
		} else // display orders
		{
			displayArea3.setText("Payment Date " + "\t\t" + "Order ID" + "\t\t" + "Supplier ID" + "\t" + "Product ID"
					+ "\t" + "Product Quantity" + "\t" + "Unit Price" + "\t\t" + "Total Price" + "\t" + "Delivery Day"
					+ "\n");
			for (int j = 0; j < oList.getSize(); j++) {
				displayArea3.appendText(oList.getOrder(j).getPaymentDate() + "\t\t\t" + oList.getOrder(j).getOrderId()
						+ "\t\t\t" + oList.getOrder(j).getSupplierId() + "\t\t\t" + oList.getOrder(j).getProductId()
						+ "\t\t\t" + oList.getOrder(j).getQuantity() + "\t\t\t\t" + oList.getOrder(j).getUnitPrice()
						+ "\t\t\t" + oList.getOrder(j).getTotalPrice() + "\t\t"
						+ oList.getOrder(j).getOrderDeliveryDate() + "\n");
			}
		}
		System.out.println("\n");

	}

	// method to save Product, Supplier and Order details
	private void saveAndQuitHandler(ProductList pList, SupplierList sList, OrderList oList) {
		purchaseAppFileHandler.saveProductRecords(pList);
		purchaseAppFileHandler.saveSupplierRecords(sList);
		purchaseAppFileHandler.saveOrderRecords(oList);
		Platform.exit();

	}

	// main method to run the application
	public static void main(String[] args) {
		launch(args);
	}

}
