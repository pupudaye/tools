package org.pl.sports.tools.ui;

import java.awt.Component;

import javax.swing.JLabel;

public class LableForComponent {

	private JLabel lable;
	private Component component;
	
	public void setLable(JLabel lable) {
		this.lable = lable;
	}
	public void setComponent(Component component) {
		this.component = component;
	}
	public JLabel getLable() {
		return lable;
	}
	public Component getComponent() {
		return component;
	}
}
