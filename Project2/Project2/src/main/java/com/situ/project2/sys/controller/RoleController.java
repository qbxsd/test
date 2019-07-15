package com.situ.project2.sys.controller;

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

import com.situ.project2.sys.model.RoleModel;
import com.situ.project2.sys.service.RoleService;


@Controller
@RequestMapping("/RoleController")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	//查询
	@ResponseBody
	@RequestMapping(value="/search",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	private String getList(RoleModel model,HttpServletResponse response){
		model.setRoleCode("%"+model.getRoleCode()+"%");
		model.setRoleName("%"+model.getRoleName()+"%");
		model.setPageOn(true);
		Map<String,Object> map=new HashMap<>();
		map.put("list", roleService.getList(model));
    	map.put("count", roleService.selectCount(model));
    	response.setContentType("application/json;charset=UTF-8");
    	return new JSONObject(map).toString();
	}
	
	//删除
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	private String delete(RoleModel model){
		return roleService.delete(model);
	}
	
	//添加职位
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	private String userReg(RoleModel model,HttpServletRequest request){
    	return roleService.insert(model);
	}

	//修改
	@ResponseBody
	@RequestMapping(value="/updateActive",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	private String updateActive(RoleModel model){
		String s=roleService.updateActive(model);
		if(s.equals("1")){
			return "1";
		}else{
			return "2";
		}
	}
	//修改：回显
	@ResponseBody
	@RequestMapping(value="/get",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	private String get(RoleModel model,HttpServletResponse response){
		RoleModel modelDB = roleService.selectModel(model);
		response.setContentType("application/json;charset=UTF-8");
	    return modelDB == null ? "{}" : new JSONObject(modelDB).toString();
	}
	//查询全部，不分页
	@ResponseBody
	@RequestMapping(value="/inquire",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	private String inquire(HttpServletResponse response) {
		RoleModel model=new RoleModel();
		List<RoleModel> list=roleService.selectAll(model);
		return new JSONArray(list).toString();
	}
	
}
