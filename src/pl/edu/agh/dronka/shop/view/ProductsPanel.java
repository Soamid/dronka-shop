package pl.edu.agh.dronka.shop.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Item;

public class ProductsPanel extends JPanel {

	private static final long serialVersionUID = 717323868233576963L;
	
	private static final String ITEM_PANEL = "Item Panel";
	
	private static final String INDEX_PANEL = "Index Panel";

	private static final String CART_PANEL = "Cart Panel";
	
	
	private CardLayout mainPanelLayout;

	private JPanel mainPanel;

	private PropertiesPanel propertiesPanel;

	private ItemPanel itemPanel;

	private IndexPanel indexPanel;

	private ShopController shopController;

	private CartPanel cartPanel;
 
	public ProductsPanel(ShopController shopController) {
		
		this.shopController = shopController;
		shopController.setCategoryView(this);
		
		createVisuals();
		

	}
	
	public void displayItem(Item item) {
		displayPanel(ITEM_PANEL);
		itemPanel.setItem(item);
	}

	public void displayIndex() {
		displayPanel(INDEX_PANEL);
	}
	
	public CartPanel getCartPanel() {
		return cartPanel;
	}
	
	public IndexPanel getIndexPanel() {
		return indexPanel;
	}
	
	public PropertiesPanel getPropertiesPanel() {
		return propertiesPanel;
	}
	
	public ItemPanel getItemPanel() {
		return itemPanel;
	}
	
	private void createVisuals() {
		
		BorderLayout layout = new BorderLayout();
		layout.setHgap(10);
		setLayout(layout);
		
		mainPanel = createMainPanel();
		propertiesPanel = new PropertiesPanel(shopController);
		
		add(propertiesPanel, BorderLayout.LINE_START);
		add(createCartPanel(), BorderLayout.PAGE_START);
		add(mainPanel, BorderLayout.CENTER);
		
		
	}
	
	private JPanel createCartPanel() {
		JPanel cartPanel = new JPanel();
		cartPanel.setLayout(new BorderLayout());
		
		JButton cartButton = new JButton("Koszyk");
		cartPanel.add(cartButton, BorderLayout.LINE_END);
		
		cartButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				displayPanel(CART_PANEL);
			}
		});
		
		return cartPanel;
		
	}
	
	private JPanel createMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanelLayout = new CardLayout();
		mainPanel.setLayout(mainPanelLayout);
		
		itemPanel = new ItemPanel(shopController);
		indexPanel = new IndexPanel(shopController);
		cartPanel = new CartPanel(shopController);
		
		mainPanel.add(itemPanel, ITEM_PANEL);
		mainPanel.add(indexPanel, INDEX_PANEL);
		mainPanel.add(cartPanel, CART_PANEL);
		
		mainPanelLayout.show(mainPanel, INDEX_PANEL);
		
		return mainPanel;
	}

	
	
	private void displayPanel(String panelId) {
		mainPanelLayout.show(mainPanel, panelId);
	}

}
