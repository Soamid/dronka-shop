package pl.edu.agh.dronka.shop.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Index {

	private List<Item> items = new ArrayList<>();

	private Map<Category, String> categories = new LinkedHashMap<>();

	public void addItem(Item item) {
		items.add(item);
	}

	public void registerCategory(Category category, String name) {
		categories.put(category, name);
	}

	public List<Item> getItems() {
		return new ArrayList<>(items);
	}

	public List<Item> getItems(Category category) {
		List<Item> categoryItems = new ArrayList<>();

		for (Item item : items) {
			if (item.getCategory().equals(category)) {
				categoryItems.add(item);
			}
		}

		return categoryItems;
	}

	public List<Category> getRegisteredCategories() {
		return new ArrayList<>(categories.keySet());
	}

	public String getCategoryName(Category category) {
		return categories.get(category);
	}

}
