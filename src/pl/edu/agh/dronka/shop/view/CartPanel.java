package pl.edu.agh.dronka.shop.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.User;

public class CartPanel extends JPanel {

	private static final long serialVersionUID = 1619310843639460294L;

	private ShopController shopController;
	private JLabel summaryValueLabel;
	private JTable cartTable;

	private List<Item> cartItems = new ArrayList<>();

	private CartTableModel cartTableModel;

	private JLabel userValueLabel;

	public CartPanel(ShopController shopController) {
		this.shopController = shopController;
		createVisuals();
	}

	public void setUser(User user) {
		userValueLabel.setText(user.getName() + " " + user.getSurname());
	}

	public void addItem(Item item) {
		cartItems.add(item);
		cartTableModel.fireTableDataChanged();
		refreshSummary();
	}


	private void createVisuals() {
		setLayout(new BorderLayout());
		JPanel userPanel = createUserPanel();
		cartTable = createItemsCartPanel();
		JPanel buttonsPanel = createButtonsPanel();
		JPanel summaryPanel =  createSummaryPanel();

		add(userPanel, BorderLayout.PAGE_START);
		
		JPanel itemsPanel = new JPanel();
		itemsPanel.setLayout(new BorderLayout());
		
		itemsPanel.add(cartTable, BorderLayout.CENTER);
		itemsPanel.add(summaryPanel, BorderLayout.PAGE_END);
		
		add(itemsPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.PAGE_END);
	}

	private JPanel createButtonsPanel() {
		JPanel buttonsPanel = new JPanel();

		JButton backButton = new JButton("Powr�t");
		JButton buyButton = new JButton("Kup!");

		buttonsPanel.add(backButton);
		buttonsPanel.add(buyButton);

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				shopController.showCategories();
			}
		});

		buyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cartItems.clear();
				cartTableModel.fireTableDataChanged();
			}
		});

		return buttonsPanel;
	}

	private JPanel createUserPanel() {
		JPanel userPanel = new JPanel();
		JLabel userLabel = new JLabel("U�ytkownik:");
		userValueLabel = new JLabel();

		userPanel.add(userLabel);
		userPanel.add(userValueLabel);
		return userPanel;
	}
	
	private JPanel createSummaryPanel() {
		JPanel summaryPanel = new JPanel();
		JLabel summaryLabel = new JLabel("��czna kwota:");
		summaryValueLabel = new JLabel();

		summaryPanel.add(summaryLabel);
		summaryPanel.add(summaryValueLabel);
		return summaryPanel;
	}

	private JTable createItemsCartPanel() {
		cartTableModel = new CartTableModel(cartItems);
		JTable table = new JTable(cartTableModel);
		return table;
	}
	
	private void refreshSummary() {
		int sum = 0;
		for(Item item : cartItems) {
			sum += item.getPrice();
		}
		summaryValueLabel.setText(Integer.toString(sum));
	}

	private class CartTableModel extends AbstractTableModel {

		private static final long serialVersionUID = -3876832621582015355L;

		private List<Item> cartItems;

		public CartTableModel(List<Item> cartItems) {
			this.cartItems = cartItems;
		}

		@Override
		public String getColumnName(int column) {
			if (column == 0) {
				return "Item";
			}
			return "Price";

		}

		@Override
		public int getColumnCount() {
			return 2;
		}

		@Override
		public int getRowCount() {
			return cartItems.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			if (columnIndex == 0) {
				return cartItems.get(rowIndex).getName();
			} else {
				return cartItems.get(rowIndex).getPrice();
			}
		}

	}

}
