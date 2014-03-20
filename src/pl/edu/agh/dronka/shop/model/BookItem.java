package pl.edu.agh.dronka.shop.model;

public class BookItem extends Item {

	private int numberOfPages;

	private boolean hardCover;

	public BookItem(String name, int price, int quantity) {
		super(name, Category.BOOKS, price, quantity);
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public boolean isHardCover() {
		return hardCover;
	}

	public void setHardCover(boolean hardCover) {
		this.hardCover = hardCover;
	}
}
