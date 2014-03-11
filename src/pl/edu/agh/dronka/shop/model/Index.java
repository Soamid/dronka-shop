package pl.edu.agh.dronka.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Index {

	private List<Item> items = new ArrayList<>();
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public List<Item> getItems() {
		return new ArrayList<>(items);
	}
}
