package org.pl.sports.tools.ui;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.pl.sports.tools.ComponenttLifecycle;
import org.pl.sports.tools.entity.GlobalConfigFactory;
import org.pl.sports.tools.ui.MessageDialog.MessageDialogWindow;

public abstract class FunctionUI extends JPanel implements ComponenttLifecycle {

	public MessageDialogWindow cwindow;
	
	protected GlobalConfigFactory configFactory;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6885375291675814285L;

	public FunctionUI(){
	}
	
	protected String getValue(Component component) {
		// TODO Auto-generated method stub
		if(component instanceof JTextField){
			return ((JTextField) component).getText();
		}else if(component instanceof MyJComboBox){
			return String.valueOf(((MyJComboBox) component).getSelectedIndex());
		}else{
			return null;
		}
	}

	public void setCwindow(MessageDialogWindow cwindow) {
		this.cwindow = cwindow;
	}

	public void setConfigFactory(GlobalConfigFactory configFactory) {
		this.configFactory = configFactory;
	}
	
	
}
