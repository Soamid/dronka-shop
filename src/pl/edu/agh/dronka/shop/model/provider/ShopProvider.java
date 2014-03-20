package pl.edu.agh.dronka.shop.model.provider;

import java.util.ArrayList;
import java.util.List;

import pl.edu.agh.dronka.shop.model.BookItem;
import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.ElectronicsItem;
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

		ElectronicsItem item1 = new ElectronicsItem("Telewizor LCD El D¿i",
				2000, 10);
		item1.setSecondhand(true);
		item1.setHasWarranty(true);
		items.add(item1);

		Item item2 = new Item("Zupa Studencka Instant", Category.FOOD, 2, 100);
		item2.setPolish(true);
		items.add(item2);

		BookItem item3 = new BookItem("Nowe Przygody Gangu Czworga", 50, 2);
		item3.setPolish(true);
		item3.setSecondhand(true);
		item3.setHardCover(true);
		item3.setNumberOfPages(500);
		items.add(item3);

		BookItem item4 = new BookItem(
				"Zamodeluj swoje ¿ycie. Technologie obiektowe for dummies",
				120, 15);
		item4.setNumberOfPages(250);
		items.add(item4);

		BookItem item5 = new BookItem(
				"When The Smoke is Going Down : Testy wydajnoœciowe w praktyce",
				90, 3);
		item5.setSecondhand(true);
		item5.setHardCover(true);
		item5.setNumberOfPages(2000);
		items.add(item5);

		Item item6 = new Item("Ciley Myrus - Big Ball of Mud", Category.MUSIC,
				60, 20);
		item6.setPolish(true);
		items.add(item6);

		Item item7 = new Item("Sznycel mro¿ony", Category.FOOD, 6, 30);
		item7.setPolish(true);
		items.add(item7);

		ElectronicsItem item8 = new ElectronicsItem("Legendarny Bulbulator",
				99999999, 1);
		item8.setMobile(true);
		items.add(item8);

		Item item9 = new Item("Narty b³otne (Hit sezonu!!!)", Category.SPORT,
				1500, 14);
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
