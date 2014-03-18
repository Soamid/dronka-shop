package pl.edu.agh.dronka.shop.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Category;

/**
 * Shows list of categories available in the shop. *
 */
public class CategoriesPanel extends JPanel {

	private final ShopController shopController;

	public CategoriesPanel(ShopController shopController) {
		this.shopController = shopController;
		createVisuals();
	}

	private void createVisuals() {
		setLayout(new GridLayout(0, 1));
		JLabel title = new JLabel("<HTML><FONT color=\"#000099\">Lista kategorii</FONT></HTML>");
		add(title);
		
		for (Category category : Category.values()) {
			addCategoryLink(category);
			
		}
	}

	private void addCategoryLink(Category category) {
		JButton button = new JButton();
		button.setText("<HTML><FONT color=\"#000099\"><U>" + category.name() + "</U></FONT>" + 
				"</HTML>");
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setBorderPainted(false);
		button.setOpaque(false);
		button.setBackground(Color.WHITE);
		//button.addActionListener();
		add(button);
	}
}
