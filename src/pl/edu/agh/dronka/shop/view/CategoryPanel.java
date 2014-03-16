package pl.edu.agh.dronka.shop.view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Index;
import pl.edu.agh.dronka.shop.view.util.CheckBoxNode;
import pl.edu.agh.dronka.shop.view.util.CheckBoxNodeEditor;
import pl.edu.agh.dronka.shop.view.util.CheckBoxNodeRenderer;

public class CategoryPanel extends JPanel {

	private static final long serialVersionUID = 717323868233576963L;
	private JTree categoriesTree;
	private Index itemsIndex;
	private ShopController shopController;

	public CategoryPanel(ShopController shopController) {
		this.shopController = shopController;
	}

	public void setIndex(Index itemsIndex) {
		this.itemsIndex = itemsIndex;
		removeAll();
		createVisuals();
	}

	private void createVisuals() {

		setLayout(new BorderLayout());

		categoriesTree = new JTree(getTreeData());

		CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();

		categoriesTree.setCellRenderer(renderer);
		categoriesTree.setCellEditor(new CheckBoxNodeEditor(categoriesTree));
		categoriesTree.setEditable(true);

		categoriesTree.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Set<Category> skippedCategories = new HashSet<>();
				DefaultMutableTreeNode rootItem = (DefaultMutableTreeNode) categoriesTree
						.getModel().getRoot();
				for (int i = 0; i < rootItem.getChildCount(); i++) {
					CheckBoxNode nodeModel = (CheckBoxNode) ((DefaultMutableTreeNode) rootItem
							.getChildAt(i)).getUserObject();
					if (!nodeModel.isSelected()) {
						skippedCategories.add((Category) nodeModel.getData());
					}
				}

				itemsIndex.setSkippedCategories(skippedCategories);
				shopController.refreshIndexView();
			}
		});

		add(categoriesTree, BorderLayout.CENTER);

	}

	private Object[] getTreeData() {
		List<CheckBoxNode> treeNodes = new ArrayList<>();
		for (Category category : itemsIndex.getRegisteredCategories()) {
			CheckBoxNode node = new CheckBoxNode(
					itemsIndex.getCategoryName(category), category, true);
			treeNodes.add(node);
		}

		return treeNodes.toArray();
	}

}
