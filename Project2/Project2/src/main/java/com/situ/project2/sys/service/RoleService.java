package com.situ.project2.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.project2.sys.mapper.RoleMapper;
import com.situ.project2.sys.model.RoleModel;

@Service
public class RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	//查询 带分页
	public List<RoleModel> getList(RoleModel um) {
		return roleMapper.selectList(um);
	}
	
	//查询 分页
	public int selectCount(RoleModel um) {
		return roleMapper.selectCount(um);
	}
	
	//删除
	public String delete(RoleModel um) {
		if (roleMapper.deleteModel(um) != 0) {
			return "1";
		} else {
			return "3";
		}
	}
	
	//判断添加
	public String insert(RoleModel u) {
		if (selectModel(u) == null) {
			int s = addModel(u);
			if (s == 0) {
				return "3";// 3失败
			} else {
				return "0";// 0成功
			}
		}
		return "1";// 账号已存在
	}
	
	//查询账号
	public RoleModel selectModel(RoleModel u) {
		RoleModel ul = new RoleModel();
		ul.setRoleCode(u.getRoleCode());
		List<RoleModel> list = roleMapper.selectAll(ul);
		return (list == null || list.isEmpty()) ? null : list.get(0);
	}
	//添加员工
	public int addModel(RoleModel u) {
		return roleMapper.insert(u);
	}
	//修改
	public String updateActive(RoleModel um) {
		int s=roleMapper.updataActive(um);
		if(s==1){
			return "1";
		}else{
			return "2";
		}
	}
	//查询 不分页
	public List<RoleModel> selectAll(RoleModel um) {
		return roleMapper.selectAll(um);
	}
}
