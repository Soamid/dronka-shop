package pl.edu.agh.dronka.shop.model;

public enum Category {

	BOOKS("Ksi��ki"), ELECTRONICS("Elektronika"), FOOD("�ywno��"), MUSIC(
			"Muzyka"), SPORT("Sport");

	private String displayName;

	private int discount;

	public String getDisplayName() {
		return displayName;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getDiscount() {
		return discount;
	}

	private Category(String displayName) {
		this.displayName = displayName;
	}
}
