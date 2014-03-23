package pl.edu.agh.dronka.shop.model;

import java.util.HashMap;
import java.util.Map;

public class Item {

	private String name;

	private Category category;

	private int price;

	private int quantity;

	private Map<String, Object> propertyValues = new HashMap<>();

	public Item(String name, Category category, int price, int quantity) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}

	public void setPropertyValue(String propertyName, Object propertyValue) {
		propertyValues.put(propertyName, propertyValue);
	}

	public Object getPropertyValue(String propertyName) {
		return propertyValues.get(propertyName);
	}

	public Item() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCategory(Category category) {
		this.category = category;
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
