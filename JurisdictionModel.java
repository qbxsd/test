package situ.crm.grant.model;

import situ.util.common;

public class JurisdictionModel extends common{

	private String menuCode;
	private String menuName;
	private String roleCode;
	private String roleName;
	
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
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "JurisdictionModel [menuCode=" + menuCode + ", menuName=" + menuName + ", roleCode=" + roleCode
				+ ", roleName=" + roleName + "]";
	}
	
	
}
