package pl.edu.agh.dronka.shop.model;

import java.util.HashMap;
import java.util.Map;

public class Item {


	private Map<String, Object> propertyValues = new HashMap<>();



	public Item(String name, Category category, int price, int quantity) {
		setPropertyValue("Nazwa", name);
		setPropertyValue("Kategoria", category);
		setPropertyValue("Cena", price);
		setPropertyValue("Iloœæ", quantity);
	}

	public void setPropertyValue(String propertyName, Object propertyValue) {
		// TODO walidacja czy jest property istnieje w kategorii
		propertyValues.put(propertyName, propertyValue);
	}

	public Object getPropertyValue(String propertyName) {
		return propertyValues.get(propertyName);
	}

	public Item() {
	}

	public String getName() {
		return (String) getPropertyValue("Nazwa");
	}

	public Category getCategory() {
		return (Category) getPropertyValue("Kategoria");
	}

	public int getPrice() {
		return (int) getPropertyValue("Cena");
	}

	public int getQuantity() {
		return (int) getPropertyValue("Iloœæ");
	}

	@Override
	public String toString() {
		return getName();
	}
}
