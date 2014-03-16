package pl.edu.agh.dronka.shop.view.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

public class CheckBoxNodeRenderer implements TreeCellRenderer {
	private JCheckBox leafRenderer = new JCheckBox();

	private Object nodeData;

	private DefaultTreeCellRenderer nonLeafRenderer = new DefaultTreeCellRenderer();

	Color selectionBorderColor, selectionForeground, selectionBackground,
			textForeground, textBackground;

	protected JCheckBox getLeafRenderer() {
		return leafRenderer;
	}

	public CheckBoxNodeRenderer() {
		Font fontValue;
		fontValue = UIManager.getFont("Tree.font");
		if (fontValue != null) {
			leafRenderer.setFont(fontValue);
		}
		Boolean booleanValue = (Boolean) UIManager
				.get("Tree.drawsFocusBorderAroundIcon");
		leafRenderer.setFocusPainted((booleanValue != null)
				&& (booleanValue.booleanValue()));

		selectionBorderColor = UIManager.getColor("Tree.selectionBorderColor");
		selectionForeground = UIManager.getColor("Tree.selectionForeground");
		selectionBackground = UIManager.getColor("Tree.selectionBackground");
		textForeground = UIManager.getColor("Tree.textForeground");
		textBackground = UIManager.getColor("Tree.textBackground");

	}

	public Object getNodeData() {
		return nodeData;
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value,
	      boolean selected, boolean expanded, boolean leaf, int row,
	      boolean hasFocus) {

	    Component returnValue;
	    if (leaf) {

	      String stringValue = tree.convertValueToText(value, selected,
	          expanded, leaf, row, false); 
	      
	      leafRenderer.setText(stringValue);
	      leafRenderer.setSelected(false);

	      leafRenderer.setEnabled(tree.isEnabled());

	      if (selected) {
	        leafRenderer.setForeground(selectionForeground);
	        leafRenderer.setBackground(selectionBackground);
	      } else {
	        leafRenderer.setForeground(textForeground);
	        leafRenderer.setBackground(textBackground);
	      }

	      if ((value != null) && (value instanceof DefaultMutableTreeNode)) {
	        Object userObject = ((DefaultMutableTreeNode) value)
	            .getUserObject();
	        if (userObject instanceof CheckBoxNode) {
	          final CheckBoxNode node = (CheckBoxNode) userObject;
	          nodeData = node.getData();
	          leafRenderer.setText(node.getText());
	          leafRenderer.setSelected(node.isSelected());
	          leafRenderer.addActionListener(new ActionListener() {
	  			@Override
	  			public void actionPerformed(ActionEvent arg0) {
	  				node.setSelected(leafRenderer.isSelected());
	  			}
	  		});
	        }
	      }
	      returnValue = leafRenderer;
	    } else {
	      returnValue = nonLeafRenderer.getTreeCellRendererComponent(tree,
	          value, selected, expanded, leaf, row, hasFocus);
	    }
	    return returnValue;
	  }
}
