package org.pl.sports.tools.entity;

import java.util.List;

public  class Menu {

	private String name;

	private List<MenuChild> child;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MenuChild> getChild() {
		return child;
	}

	public void setChild(List<MenuChild> child) {
		this.child = child;
	}
	
	
}
