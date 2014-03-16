package pl.edu.agh.dronka.shop.model;

public class Item {

	private String name;
	
	private Category category;
	
	private int price;
	
	private int quantity;
	
	public Item(String name, Category category, int price, int quantity) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
