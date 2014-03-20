package pl.edu.agh.dronka.shop.model.provider;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.BookItem;
import pl.edu.agh.dronka.shop.model.ElectronicsItem;
import pl.edu.agh.dronka.shop.model.Item;

public class PropertiesHelper {

	public static Map<String, Object> getPropertiesMap(Item item) {
		Map<String, Object> propertiesMap = new LinkedHashMap<>();

		propertiesMap.put("Nazwa", item.getName());
		propertiesMap.put("Kategoria", item.getCategory().getDisplayName());
		propertiesMap.put("Iloœæ", Integer.toString(item.getQuantity()));
		propertiesMap.put("Tanie bo polskie", item.isPolish());
		propertiesMap.put("U¿ywany", item.isSecondhand());

		if (item instanceof BookItem) {
			BookItem bookItem = (BookItem) item;
			propertiesMap.put("Liczba stron", bookItem.getNumberOfPages());
			propertiesMap.put("Twarda oprawa", bookItem.isHardCover());
		} else if (item instanceof ElectronicsItem) {
			ElectronicsItem electronicsItem = (ElectronicsItem) item;
			propertiesMap.put("Mobilny", electronicsItem.isMobile());
			propertiesMap.put("Gwarancja", electronicsItem.hasWarranty());
		}

		return propertiesMap;
	}
}
