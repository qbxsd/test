package com.situ.project2.sys.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.situ.project2.sys.model.MenuModel;
@Repository
public interface MenuMapper {
	//添加
	int insert(MenuModel t);
	//删除
	int delete(MenuModel id);
	//删除
	int deleteModel(MenuModel t);
	//修改
	int update(MenuModel t);
	//修改
	int updataActive(MenuModel t);
	//查找，凭Id
	MenuModel selectId(MenuModel t);
	//查找全部
	List<MenuModel>selectAll(MenuModel t);
	//查找全部 分页
	List<MenuModel>selectList(MenuModel t);
	//查找全部  超过分页
	List<MenuModel>selectModel(MenuModel t);
	//分页
	int selectCount(MenuModel t);	
}
