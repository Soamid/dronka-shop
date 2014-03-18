package pl.edu.agh.dronka.shop.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Item;

public class PropertiesPanel extends JPanel {

	private static final long serialVersionUID = -2804446079853846996L;
	private ShopController shopController;

	private Item itemSpecification = new Item();

	public PropertiesPanel(ShopController shopController) {
		this.shopController = shopController;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	public void fillProperties() {
		removeAll();

		add(createPropertyCheckbox("Tanie bo polskie", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				itemSpecification.setPolish(((JCheckBox) event.getSource())
						.isSelected());
				shopController.filterItems(itemSpecification);
			}
		}));

		add(createPropertyCheckbox("U¿ywany", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				itemSpecification.setSecondhand(((JCheckBox) event.getSource())
						.isSelected());
				shopController.filterItems(itemSpecification);
			}
		}));

	}

	private JCheckBox createPropertyCheckbox(String propertyName,
			ActionListener actionListener) {

		JCheckBox checkBox = new JCheckBox(propertyName);
		checkBox.setSelected(false);
		checkBox.addActionListener(actionListener);

		return checkBox;
	}

}
