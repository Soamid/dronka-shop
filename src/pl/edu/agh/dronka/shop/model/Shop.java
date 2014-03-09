package pl.edu.agh.dronka.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Shop {

	private List<User> registeredUsers = new ArrayList<>();
	
	private Index itemsIndex;
	
	
	public void addUser(User user) {
		registeredUsers.add(user);
	}
	
	public List<User> getRegisteredUsers() {
		return new ArrayList<>(registeredUsers);
	}
	
	public void setItemsIndex(Index itemsIndex) {
		this.itemsIndex = itemsIndex;
	}
	
	public Index getItemsIndex() {
		return itemsIndex;
	}
}
