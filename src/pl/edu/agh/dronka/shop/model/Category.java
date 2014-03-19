package pl.edu.agh.dronka.shop.model;

public enum Category {

	BOOKS("Ksi��ki"), ELECTRONICS("Elektronika"), FOOD("�ywno��"), MUSIC("Muzyka"), SPORT("Sport");

	private String displayName;

	public String getDisplayName() {
		return displayName;
	}

	private Category(String displayName) {
		this.displayName = displayName;
	}
}
