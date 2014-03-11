package pl.edu.agh.dronka.shop.controller;

import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.Shop;
import pl.edu.agh.dronka.shop.model.User;
import pl.edu.agh.dronka.shop.view.ShopFrame;

public class ShopController {

	private ShopFrame shopView;

	private Shop shopModel;

	private User currentUser;

	public void logIn(User user) {
		for (User shopUser : shopModel.getRegisteredUsers()) {
			if (shopUser.getName().equals(user.getName())
					&& shopUser.getSurname().equals(user.getSurname())) {
				setCurrentUser(shopUser);
			}
		}
	}

	public void chooseItem(Item item) {
		shopView.displayItem(item);
	}

	public void addToCart(Item item) {
		shopView.getCartPanel().addItem(item);
	}

	public void goToIndex() {
		shopView.displayIndex();
	}

	public void setShopView(ShopFrame shopView) {
		this.shopView = shopView;
	}

	public void setModel(Shop shopModel) {
		this.shopModel = shopModel;
		shopView.getIndexPanel().setItems(shopModel.getItemsIndex());
	}

	private void setCurrentUser(User user) {
		currentUser = user;
		shopView.getCartPanel().setUser(user);
	}

}
