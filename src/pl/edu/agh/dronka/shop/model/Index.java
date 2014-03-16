package pl.edu.agh.dronka.shop.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Index {

	private List<Item> items = new ArrayList<>();

	private Map<Category, String> categories = new LinkedHashMap<>();

	private Set<Category> skippedCategories = new HashSet<>();

	public void addItem(Item item) {
		items.add(item);
	}

	public void registerCategory(Category category, String name) {
		categories.put(category, name);
	}

	public List<Item> getItems() {
		return new ArrayList<>(items);
	}
	
	public List<Category> getRegisteredCategories() {
		return new ArrayList<>(categories.keySet());
	}
	
	public String getCategoryName(Category category) {
		return categories.get(category);
	}

	public void setSkippedCategories(Set<Category> skippedCategories) {
		this.skippedCategories = skippedCategories;
	}

	public List<Item> getFilteredItems() {
		List<Item> resultItems = new ArrayList<>();
		for (Item item : items) {
			if (!skippedCategories.contains(item.getCategory())) {
				resultItems.add(item);
			}
		}

		return resultItems;
	}
}
