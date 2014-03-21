package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

public class ItemFilter {

	private String name;

	private Category category;

	private boolean secondHand;

	private boolean polish;

	private ItemFilter(Builder b) {
		this.name = b.name;
		this.category = b.category;
		this.secondHand = b.secondHand;
		this.polish = b.polish;
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public Boolean isSecondHand() {
		return secondHand;
	}

	public Boolean isPolish() {
		return polish;
	}

	public boolean appliesTo(Item item) {
		if (name != null && !name.equals(item.getName())) {
			return false;
		}
		if (category != null && !category.equals(item.getCategory())) {
			return false;
		}
		
		// applies filter only if the flag (secondHand) is true)
		if (secondHand && !item.isSecondhand()) {
			return false;
		}
		
		// applies filter only if the flag (polish) is true)
		if (polish && !item.isPolish()) {
			return false;
		}

		return true;
	}

	public static class Builder {

		private String name;

		private Category category;

		private boolean secondHand;

		private boolean polish;

		public Builder() {

		}
		
		public Builder(ItemFilter prototype) {
			name = prototype.getName();
			category = prototype.getCategory();
			secondHand = prototype.isSecondHand();
			polish = prototype.isPolish();
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder category(Category category) {
			this.category = category;
			return this;
		}

		public Builder secondHand(boolean secondHand) {
			this.secondHand = secondHand;
			return this;
		}

		public Builder polish(boolean polish) {
			this.polish = polish;
			return this;
		}

		public ItemFilter build() {
			return new ItemFilter(this);
		}

	}

}