package org.pl.sports.tools.ui;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;

public class GlobalConfigUI extends FunctionUI {

	private HashMap<String, LableForComponent> configItems;
	
	private boolean isinit=false;
	
	private GlobalConfigUI that=this;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4821371894975560820L;

	public GlobalConfigUI(){
		super();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		if(isinit)return;
		this.setLayout(new GridLayout(0,2));
		for (LableForComponent lableForComponent : configItems.values()) {
			this.add(lableForComponent.getLable());
			this.add(lableForComponent.getComponent());
		}
		JButton save=new JButton("保存");
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				that.save();
				that.close();
			}
		});
		JButton close=new JButton("关闭");
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				that.close();
			}
		});
		this.add(save);
		this.add(close);
		this.setVisible(true);
		isinit=true;
	}

	public void save(){
		for (LableForComponent lableForComponent : configItems.values()) {
			Component component=lableForComponent.getComponent();
			String value=this.getValue(component);
			String pkey=component.getName();
			configFactory.put(pkey, value);
		}
		configFactory.store();
	}

	
	
	public void setConfigItems(HashMap<String, LableForComponent> configItems) {
		this.configItems = configItems;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		cwindow.setVisible(false);
	}

	
}
