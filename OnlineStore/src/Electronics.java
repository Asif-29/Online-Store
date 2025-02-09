
//@author Md. Asif Hassan | CSE

package OnlineStore;

public class Electronics extends Product { // make this a subclass of Product
	private String manufacturer;
	private ElectCategory subCategory; // Can be String or other data type as well

	// Constructor
	public Electronics(String name, String id, int quantity, String manufacturer, ElectCategory subCategory, double price) {
		super (name,id,Category.Electronics,quantity,price);
		this. manufacturer=manufacturer;
		this.subCategory=subCategory;

	}

	// getter/setter


	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public ElectCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(ElectCategory subCategory) {
		this.subCategory = subCategory;
	}


	// Override the putOnSale method
	// This method will put an item on sale and also set the sale percentage
	// The item id ans sale percentage will be decided by the admin.
	@Override
	public void putOnSale(Object id, int percentage) {
		if (id.equals(this.getId())) {
			this.setSalePercent (percentage);
			this.setOnSale(true);
		}
		else {
			this.setOnSale(false);
		}
	}

	// This details method is for admin user. Admin should be able to see everything.
	public String details() {
		return "Name: "+getName()+"ID: "+getId()+"Price: "+totalPrice(this.getQuantity())+"Category: "+getCategory()+"Quantity: "+getQuantity();
	}
}

enum ElectCategory{
	HOME_APPLIANCE,
	KITCHEN_APPLIANCE,
	ELECTRONIC_DEVICE,
	ELECTRONIC_ACCESSORY
}