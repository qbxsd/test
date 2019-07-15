package com.situ.project2.sys.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.situ.project2.sys.model.UserModel;

@Repository
public interface UserMapper {
	//添加
	int insert(UserModel t);
	//删除
	int delete(UserModel id);
	//删除
	int deleteModel(UserModel t);
	//修改
	int update(UserModel t);
	//修改
	int updataActive(UserModel t);
	//查找，凭Id
	UserModel selectId(UserModel t);
	//查找全部
	List<UserModel>selectAll(UserModel t);
	//查找全部 分页
	List<UserModel>selectList(UserModel t);
	//查找全部  超过分页
	List<UserModel>selectModel(UserModel t);
	//分页
	int selectCount(UserModel t);
}
