package pl.edu.agh.dronka.shop.model;

public class Item {

	private String name;
	
	private Category category;
	
	private int price;
	
	public Item(String name, Category category, int price) {
		this.name = name;
		this.category = category;
		this.price = price;
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
	
	@Override
	public String toString() {
		return getName();
	}
}
