package pl.edu.agh.dronka.shop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.filter.ItemFilter;

public class Index {

	private List<Item> items = new ArrayList<>();

	private List<Category> categories = new LinkedList<>();

	private Map<Category, Integer> discounts = new HashMap<>();

	public void addItem(Item item) {
		items.add(item);
	}

	public void registerCategory(Category category) {
		categories.add(category);
	}

	public Category getCategory(String name) {
		for (Category category : categories) {
			if (category.getDisplayName().equals(name)) {
				return category;
			}
		}

		return null;
	}

	public List<Category> getCategories() {
		return categories;
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

	public List<Item> getItems(ItemFilter filter) {
		List<Item> result = new LinkedList<>();

		for (Item item : items) {
			if (filter.appliesTo(item)) {
				result.add(item);
			}

		}

		return result;
	}

	public void addDiscount(Category category, int discount) {
		discounts.put(category, discount);
	}

	public int getDiscount(Category category) {
		if (discounts.containsKey(category)) {
			return discounts.get(category);
		}
		return 0;
	}
}
