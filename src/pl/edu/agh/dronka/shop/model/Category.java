package pl.edu.agh.dronka.shop.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Category {

	private String displayName;

	private Map<String, PropertyType> properties = new LinkedHashMap<>();

	public Category(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void registerProperty(String property, PropertyType type) {
		properties.put(property, type);
	}

	public PropertyType getPropertyType(String propertyName) {
		return properties.get(propertyName);
	}
	
	public List<String> getProperties() {
		return new ArrayList<>(properties.keySet());
	}

	public List<String> getProperties(PropertyType type) {
		List<String> filteredProperties = new ArrayList<>();
		for (String property : properties.keySet()) {
			if (properties.get(property).equals(type)) {
				filteredProperties.add(property);
			}
		}
		return filteredProperties;
	}

}
