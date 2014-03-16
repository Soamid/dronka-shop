package pl.edu.agh.dronka.shop.view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Index;
import pl.edu.agh.dronka.shop.model.Item;

public class IndexPanel extends JPanel {

	private static final long serialVersionUID = -4871875393346906351L;

	private JList<Item> itemsList;
	private ShopController shopController;

	public IndexPanel(ShopController shopController) {
		this.shopController = shopController;
		createVisuals();
	}

	public void setIndex(Index itemsIndex) {
		itemsList.setListData(itemsIndex.getFilteredItems().toArray(new Item[0]));
	}

	private void createVisuals() {
		setLayout(new BorderLayout());
		itemsList = new JList<>();

		add(itemsList, BorderLayout.CENTER);

		itemsList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					int index = itemsList.locationToIndex(evt.getPoint());
					Item itemModel = itemsList.getModel().getElementAt(index);
					shopController.chooseItem(itemModel);
				}
			}
		});
	}
}
