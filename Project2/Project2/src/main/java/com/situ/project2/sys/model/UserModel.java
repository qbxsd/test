package com.situ.project2.sys.model;

import com.situ.project2.communal.common;

public class UserModel extends common{

	private String userCode;
	private String userPass;
	private String userName;
	private String roleCode;
	private String roleName;
	private String parentCode;
	private String parentName;
	
	
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	
	@Override
	public String toString() {
		return "UserModel [userCode=" + userCode + ", userPass=" + userPass + ", userName=" + userName + ", roleCode="
				+ roleCode + ", roleName=" + roleName + ", parentCode=" + parentCode + ", parentName=" + parentName
				+ "]";
	}

	
	
}
