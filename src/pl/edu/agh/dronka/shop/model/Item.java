package pl.edu.agh.dronka.shop.model;

public class Item {

	private String name;
	
	private Category category;
	
	public Item(String name, Category category) {
		this.name = name;
		this.category = category;
	}

	public String getName() {
		return name;
	}
	
	public Category getCategory() {
		return category;
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
