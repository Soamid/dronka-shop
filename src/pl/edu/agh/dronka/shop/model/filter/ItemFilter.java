package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.PropertyType;

public class ItemFilter {

	private Item itemSpec = new Item();

	public Item getItemSpec() {
		return itemSpec;
	}

	public boolean appliesTo(Item item) {
		if (itemSpec.getName() != null
				&& !itemSpec.getName().equals(item.getName())) {
			return false;
		}
		if (itemSpec.getCategory() != null
				&& !itemSpec.getCategory().equals(item.getCategory())) {
			return false;
		}

		for (String propertyName : item.getCategory().getProperties(
				PropertyType.BOOLEAN)) {

			boolean itemSpecValue = (boolean) itemSpec
					.getPropertyValue(propertyName);
			boolean itemValue = (boolean) item.getPropertyValue(propertyName);

			if (itemSpecValue && !itemValue) {
				return false;
			}
		}

		return true;
	}

}