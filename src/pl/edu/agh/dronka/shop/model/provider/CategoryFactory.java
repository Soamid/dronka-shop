package pl.edu.agh.dronka.shop.model.provider;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.PropertyType;

public class CategoryFactory {

	public Category createBooksCategory() {
		Category bookCategory = createBaseCategory("Książki");
		bookCategory.registerProperty("Liczba stron", PropertyType.INTEGER);
		bookCategory.registerProperty("Twarda oprawa", PropertyType.BOOLEAN);

		return bookCategory;

	}

	public Category createElectronicsCategory() {
		Category bookCategory = createBaseCategory("Elektronika");
		bookCategory.registerProperty("Mobilny", PropertyType.BOOLEAN);
		bookCategory.registerProperty("Gwarancja", PropertyType.BOOLEAN);

		return bookCategory;

	}

	public Category createFoodCategory() {
		return createBaseCategory("Żywność");

	}

	public Category createMusicCategory() {
		return createBaseCategory("Muzyka");

	}

	public Category createSportCategory() {
		return createBaseCategory("Sport");

	}

	private Category createBaseCategory(String displayName) {
		Category category = new Category(displayName);
		category.registerProperty("Tanie bo polskie", PropertyType.BOOLEAN);
		category.registerProperty("Używany", PropertyType.BOOLEAN);

		return category;
	}
}
