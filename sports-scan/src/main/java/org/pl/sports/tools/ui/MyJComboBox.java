package org.pl.sports.tools.ui;

import java.util.List;

import javax.swing.JComboBox;

import org.pl.sports.tools.entity.ComboBoxItem;

public class MyJComboBox extends JComboBox<ComboBoxItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5340846281912071720L;

//	private List<ComboBoxItem> comboBoxItems;

	public void setComboBoxItems(List<ComboBoxItem> comboBoxItems) {
		for (ComboBoxItem comboBoxItem : comboBoxItems) {
			this.addItem(comboBoxItem);
		}
//		this.comboBoxItems = comboBoxItems;
	}
	
	
}
