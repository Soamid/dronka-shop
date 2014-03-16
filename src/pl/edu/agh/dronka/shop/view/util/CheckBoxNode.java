package pl.edu.agh.dronka.shop.view.util;

public class CheckBoxNode {
	private String text;

	private boolean selected;

	private Object data;

	public CheckBoxNode(String text, Object data,  boolean selected) {
		this.text = text;
		this.selected = selected;
		this.data =data;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean newValue) {
		selected = newValue;
	}

	public String getText() {
		return text;
	}

	public void setText(String newValue) {
		text = newValue;
	}
	
	public Object getData() {
		return data;
	}

	public String toString() {
		return getClass().getName() + "[" + text + "/" + selected + "]";
	}
}