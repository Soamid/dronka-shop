package pl.edu.agh.dronka.shop.model;

public class ElectronicsItem extends Item {

	private boolean isMobile;

	private boolean hasWarranty;

	public ElectronicsItem(String name, int price, int quantity) {
		super(name, Category.ELECTRONICS, price, quantity);
	}

	public boolean isMobile() {
		return isMobile;
	}

	public void setMobile(boolean isMobile) {
		this.isMobile = isMobile;
	}

	public boolean hasWarranty() {
		return hasWarranty;
	}

	public void setHasWarranty(boolean hasWarranty) {
		this.hasWarranty = hasWarranty;
	}
}
