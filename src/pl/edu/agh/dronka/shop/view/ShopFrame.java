package pl.edu.agh.dronka.shop.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

public class ShopFrame extends JFrame {

	private static final long serialVersionUID = 6578553391433363839L;

	private static final String CATEGORIES_PANEL = "Categories Panel";

	private static final String PRODUCTS_PANEL = "Products Panel";

	private static final String ITEM_PANEL = "Item Panel";

	private static final String INDEX_PANEL = "Index Panel";

	private static final String CART_PANEL = "Cart Panel";

	private CardLayout mainPanelLayout;

	private JPanel mainPanel;

	private CategoriesPanel categoriesPanel;

	private ProductsPanel productsPanel;

	private ItemPanel itemPanel;

	private ProductsPanel indexPanel;

	private ShopController shopController;

	private CartPanel cartPanel;

	public ShopFrame(ShopController shopController) {

		this.shopController = shopController;
		this.shopController.setShopView(this);
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

	
	public void displayCategories() {
		displayPanel(CATEGORIES_PANEL);
		
	}
	
	public void displayProducts(Category category) {
		displayPanel(PRODUCTS_PANEL);
	}

	public CartPanel getCartPanel() {
		return cartPanel;
	}

	public ProductsPanel getProductsPanel() {
		return productsPanel;
	}

	public ItemPanel getItemPanel() {
		return itemPanel;
	}

	private void createVisuals() {

		BorderLayout layout = new BorderLayout();
		layout.setHgap(10);
		setLayout(layout);

		mainPanel = createMainPanel();
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

	// private JPanel createProductsPanel() {
	// JPanel productsPanel = new JPanel(new GridBagLayout());
	//
	// prodcutsPanel = new ProductsPanel(shopController);
	// GridBagConstraints c = new GridBagConstraints();
	// c.fill = GridBagConstraints.BOTH;
	// c.weightx = 0.5;
	// c.weighty = 0.5;
	// c.insets = new Insets(10, 0, 10, 10);
	// productsPanel.add(prodcutsPanel, c);
	//
	//
	// indexPanel = new IndexPanel(shopController);
	// c.gridwidth = 2;
	// c.insets = new Insets(10, 10, 10, 0);
	// productsPanel.add(indexPanel, c);
	//
	// return productsPanel;
	//
	// }

	private JPanel createMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanelLayout = new CardLayout();
		mainPanel.setLayout(mainPanelLayout);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 10, 30));

		categoriesPanel = new CategoriesPanel(shopController);
		productsPanel = new ProductsPanel(shopController);
		itemPanel = new ItemPanel(shopController);
		cartPanel = new CartPanel(shopController);

		mainPanel.add(categoriesPanel, CATEGORIES_PANEL);
		mainPanel.add(productsPanel, PRODUCTS_PANEL);
		mainPanel.add(itemPanel, ITEM_PANEL);
		mainPanel.add(cartPanel, CART_PANEL);

		mainPanelLayout.show(mainPanel, CATEGORIES_PANEL);

		return mainPanel;
	}

	private void displayPanel(String panelId) {
		mainPanelLayout.show(mainPanel, panelId);
	}
	

}
