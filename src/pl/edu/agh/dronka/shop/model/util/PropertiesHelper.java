package pl.edu.agh.dronka.shop.model.util;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.Item;

public class PropertiesHelper {

	public static Map<String, Object> getPropertiesMap(Item item) {
		Map<String, Object> propertiesMap = new LinkedHashMap<>();

		propertiesMap.put("Nazwa", item.getName());
		propertiesMap.put("Cena", item.getPrice());
		propertiesMap.put("Kategoria", item.getCategory().getDisplayName());
		propertiesMap.put("Ilość", Integer.toString(item.getQuantity()));
		
		for (String displayName : item.getCategory().getProperties()) {
			propertiesMap.put(displayName, item.getPropertyValue(displayName)
					.toString());
		}

		return propertiesMap;
	}
}
