package pl.edu.agh.dronka.shop.model.provider;

import java.io.IOException;
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

		Category booksCategory = itemsIndex.getCategory("Książki");
		CSVReader booksReader = new CSVReader("resources/books.csv");
		items.addAll(readItems(booksReader, booksCategory));

		Category electronicsCategory = itemsIndex.getCategory("Elektronika");
		CSVReader electronicsReader = new CSVReader("resources/electronics.csv");
		items.addAll(readItems(electronicsReader, electronicsCategory));

		Category foodCategory = itemsIndex.getCategory("Żywność");
		CSVReader foodReader = new CSVReader("resources/food.csv");
		items.addAll(readItems(foodReader, foodCategory));

		Category musicCategory = itemsIndex.getCategory("Muzyka");
		CSVReader musicReader = new CSVReader("resources/music.csv");
		items.addAll(readItems(musicReader, musicCategory));

		Category sportCategory = itemsIndex.getCategory("Sport");
		CSVReader sportReader = new CSVReader("resources/sport.csv");
		items.addAll(readItems(sportReader, sportCategory));

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

	private static List<Item> readItems(CSVReader reader, Category category) {
		List<Item> items = new ArrayList<>();

		try {
			reader.parse();
			List<String[]> data = reader.getData();

			for (String[] dataLine : data) {
				String name = reader.getValue(dataLine, "Nazwa");
				int price = Integer.parseInt(reader.getValue(dataLine, "Cena"));
				int quantity = Integer.parseInt(reader.getValue(dataLine,
						"Ilość"));

				Item item = new Item(name, category, price, quantity);

				for (String property : category.getProperties()) {
					String propertyText = reader.getValue(dataLine, property);
					Object propertyValue;
					switch (category.getPropertyType(property)) {
					case BOOLEAN:
						propertyValue = Boolean.parseBoolean(propertyText);
						break;
					case INTEGER:
						propertyValue = Integer.parseInt(propertyText);
						break;
					default:
						propertyValue = propertyText;
					}
					item.setPropertyValue(property, propertyValue);
				}

				items.add(item);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return items;
	}

}
