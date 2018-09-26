package org.pl.sports.tools.ui;

import java.awt.Container;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MessageDialog {

	private static volatile  MessageDialog messageDialog;

	private MessageDialogWindow window=null;
	
	private JFrame parentFrame;
	
	private MessageDialog(JFrame parentFrame){
		this.parentFrame=parentFrame;
	}
	
	public static MessageDialog getInstance(){
		return messageDialog;
	}
	
	public static MessageDialog getInstance(JFrame parentFrame){
		if(messageDialog==null){
			synchronized (MessageDialog.class) {
				if(messageDialog==null){
					messageDialog=new MessageDialog(parentFrame);
				}
			}
		}
		return messageDialog;
	}
	
	
	public void show(String message){
		window=new MessageDialogWindow(parentFrame);
		Container container = window.getContentPane();
		container.add(new JLabel(message));
		window.setLocationRelativeTo(null);
		window.setSize(200, 100);
		window.setVisible(true);
	}
	
	public void show(FunctionUI fui){
		window=new MessageDialogWindow(parentFrame,fui.getName());
		Container container = window.getContentPane();
		if(fui!=null){
			fui.setCwindow(window);
			container.add(fui);
			window.setLocationRelativeTo(null);
			window.setSize(fui.getWidth(), fui.getHeight());
			window.setVisible(true);
		}
	}
	
	class MessageDialogWindow extends JDialog{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -5859713352225902791L;

		private MessageDialogWindow(JFrame parentFrame){
			  super(parentFrame, "消息提示", true); // 实例化一个JDialog类对象，指定其父窗体、窗口标题和类型
		}
		private MessageDialogWindow(JFrame parentFrame,String title){
			  super(parentFrame, title, true); // 实例化一个JDialog类对象，指定其父窗体、窗口标题和类型
		}
	}
}
