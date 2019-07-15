package com.situ.project2.sys.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.situ.project2.sys.model.RoleModel;
@Repository
public interface RoleMapper {

	//添加
	int insert(RoleModel t);
	//删除
	int delete(RoleModel id);
	//删除
	int deleteModel(RoleModel t);
	//修改
	int update(RoleModel t);
	//修改
	int updataActive(RoleModel t);
	//查找，凭Id
	RoleModel selectId(RoleModel t);
	//查找全部
	List<RoleModel>selectAll(RoleModel t);
	//查找全部 分页
	List<RoleModel>selectList(RoleModel t);
	//查找全部  超过分页
	List<RoleModel>selectModel(RoleModel t);
	//分页
	int selectCount(RoleModel t);
}
