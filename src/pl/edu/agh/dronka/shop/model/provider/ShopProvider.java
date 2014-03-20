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
		registerExampleCategories(itemsIndex);

		for (Item item : getExampleItems(itemsIndex)) {
			itemsIndex.addItem(item);
		}

		shop.setItemsIndex(itemsIndex);

		return shop;
	}

	public static User getExampleUser() {
		return new User("Jan", "Rejnor");
	}

	public static List<Item> getExampleItems(Index itemsIndex) {
		List<Item> items = new ArrayList<>();

		Category booksCategory = itemsIndex.getCategory("Ksi¹¿ki");
		Category electronicsCategory = itemsIndex.getCategory("Elektronika");
		Category foodCategory = itemsIndex.getCategory("¯ywnoœæ");
		Category musicCategory = itemsIndex.getCategory("Muzyka");
		Category sportCategory = itemsIndex.getCategory("Sport");

		Item item1 = new Item("Telewizor LCD El D¿i", electronicsCategory,
				2000, 10);
		item1.setPropertyValue("U¿ywany", true);
		item1.setPropertyValue("Tanie bo polskie", false);
		item1.setPropertyValue("Mobilny", false);
		item1.setPropertyValue("Gwarancja", true);
		items.add(item1);

		Item item2 = new Item("Zupa Studencka Instant", foodCategory, 2, 100);
		item2.setPropertyValue("U¿ywany", false);
		item2.setPropertyValue("Tanie bo polskie", true);
		items.add(item2);

		Item item3 = new Item("Nowe Przygody Gangu Czworga", booksCategory, 50,
				2);
		item3.setPropertyValue("Tanie bo polskie", true);
		item3.setPropertyValue("U¿ywany", true);
		item3.setPropertyValue("Twarda oprawa", true);
		item3.setPropertyValue("Liczba stron", 500);
		items.add(item3);

		Item item4 = new Item(
				"Zamodeluj swoje ¿ycie. Technologie obiektowe for dummies",
				booksCategory, 120, 15);
		item4.setPropertyValue("U¿ywany", false);
		item4.setPropertyValue("Tanie bo polskie", false);
		item4.setPropertyValue("Twarda oprawa", false);
		item4.setPropertyValue("Liczba stron", 200);
		items.add(item4);

		Item item5 = new Item(
				"When The Smoke is Going Down : Testy wydajnoœciowe w praktyce",
				booksCategory, 90, 3);
		item5.setPropertyValue("U¿ywany", true);
		item5.setPropertyValue("Tanie bo polskie", false);;
		item5.setPropertyValue("Twarda oprawa", true);
		item5.setPropertyValue("Liczba stron", 2000);
		items.add(item5);

		Item item6 = new Item("Ciley Myrus - Big Ball of Mud", musicCategory,
				60, 20);
		item6.setPropertyValue("U¿ywany", false);
		item6.setPropertyValue("Tanie bo polskie", true);
		items.add(item6);

		Item item7 = new Item("Sznycel mro¿ony", foodCategory, 6, 30);
		item7.setPropertyValue("U¿ywany", false);
		item7.setPropertyValue("Tanie bo polskie", true);
		items.add(item7);

		Item item8 = new Item("Legendarny Bulbulator", electronicsCategory,
				99999999, 1);
		item8.setPropertyValue("U¿ywany", false);
		item8.setPropertyValue("Tanie bo polskie", false);
		item8.setPropertyValue("Mobilny", true);
		item8.setPropertyValue("Gwarancja", false);
		items.add(item8);

		Item item9 = new Item("Narty b³otne (Hit sezonu!!!)", sportCategory,
				1500, 14);
		item9.setPropertyValue("U¿ywany", true);
		item9.setPropertyValue("Tanie bo polskie", false);
		items.add(item9);

		return items;
	}

	public static void registerExampleCategories(Index index) {
		CategoryFactory categoryFactory = new CategoryFactory();
		index.registerCategory(categoryFactory.createBooksCategory());
		index.registerCategory(categoryFactory.createElectronicsCategory());
		index.registerCategory(categoryFactory.createFoodCategory());
		index.registerCategory(categoryFactory.createMusicCategory());
		index.registerCategory(categoryFactory.createSportCategory());
	}

}
