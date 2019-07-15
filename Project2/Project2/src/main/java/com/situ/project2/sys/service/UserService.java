package com.situ.project2.sys.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.project2.sys.mapper.UserMapper;
import com.situ.project2.sys.model.RoleModel;
import com.situ.project2.sys.model.UserModel;
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	//判断验证码对错的方法 返回一个布尔值
	public boolean isOkAuthCode(HttpServletRequest request) {
		Object authCode = request.getSession().getAttribute("authCode");
        String code = request.getParameter("yanzhengma");
        return authCode.toString().equals(code);
	}
	//查询账号
	public UserModel selectModel(UserModel u) {
		UserModel ul = new UserModel();
		ul.setUserCode(u.getUserCode());
		List<UserModel> list = userMapper.selectAll(ul);
		return (list == null || list.isEmpty()) ? null : list.get(0);
	}
	//查询 带分页
	public List<UserModel> getList(UserModel um) {
		return userMapper.selectList(um);
	}
	//查询 分页
	public int selectCount(UserModel um) {
		return userMapper.selectCount(um);
	}
	//查询 带分页
	public List<UserModel> selectAll(UserModel um) {
		return userMapper.selectAll(um);
	}
	//判断添加
	public String insert(UserModel u) {
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
	//添加员工
	public int addModel(UserModel u) {
		return userMapper.insert(u);
	}
	
	//删除
	public String delete(UserModel um) {
		if (userMapper.deleteModel(um) != 0) {
			return "1";
		} else {
			return "3";
		}
	}
//	//查询上级编号
//	public List<UserModel> thirdGet(UserModel u) {
//		UserModel ul = new UserModel();
//		ul.setSortSuperior(u.getSortSuperior());
//		List<UserModel> list = userMapper.selectAll(ul);
//		return (list == null || list.isEmpty()) ? null : list;
//	}
}
