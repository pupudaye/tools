package org.pl.sports.tools.entity;

public class MenuChild extends Menu {

	public String func;

	public Integer width;
	public Integer height;
	
	private boolean win;
	
	private String commond;
	
	public String getFunc() {
		return func;
	}

	public void setFunc(String func) {
		this.func = func;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getHeight() {
		return height;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public String getCommond() {
		return commond;
	}
	
	
	
}
