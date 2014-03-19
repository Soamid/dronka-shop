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

		Item item1 = new Item("Telewizor LCD El D¿i", Category.ELECTRONICS, 2000, 10);
		item1.setSecondhand(true);
		items.add(item1);
	
		Item item2 = new Item("Zupa Studencka Instant", Category.FOOD, 2, 100);
		item2.setPolish(true);
		items.add(item2);
		
		Item item3 = new Item("Nowe Przygody Gangu Czworga", Category.BOOKS, 50, 2);
		item3.setPolish(true);
		item3.setSecondhand(true);
		items.add(item3);
		
		Item item4 = new Item(
				"Zamodeluj swoje ¿ycie. Technologie obiektowe for dummies",
				Category.BOOKS, 120, 15);
		items.add(item4);
		
		Item item5 = new Item(
				"When The Smoke is Going Down : Testy wydajnoœciowe w praktyce",
				Category.BOOKS, 90, 3);
		item5.setSecondhand(true);
		items.add(item5);
		
		Item item6 = new Item("Ciley Myrus - Big Ball of Mud", Category.MUSIC, 60, 20);
		item6.setPolish(true);
		items.add(item6);
		
		Item item7 = new Item("Sznycel mro¿ony", Category.FOOD, 6, 30);
		item7.setPolish(true);
		items.add(item7);
		
		Item item8 = new Item("Legendarny Bulbulator", Category.ELECTRONICS,
				99999999, 1);
		items.add(item8);
		
		
		Item item9 = new Item("Narty b³otne (Hit sezonu!!!)", Category.SPORT, 1500, 14);
		item9.setSecondhand(true);
		items.add(item9);

		return items;
	}

	public static void registerExampleCategories(Index index) {
		for (Category category : Category.values()) {
			index.registerCategory(category);
		}
	}

}
