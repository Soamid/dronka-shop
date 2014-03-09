package pl.edu.agh.dronka.shop.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Item;

public class ShopFrame extends JFrame {

	private static final long serialVersionUID = 6578553391433363839L;

	private static final String ITEM_PANEL = "Item Panel";
	
	private static final String INDEX_PANEL = "Index Panel";
	
	
	private CardLayout mainPanelLayout;

	private JPanel mainPanel;

	private CategoryPanel categoryPanel;

	private ItemPanel itemPanel;

	private IndexPanel indexPanel;

	private ShopController shopController;
 
	public ShopFrame(ShopController shopController) {
		
		this.shopController = shopController;
		shopController.setShopView(this);
		
		createVisuals();
		
		setTitle("Dronka Shop");
		setSize(500, 300);
	}
	
	private void createVisuals() {
		
		BorderLayout layout = new BorderLayout();
		layout.setHgap(10);
		setLayout(layout);
		
		mainPanel = createMainPanel();
		categoryPanel = new CategoryPanel();
		
		add(categoryPanel, BorderLayout.LINE_START);
		add(createCartPanel(), BorderLayout.PAGE_START);
		add(mainPanel, BorderLayout.CENTER);
		
		
	}
	
	private JPanel createCartPanel() {
		JPanel cartPanel = new JPanel();
		cartPanel.setLayout(new BorderLayout());
		
		JButton cartButton = new JButton("Cart");
		cartPanel.add(cartButton, BorderLayout.LINE_END);
		
		return cartPanel;
		
	}
	
	private JPanel createMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanelLayout = new CardLayout();
		mainPanel.setLayout(mainPanelLayout);
		
		itemPanel = new ItemPanel(shopController);
		indexPanel = new IndexPanel(shopController);
		
		mainPanel.add(itemPanel, ITEM_PANEL);
		mainPanel.add(indexPanel, INDEX_PANEL);
		
		mainPanelLayout.show(mainPanel, INDEX_PANEL);
		
		return mainPanel;
	}

	public void displayItem(Item item) {
		mainPanelLayout.show(mainPanel, ITEM_PANEL);
		itemPanel.setItem(item);
	}

	public void displayIndex() {
		mainPanelLayout.show(mainPanel, INDEX_PANEL);
	}
}
