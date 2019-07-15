package com.situ.project2.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.project2.sys.mapper.MenuMapper;
import com.situ.project2.sys.mapper.UserMapper;
import com.situ.project2.sys.model.MenuModel;
import com.situ.project2.sys.model.UserModel;

@Service
public class MenuService {
	
	@Autowired
	private MenuMapper menuMapper;
	
	//查询全部 带分页
	public List<MenuModel> getList(MenuModel um) {
		return menuMapper.selectList(um);
	}
	//查询全部 分页
	public int selectCount(MenuModel um) {
		return menuMapper.selectCount(um);
	}
	//删除
	public String delete(MenuModel um) {
		if (menuMapper.deleteModel(um) != 0) {
			return "1";
		} else {
			return "3";
		}
	}
	//判断添加
	public String insert(MenuModel u) {
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
	public MenuModel selectModel(MenuModel u) {
		MenuModel ul = new MenuModel();
		ul.setMenuCode(u.getMenuCode());
		List<MenuModel> list = menuMapper.selectAll(ul);
		return (list == null || list.isEmpty()) ? null : list.get(0);
	}
	//添加员工
	public int addModel(MenuModel u) {
		return menuMapper.insert(u);
	}
	
}
