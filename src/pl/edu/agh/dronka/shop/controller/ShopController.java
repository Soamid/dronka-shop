package pl.edu.agh.dronka.shop.controller;
import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Index;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.Shop;
import pl.edu.agh.dronka.shop.model.User;
import pl.edu.agh.dronka.shop.view.ProductsPanel;
import pl.edu.agh.dronka.shop.view.ShopFrame;

public class ShopController {

	private ShopFrame shopView;
	
	private ProductsPanel categoryView;

	private Shop shopModel;

	private User currentUser;

	private Category currentCategory;

	private ItemsFilter itemsFilter = new ItemsFilter();

	public void logIn(User user) {
		for (User shopUser : shopModel.getRegisteredUsers()) {
			if (shopUser.getName().equals(user.getName())
					&& shopUser.getSurname().equals(user.getSurname())) {
				setCurrentUser(shopUser);
			}
		}
	}

	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}

	public Category getCurrentCategory() {
		return currentCategory;
	}

	public void chooseItem(Item item) {
		categoryView.displayItem(item);
	}

	public void addToCart(Item item) {
		categoryView.getCartPanel().addItem(item);
	}

	public void goToIndex() {
		categoryView.displayIndex();
	}

	public void setShopView(ShopFrame shopFrame) {
		this.shopView = shopFrame;
	}
	
	public void setCategoryView(ProductsPanel categoryPanel) {
		this.categoryView = categoryPanel;
	}

	public void setModel(Shop shopModel) {
		this.shopModel = shopModel;
		refreshIndexView();
	}
	
	public void showProducts(Category category) {
		shopView.displayProducts(category);
		refreshIndexView();
		
	}

	public void refreshIndexView() {
		categoryView.getItemPanel().setIndex(shopModel.getItemsIndex());
	}

	public void filterItems(Item itemSpecification) {
		itemsFilter.setItemSpecification(itemSpecification);
		Index itemsIndex = shopModel.getItemsIndex();
		categoryView.getIndexPanel().setItems(
				itemsFilter.filterItems(itemsIndex
						.getItems(getCurrentCategory())));

	}

	private void setCurrentUser(User user) {
		currentUser = user;
		categoryView.getCartPanel().setUser(user);
	}

}
