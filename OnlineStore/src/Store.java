
//@author Md. Asif Hassan | CSE

package OnlineStore;
import java.time.LocalDate;
import java.util.ArrayList;

public class Store {
	String name;
	ArrayList<Product> products = new ArrayList<>();
	Cart cart;

	// Constructor
	public Store(String name) {
		this.name=name;
		this.products= new ArrayList<>();
		this.cart=new Cart();
	}

	// ************** Cart related methods *******************

	public void addProductToCart(String id, int amt) throws CloneNotSupportedException {
		// Call findProduct. If the product exist and the store has enough quantity,
		// Call the addProduct method of Cart class. Otherwise show "Out of Stock" message
		// 
		int index = findProduct(id);
		if(index>=0) {
			Product p = (Product) products.get(index).clone();
			if (p.getQuantity()>= amt) {
				p.setQuantity(amt);
				cart.addProduct(p);
				return;
			}
		}

		System.out.println("Out Of Stock");

	}

	public void removeProductFromCart(String id) {
		// call removeProduct of Cart class
		cart.removeProduct(id);
	}

	public void updateProductInCart(String id, int count) {
		// Call the updateProduct method of Cart class	
		cart.updateProduct(id, count);
	}

	public void clearCart() {
		// Call the clearCart method of Cart class
		cart.clearCart();
	}

	// Pay Bill
	public void payBill() {
		// Iterate through each of the products in the cart and do the following
		// a) reduce those products quantity, 
		// b) If the item is on sale add the saleprice to the bill.
		// c) if not onSale add the totalPrice to bill. 
		// d) Call the clearCart method
		double bill=0;
		ArrayList<Product> cartList=cart.getCart();
		for(Product item:cartList) {
			int product_index=findProduct(item.getId());
			if(product_index>=0) {
				Product product=products.get(product_index);
				if(product.getQuantity()>=item.getQuantity()) {
					product.setQuantity(product.getQuantity()-item.getQuantity());
					bill+=product.salePrice(item.getQuantity());
				}
			}
			else {
				System.out.println("Invalid product.\n");
			}

		}
		System.out.print("Total bill: "+bill+".\n");
		cartList.clear();

	}

	// ****************View related methods ******************

	// Admin will see all the information about each product. 
	// Non-admin will be able to view just the name, id and price of the product
	// Display the items in groups (Food, Electronics, Clothing) 
	public void viewProducts(boolean isAdmin) {
		// if isAdmin is true call viewProductsAsAdmin for different categories
		// else call viewProducts for different categories
		if(isAdmin) {
			viewProductsAsAdmin(Category.Electronics);
			viewProductsAsAdmin(Category.Cloth);
			viewProductsAsAdmin(Category.Food);
		}
		else {
			viewProducts(Category.Electronics);
			viewProducts(Category.Cloth);
			viewProducts(Category.Food);
		}
	}

	// View the list of items in a specific category. Show only name, id and price
	public void viewProducts(Category category) {
		//System.out.println("\n" + category.toString()+":\n");
		for(Product product:products) {
			if(product.getCategory().equals(category)) {
				System.out.println(product.toString());
			}
		}
		// iterate through each of the product in products list
		// if the product is of category type, print the product using toString()
	}

	// View the list of items in a specific category. Show all info about each product.
	// This functionality is for admin
	public void viewProductsAsAdmin(Category category) {
		//System.out.println("\n" + category.toString()+":\n");
		for(Product product:products) {

			if(product.getCategory().equals(category)) {
				System.out.println(product.details());
			}
		}
		// iterate through each of the product in products list
		// if the product is of category type, print the product details using details()

	}

	// *************** Admin methods to put a item(s) on sale*************

	// Put all food items on sale that will expire within next expireWithin days
	public void putOnSaleFood(Integer expireWithin, int percentage) {
		// Search for the items that will expire within next expireWithin days and call putOnSale for that item
		for(Product product:products) {
			if(product.getCategory().equals(Category.Food)) {
				product.putOnSale(expireWithin, percentage);
			}
		}
	}

	// Put a specific cloth item on sale
	public void putOnSaleCloth(String  id, int percentage) {
		// Search for the items with the specific id and call putOnSale for that item
		for(Product product:products) {
			if(product.getCategory().equals(Category.Cloth)) {
				product.putOnSale(id, percentage);
			}
		}
	}

	// Put a specific cloth item on sale
	public void putOnSaleElectronic(String  id, int percentage) {
		// Search for the items with the specific id and call putOnSale for that item
		for(Product product:products) {
			if(product.getCategory().equals(Category.Electronics)) {
				product.putOnSale(id, percentage);
			}
		}
	}



	//****************************Admin methods to add items in the store*********

	// This method is for adding clothing item to the store
	public void addProduct(String name, String id, int quantity,String brand,SubCategory subCategory, Size size,double price) {
		// Call the addProduct(Product p) method with Clothing object as parameter
		Product product=new Clothing(name,id,quantity,brand,subCategory,price,size);
		addProduct(product);
	}

	// This method is for adding Electronics item to the store
	public void addProduct(String name, String id, int quantity, String manufacturer, ElectCategory subCategory, double price) {
		// Call the addProduct(Product p) method with Electronics object as parameter
		Product product=new Electronics(name,id,quantity,manufacturer,subCategory,price);
		addProduct(product);
	}

	// This method is for adding Food item to the store
	// I am adding this code as it is little tricky
	public void addProduct(String name, String id, int quantity, LocalDate mfg, LocalDate exp,double price) {
		int index = findProduct(id);
		if(index >=0) {
			Product pr= products.get(index);
			FoodItem item = (FoodItem)pr;
			if (item.getMfgDate().equals(mfg) && 
					item.getExpirationDate().equals(exp)) {
				item.updateQuantity(quantity);
				return;					
			}
		}
		products.add(new FoodItem(name, id, quantity, mfg, exp, price));
	}

	// ******************** private methods**************

	private int findProduct(String id) { 	 
		// search the product in the products list using id. 
		// If the product exists return the product, otherwise return -1
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;

	}

	// the following method is a private method for only Clothing and Electronics/
	private void addProduct(Product p) {
		// Check if the item is available in the store.
		// If available increment the quantity. Else add the product in the list

		int product_index=findProduct(p.getId());
		if(product_index!=-1) {
			Product product=products.get(product_index);
			product.setQuantity(product.getQuantity()+1);
		}
		else {
			products.add(p);
		}
	}
}