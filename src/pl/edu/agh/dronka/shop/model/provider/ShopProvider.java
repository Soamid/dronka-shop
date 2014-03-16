package pl.edu.agh.dronka.shop.model.provider;

import java.util.ArrayList;
import java.util.List;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Index;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.Shop;
import pl.edu.agh.dronka.shop.model.User;

public class ShopProvider {

	public static Shop getExampleShop() {
		Shop shop = new Shop();

		shop.addUser(getExampleUser());

		Index itemsIndex = new Index();

		for (Item item : getExampleItems()) {
			itemsIndex.addItem(item);
		}

		registerExampleCategories(itemsIndex);
		shop.setItemsIndex(itemsIndex);

		return shop;
	}

	public static User getExampleUser() {
		return new User("Jan", "Rejnor");
	}

	public static List<Item> getExampleItems() {
		List<Item> items = new ArrayList<>();

		items.add(new Item("Telewizor LCD El D¿i", Category.ELECTRONICS, 2000, 10));
		items.add(new Item("Zupa Studencka Instant", Category.FOOD, 2, 100));
		items.add(new Item("Nowe Przygody Gangu Czworga", Category.BOOKS, 50, 2));
		items.add(new Item(
				"Zamodeluj swoje ¿ycie. Technologie obiektowe for dummies",
				Category.BOOKS, 120, 15));
		items.add(new Item(
				"When The Smoke is Going Down : Testy wydajnoœciowe w praktyce",
				Category.BOOKS, 90, 3));
		items.add(new Item("Ciley Myrus - Big Ball of Mud", Category.MUSIC, 60, 20));
		items.add(new Item("Sznycel mro¿ony", Category.FOOD, 6, 30));
		items.add(new Item("Legendarny Bulbulator", Category.ELECTRONICS,
				99999999, 1));
		items.add(new Item("Narty b³otne (Hit sezonu!!!)", Category.SPORT, 1500, 14));

		return items;
	}

	public static void registerExampleCategories(Index index) {
		index.registerCategory(Category.BOOKS, "Ksi¹¿ki");
		index.registerCategory(Category.ELECTRONICS, "Elektronika");
		index.registerCategory(Category.FOOD, "¯ywnoœæ");
		index.registerCategory(Category.MUSIC, "Muzyka");
		index.registerCategory(Category.SPORT, "Sport");
	}
}
