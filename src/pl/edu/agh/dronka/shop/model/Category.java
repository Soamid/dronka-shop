package pl.edu.agh.dronka.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

	// BOOKS("Ksi¹¿ki"), ELECTRONICS("Elektronika"), FOOD("¯ywnoœæ"),
	// MUSIC("Muzyka"), SPORT("Sport");

	private String displayName;

	private List<String> properties = new ArrayList<>();

	private List<String> checkableProperties = new ArrayList<>();

	public Category(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void registerProperty(String property, boolean checkable) {
		properties.add(property);
		if (checkable) {
			checkableProperties.add(property);
		}
	}

	public List<String> getProperties() {
		return new ArrayList<>(properties);
	}
	
	public List<String> getCheckableProperties() {
		return new ArrayList<>(checkableProperties);
	}

}
