package org.pl.sports.tools.ui;

import java.awt.Component;

import javax.swing.JScrollPane;

import org.pl.sports.tools.ComponenttLifecycle;

public class MyJScrollPane extends JScrollPane implements ComponenttLifecycle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5358163601194904046L;

	public MyJScrollPane(Component view){
		super(view);
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
}
