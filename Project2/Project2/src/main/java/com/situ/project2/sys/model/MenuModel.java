package com.situ.project2.sys.model;

import com.situ.project2.communal.common;

public class MenuModel extends common{

	private String menuCode;
	private String menuName;
	private String menuUrl;
	private String parentCode;
	
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	@Override
	public String toString() {
		return "MenuModel [menuCode=" + menuCode + ", menuName=" + menuName + ", menuUrl=" + menuUrl + ", parentCode="
				+ parentCode + "]";
	}

	
}
