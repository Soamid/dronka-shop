package pl.edu.agh.dronka.shop.controller;

import java.util.ArrayList;
import java.util.List;

import pl.edu.agh.dronka.shop.model.Item;

public class ItemsFilter {

	private Item itemSpec;

	public void setItemSpecification(Item itemSpec) {
		this.itemSpec = itemSpec;
	}

	public List<Item> filterItems(List<Item> inputItems) {
		List<Item> resultItems = new ArrayList<>();

		for (Item item : inputItems) {
			if (isValidItem(item)) {
				resultItems.add(item);
			}
		}

		return resultItems;
	}

	protected boolean isValidItem(Item item) {
		boolean result = true;

		for (String propertyName : item.getCategory().getCheckableProperties()) {
			result = result
					&& compareValues(
							(boolean) itemSpec.getPropertyValue(propertyName),
							(boolean) item.getPropertyValue(propertyName));
		}
		return result;
	}

	private boolean compareValues(boolean specValue, boolean itemValue) {
		if (specValue == itemValue) {
			return true;
		} else {
			return itemValue;
		}
	}
}
