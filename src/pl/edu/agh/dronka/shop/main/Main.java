package pl.edu.agh.dronka.shop.main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.provider.ShopProvider;
import pl.edu.agh.dronka.shop.view.ShopFrame;

public class Main {

	public static void main(String[] args) {
		
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e) {
				
				e.printStackTrace();
				return;
			}
	
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ShopController shopController = new ShopController();
				shopController.setModel(ShopProvider.getExampleShop());
				ShopFrame shopFrame = new ShopFrame(shopController);
				shopController.logIn(ShopProvider.getExampleUser());
				shopFrame
						.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				shopFrame.setVisible(true);
			}
		});
	}
}
