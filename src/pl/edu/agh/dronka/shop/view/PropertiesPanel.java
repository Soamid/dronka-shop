package pl.edu.agh.dronka.shop.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.PropertyType;
import pl.edu.agh.dronka.shop.model.filter.ItemFilter;

public class PropertiesPanel extends JPanel {

	private static final long serialVersionUID = -2804446079853846996L;
	private ShopController shopController;

	private ItemFilter itemFilter = new ItemFilter();

	public PropertiesPanel(ShopController shopController) {
		this.shopController = shopController;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	public void fillProperties() {
		removeAll();

		Category category = shopController.getCurrentCategory();
		itemFilter.getItemSpec().setCategory(category);

		for (final String propertyName : category
				.getProperties(PropertyType.BOOLEAN)) {
			itemFilter.getItemSpec().setPropertyValue(propertyName, false);
			add(createPropertyCheckbox(propertyName, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					itemFilter.getItemSpec().setPropertyValue(propertyName,
							((JCheckBox) event.getSource()).isSelected());
					shopController.filterItems(itemFilter);
				}
			}));
		}

	}

	private JCheckBox createPropertyCheckbox(String propertyName,
			ActionListener actionListener) {

		JCheckBox checkBox = new JCheckBox(propertyName);
		checkBox.setSelected(false);
		checkBox.addActionListener(actionListener);

		return checkBox;
	}

}
