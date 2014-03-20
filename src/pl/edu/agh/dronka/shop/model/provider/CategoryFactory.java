package pl.edu.agh.dronka.shop.model.provider;

import pl.edu.agh.dronka.shop.model.Category;

public class CategoryFactory {

	public Category createBooksCategory() {
		Category bookCategory = createBaseCategory("Ksi¹¿ki");
		bookCategory.registerProperty("Liczba stron", false);
		bookCategory.registerProperty("Twarda oprawa", true);

		return bookCategory;

	}

	public Category createElectronicsCategory() {
		Category bookCategory = createBaseCategory("Elektronika");
		bookCategory.registerProperty("Mobilny", true);
		bookCategory.registerProperty("Gwarancja", true);

		return bookCategory;

	}

	public Category createFoodCategory() {
		return createBaseCategory("¯ywnoœæ");

	}

	public Category createMusicCategory() {
		return createBaseCategory("Muzyka");

	}

	public Category createSportCategory() {
		return createBaseCategory("Sport");

	}

	private Category createBaseCategory(String displayName) {
		Category category = new Category(displayName);
		category.registerProperty("Nazwa", false);
		category.registerProperty("Tanie bo polskie", true);
		category.registerProperty("U¿ywany", true);

		return category;
	}
}
