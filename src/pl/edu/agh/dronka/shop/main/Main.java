package pl.edu.agh.dronka.shop.main;

import javax.swing.WindowConstants;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.provider.ShopProvider;
import pl.edu.agh.dronka.shop.view.ShopFrame;

public class Main {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ShopController shopController = new ShopController();
				ShopFrame shopFrame = new ShopFrame(shopController);
				shopController.setModel(ShopProvider.getExampleShop());
				shopController.logIn(ShopProvider.getExampleUser());
				shopFrame
						.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				shopFrame.setVisible(true);
			}
		});
	}
}
