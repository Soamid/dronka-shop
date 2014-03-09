package pl.edu.agh.dronka.shop.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Item;

public class ItemPanel extends JPanel {

	private static final long serialVersionUID = 7620300297634323349L;

	private JPanel infoPanel;
	private ShopController shopController;

	public ItemPanel(ShopController shopController) {
		this.shopController = shopController;
		createVisuals();
	}

	
	public void setItem(Item item) {
		infoPanel.removeAll();
		createInfoLabel("Name", item.getName());
		createInfoLabel("Category", item.getCategory().toString());
	}
	
	
	private void createVisuals() {
		setLayout(new BorderLayout());

		JPanel outerInfoPanel = new JPanel();
		infoPanel = createInfoPanel(); 
		outerInfoPanel.add(infoPanel);
		
		add(outerInfoPanel, BorderLayout.LINE_START);
		add(createButtonsPanel(), BorderLayout.PAGE_END);
	}

	private Component createButtonsPanel() {
		JPanel buttonsPanel = new JPanel();

		JButton backButton = new JButton("Back");
		JButton addToCartButton = new JButton("Add to cart");

		buttonsPanel.add(backButton);
		buttonsPanel.add(addToCartButton);
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				shopController.goToIndex();
			}
		});

		return buttonsPanel;
	}

	private JPanel createInfoPanel() {
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(0, 2, 40, 5));
		
		return infoPanel;
	}
	
	private void createInfoLabel(String name, String value) {
		infoPanel.add(new JLabel(name + ":"));
		infoPanel.add(new JLabel(value));
	}
}
