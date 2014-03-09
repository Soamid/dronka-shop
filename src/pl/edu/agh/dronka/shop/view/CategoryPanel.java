package pl.edu.agh.dronka.shop.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTree;

import pl.edu.agh.dronka.shop.view.util.CheckBoxNode;
import pl.edu.agh.dronka.shop.view.util.CheckBoxNodeEditor;
import pl.edu.agh.dronka.shop.view.util.CheckBoxNodeRenderer;

public class CategoryPanel extends JPanel {

	private static final long serialVersionUID = 717323868233576963L;

	public CategoryPanel() {
		createVisuals();
	}

	private void createVisuals() {

		setLayout(new BorderLayout());

		JTree categoriesTree = new JTree(new Object[] {
				new CheckBoxNode("test1", true),
				new CheckBoxNode("test2", true) });
		CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();
		categoriesTree.setCellRenderer(renderer);

		categoriesTree.setCellEditor(new CheckBoxNodeEditor(categoriesTree));
		categoriesTree.setEditable(true);

		add(categoriesTree, BorderLayout.CENTER);

	}

}
