package com.situ.project2.sys.model;

import com.situ.project2.communal.common;

public class RoleModel extends common{
	
	private String roleCode;
	private String roleName;
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
		return "RoleCode [roleCode=" + roleCode + ", roleName=" + roleName + "]";
	}
	
	
}
