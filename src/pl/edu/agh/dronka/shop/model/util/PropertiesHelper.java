package pl.edu.agh.dronka.shop.model.util;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.Item;

public class PropertiesHelper {

	public static Map<String, Object> getPropertiesMap(Item item) {
		Map<String, Object> propertiesMap = new LinkedHashMap<>();
		
		propertiesMap.put("Name", item.getName());
		propertiesMap.put("Price", item.getPrice());
		propertiesMap.put("Category", item.getCategory().getDisplayName()); 
		propertiesMap.put("Quantity", Integer.toString(item.getQuantity()));
		propertiesMap.put("Polish", item.isPolish());
		propertiesMap.put("Secondhand", item.isSecondhand());
		
		return propertiesMap;
	}
}
