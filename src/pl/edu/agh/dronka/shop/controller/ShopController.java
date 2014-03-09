package pl.edu.agh.dronka.shop.controller;

import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.view.ShopFrame;

public class ShopController {
	
	private ShopFrame shopView;

	public void chooseItem(Item item) {
		shopView.displayItem(item);
	}
	
	public void goToIndex() {
		shopView.displayIndex();
	}
	
	public void setShopView(ShopFrame shopView) {
		this.shopView = shopView;
	}

}
