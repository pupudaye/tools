package org.pl.sports.tools.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.pl.sports.tools.ComponenttLifecycle;
import org.pl.sports.tools.entity.Menu;
import org.pl.sports.tools.entity.MenuChild;

public class MyMenuBar extends JMenuBar implements ComponenttLifecycle {

	private List<Menu> menus;
	
	private HashMap<String, ComponenttLifecycle> command;
	/**
	 * 
	 */
	private static final long serialVersionUID = 8987931696542054814L;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		for (Menu menu : menus) {
			JMenu parentMenu = new JMenu(menu.getName());
			List<MenuChild> childs=menu.getChild();
			for (MenuChild menuChild : childs) {
				JMenuItem menuItem = new JMenuItem(menuChild.getName()); 
				parentMenu.add(menuItem);
				menuItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(menuChild.isWin()){
							FunctionUI fui=(FunctionUI) command.get(menuChild.getFunc());
							fui.setName(menuChild.getName());
							fui.setSize(menuChild.getWidth(), menuChild.getHeight());
							fui.init();
							MessageDialog.getInstance().show(fui);
						}else{
							ComponenttLifecycle comd=command.get(menuChild.getCommond());
							if("init".equals(menuChild.getFunc())){
								comd.init();
							}else{
								comd.close();
							}
							
						}
					}
				});
			}
			this.add(parentMenu);
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public void setCommand(HashMap<String, ComponenttLifecycle> command) {
		this.command = command;
	}
}
