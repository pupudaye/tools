package org.pl.sports.tools.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import org.pl.sports.tools.ComponenttLifecycle;

public class MainFrame extends JFrame implements ComponenttLifecycle{

	
	private HashMap<String, Component> components;
	
	private JScrollPane scrollPane;
	
	private MyMenuBar menubar;
	
	private MatchTable matchTable;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7181008613333376470L;

	@Override
	public void init() {
		//用来设置窗口随屏幕大小改变
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 关闭方式
//		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container container = this.getContentPane(); // 获取一个容器
		container.setBackground(Color.white); // 设置容器背景颜色
		for (Component component : components.values()) {
			ComponenttLifecycle lifecycle=(ComponenttLifecycle) component;
			lifecycle.init();
		}
		scrollPane.setViewportView(matchTable);
		container.add(scrollPane);
		this.setJMenuBar(menubar);
		sizeWindowOnScreen(0.6, 0.6);
//		this.setSize(1024, 700); //大小
		MessageDialog.getInstance(this);
	}
	
	private void sizeWindowOnScreen(double widthRate,
			double heightRate)
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 
		this.setSize(new Dimension((int) (screenSize.width * widthRate),(int) (screenSize.height * heightRate)));
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
	}

	public void setMatchTable(MatchTable matchTable) {
		this.matchTable = matchTable;
	}
	public void setMenubar(MyMenuBar menubar) {
		this.menubar = menubar;
	}
	public void setComponents(HashMap<String, Component> components) {
		this.components = components;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	
	
}
