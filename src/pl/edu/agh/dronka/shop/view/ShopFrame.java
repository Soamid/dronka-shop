package pl.edu.agh.dronka.shop.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Item;

public class ShopFrame extends JFrame {

	private static final long serialVersionUID = 6578553391433363839L;

	private static final String CATEGORIES_PANEL = "Categories Panel";
	
	private static final String ITEM_PANEL = "Item Panel";
	
	private static final String INDEX_PANEL = "Index Panel";

	private static final String CART_PANEL = "Cart Panel";
	
	
	private CardLayout mainPanelLayout;

	private JPanel mainPanel;

	private CategoriesPanel categoriesPanel;
	
	private CategoryPanel categoryPanel;

	private ItemPanel itemPanel;

	private IndexPanel indexPanel;

	private ShopController shopController;

	private CartPanel cartPanel;
 
	public ShopFrame(ShopController shopController) {
		
		this.shopController = shopController;
		shopController.setShopView(this);
		
		createVisuals();
		
		setTitle("Dronka Shop");
		setSize(700, 300);
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
	
	public CategoryPanel getCategoryPanel() {
		return categoryPanel;
	}
	
	public ItemPanel getItemPanel() {
		return itemPanel;
	}
	
	private void createVisuals() {
		
		BorderLayout layout = new BorderLayout();
		layout.setHgap(10);
		setLayout(layout);
		
		mainPanel = createMainPanel();
		
		
		categoryPanel = new CategoryPanel(shopController);
		
		add(categoryPanel, BorderLayout.LINE_START);
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
		
		categoriesPanel = new CategoriesPanel(shopController);
		itemPanel = new ItemPanel(shopController);
		indexPanel = new IndexPanel(shopController);
		cartPanel = new CartPanel(shopController);
		
		mainPanel.add(categoriesPanel, CATEGORIES_PANEL);
		mainPanel.add(itemPanel, ITEM_PANEL);
		mainPanel.add(indexPanel, INDEX_PANEL);
		mainPanel.add(cartPanel, CART_PANEL);
		
		mainPanelLayout.show(mainPanel, CATEGORIES_PANEL);
		
		return mainPanel;
	}

	
	
	private void displayPanel(String panelId) {
		mainPanelLayout.show(mainPanel, panelId);
	}
	
	

}
