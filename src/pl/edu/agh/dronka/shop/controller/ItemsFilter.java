package pl.edu.agh.dronka.shop.controller;

import java.util.ArrayList;
import java.util.List;

import pl.edu.agh.dronka.shop.model.Item;

public class ItemsFilter {

	private Item itemSpec;


	public void setItemSpecification(Item itemSpec) {
		this.itemSpec = itemSpec;
	}
	
	
	public List<Item> filterItems(List<Item> inputItems) {
		List<Item> resultItems = new ArrayList<>();
		
		for(Item item: inputItems) {
			if(isValidItem(item)) {
				resultItems.add(item);
			}
		}
		
		return resultItems;
	}
	
	protected boolean isValidItem(Item item) {
		return itemSpec.isPolish() == item.isPolish() && itemSpec.isSecondhand() == item.isSecondhand();
	}
} 
