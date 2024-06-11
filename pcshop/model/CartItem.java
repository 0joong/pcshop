package pcshop.model;

import pcshop.model.product.Product;

public class CartItem {
	Product product;
	String name;
	int quantity;
	int productCode;
	
	public CartItem(Product product) {
		this.product = product;
		this.name = product.getName();
		this.quantity = 1;
		this.productCode = product.getProductCode();
	}

	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void addQuantity(int quantity) {
		this.quantity += quantity;
		
	}

	@Override
	public String toString() {
		return product.getName() + ", "+ getPrice() + "원";
	}

	public int getPrice() {
		return quantity * product.getPrice();
	}
	
	
}
