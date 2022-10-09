/*
Student Name: Zeynep Ermis
Student ID:u2089064
*/
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class purchaseAppFileHandler {

	// method to read product records
	public static void readProductRecords(ProductList pList) {

		try (FileInputStream productFile = new FileInputStream("Product.txt");
				DataInputStream productReader = new DataInputStream(productFile)) {

			// temporary variables for attributes
			int tempProductId = 0;
			int tempSupplierId = 0;
			String tempProductName = new String("");

			// temporary Product
			Product tempProduct;

			int tot = productReader.readInt();
			for (int j = 1; j <= tot; j++) {
				tempProductId = productReader.readInt();
				tempSupplierId = productReader.readInt();
				tempProductName = productReader.readUTF();
				// add Product
				tempProduct = new Product(tempProductId, tempSupplierId, tempProductName);
				pList.addProduct(tempProduct);
			}

			// to close the file
			productReader.close();
		} catch (IOException ioe) {
			System.out.println("No product records found");
		}

	}

	// method to write product records
	public static void saveProductRecords(ProductList pList) {
		try {
			FileOutputStream productFile = new FileOutputStream("Product.txt");
			DataOutputStream productWriter = new DataOutputStream(productFile);
			productWriter.writeInt(pList.getTotalProducts());
			for (int i = 0; i < pList.getTotalProducts(); i++) {
				if (pList.getProduct(i) != null) {
					productWriter.writeInt(pList.getProduct(i).getProductID());
					productWriter.writeInt(pList.getProduct(i).getSupplier());
					productWriter.writeUTF(pList.getProduct(i).getProductName());
				}
			}
			productWriter.flush();
			productWriter.close();
		} catch (IOException ioe) {
			System.out.println("Error writing file");
		}
	}

	// method to read supplier records
	public static void readSupplierRecords(SupplierList sList) {
		try {
			FileInputStream supplierFile = new FileInputStream("Supplier.txt");
			DataInputStream supplierReader = new DataInputStream(supplierFile);

			// temporary variables for attributes
			int tempSupplierId = 0;
			String tempSupplierName = new String("");

			// temporary Supplier
			Supplier tempSupplier = null;
			int tot = 0;

			tot = supplierReader.readInt();
			for (int j = 1; j <= tot; j++) {
				tempSupplierId = supplierReader.readInt();
				tempSupplierName = supplierReader.readUTF();
				// add Supplier
				tempSupplier = new Supplier(tempSupplierId, tempSupplierName);
				sList.addSupplier(tempSupplier);
			}
			// to close the file
			supplierReader.close();
		} catch (IOException ioe) {
			System.out.println("No supplier records found");
		}

	}

	// method to write supplier records
	public static void saveSupplierRecords(SupplierList sList) {
		try {
			FileOutputStream supplierFile = new FileOutputStream("Supplier.txt");
			DataOutputStream supplierWriter = new DataOutputStream(supplierFile);
			supplierWriter.writeInt(sList.getSize());
			for (int i = 0; i < sList.getSize(); i++) {
				if (sList.getSupplier(i) != null) {
					supplierWriter.writeInt(sList.getSupplier(i).getSupplierID());
					supplierWriter.writeUTF(sList.getSupplier(i).getSupplierName());

				}
			}
			supplierWriter.flush();
			supplierWriter.close();
		} catch (IOException ioe) {
			System.out.println(" Error writing file");
		}
	}

	// method to read order records
	public static void readOrderRecords(OrderList oList) {
		try {
			FileInputStream orderFile = new FileInputStream("Order.txt");
			DataInputStream orderReader = new DataInputStream(orderFile);

			// temporary variables for attributes
			String tempPaymentDate = new String("");
			int tempOrderId = 0;
			int tempSupplierId = 0;
			int tempProductId = 0;
			int tempQuantity = 0;
			double tempUnitPrice = 0;
			double tempTotalPrice = 0;
			String tempOrderDate = new String("");

			// temporary Order
			Order tempOrder = null;
			int tot = 0;

			tot = orderReader.readInt();
			for (int j = 1; j <= tot; j++) {

				tempPaymentDate = orderReader.readUTF();
				tempOrderId = orderReader.readInt();
				tempSupplierId = orderReader.readInt();
				tempProductId = orderReader.readInt();
				tempQuantity = orderReader.readInt();
				tempUnitPrice = orderReader.readDouble();
				tempTotalPrice = orderReader.readDouble();
				tempOrderDate = orderReader.readUTF();

				//add Order
				tempOrder = new Order(tempPaymentDate, tempOrderId, tempSupplierId, tempProductId, tempQuantity,
						tempUnitPrice, tempTotalPrice, tempOrderDate);
				oList.addOrder(tempOrder);
			}

			// to close the file
			orderReader.close();
		} catch (IOException ioe) {
			System.out.println("No order records found");
		}

	}

	// method to write order records
	public static void saveOrderRecords(OrderList oList) {
		try {
			FileOutputStream orderFile = new FileOutputStream("Order.txt");
			DataOutputStream orderWriter = new DataOutputStream(orderFile);
			orderWriter.writeInt(oList.getSize());
			for (int i = 0; i < oList.getSize(); i++) {
				if (oList.getOrder(i) != null) {
					orderWriter.writeUTF(oList.getOrder(i).getPaymentDate());
					orderWriter.writeInt(oList.getOrder(i).getOrderId());
					orderWriter.writeInt(oList.getOrder(i).getSupplierId());
					orderWriter.writeInt(oList.getOrder(i).getProductId());
					orderWriter.writeInt(oList.getOrder(i).getQuantity());
					orderWriter.writeDouble(oList.getOrder(i).getUnitPrice());
					orderWriter.writeDouble(oList.getOrder(i).getTotalPrice());
					orderWriter.writeUTF(oList.getOrder(i).getOrderDeliveryDate());

				}
			}
			orderWriter.flush();
			orderWriter.close();
		} catch (IOException ioe) {
			System.out.println(" Error writing file");
		}
	}

}
