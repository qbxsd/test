package com.situ.project2.sys.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.project2.communal.AuthCode;
import com.situ.project2.communal.MD5;
import com.situ.project2.sys.model.UserModel;
import com.situ.project2.sys.service.UserService;

@Controller
@RequestMapping("/UserController")
public class UserController {
	@Autowired
	private UserService userService;
	
	//验证码
	@RequestMapping(value = "/AutoCode", method = RequestMethod.GET)
    @ResponseBody
    public void captcha(HttpServletRequest request, HttpServletResponse response)throws IOException {
		AuthCode.get(request, response);
    }
	//登录
	@ResponseBody
	@RequestMapping(value="/login",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	private String login(UserModel model,HttpServletRequest request){
		if(userService.isOkAuthCode(request)==false) {	//判断验证码
			return "4"; //验证码错误
		}
		UserModel um = new UserModel();
		um.setUserCode(model.getUserCode());
		UserModel u1=userService.selectModel(um);
		if(u1==null){
	       return "0";//账号不存在
	    }
		model.setUserPass(MD5.encode(model.getUserPass()));
		if(u1.getUserPass().equals(model.getUserPass())){
			if(u1.getRoleCode()=="") {
				request.getSession().setAttribute("user1",	 u1); //存入了整条信息
				return "2";//管理员登录成功
			}else {
				request.getSession().setAttribute("user", u1);	//存入了整条信息
				return "1";//用户登录成功
			}	
		}else{
		    return "3";//密码不对
		}
	}
	//查询
	@ResponseBody
	@RequestMapping(value="/search",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	private String getList(UserModel model,HttpServletResponse response){
		model.setUserName("%"+model.getUserName()+"%");
		model.setUserCode("%"+model.getUserCode()+"%");
		model.setParentCode("");
		model.setPageOn(true);
		Map<String,Object> map=new HashMap<>();
		map.put("list", userService.getList(model));
    	map.put("count", userService.selectCount(model));
    	response.setContentType("application/json;charset=UTF-8");
    	return new JSONObject(map).toString();
	}
	//添加员工
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	private String userReg(UserModel model,HttpServletRequest request){
    	model.setUserPass(MD5.encode(model.getUserPass()));   	
    	return userService.insert(model);
	}
	//删除
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	private String delete(UserModel model){
		return userService.delete(model);
	}
	//根据职位
	@ResponseBody
	@RequestMapping(value="/thirdGet",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	private String thirdGet(String roleCode,HttpServletResponse response){
		System.out.println(roleCode+"------------------------------");
		UserModel um=new UserModel();
		if(roleCode.equals("C")) {
			um.setRoleCode("B");
			List<UserModel>modelDB = userService.selectAll(um);
	    	return new JSONArray(modelDB).toString();
		}else if(roleCode.equals("B")){
			um.setRoleCode("A");
			List<UserModel>modelDB = userService.selectAll(um);
	    	return new JSONArray(modelDB).toString();
		}
		return null;	
	}
}
