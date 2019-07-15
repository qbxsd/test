package com.situ.project2.sys.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.project2.sys.model.JurisdictionModel;
import com.situ.project2.sys.service.JurisdictionService;

@Controller
@RequestMapping("/JurisdictionController")
public class JurisdictionController {
	@Autowired
	private JurisdictionService jurisdictionService;
	
	//查询
	@ResponseBody
	@RequestMapping(value="/search")
	private String search(JurisdictionModel model,HttpServletResponse response) {
		model.setRoleCode("%"+model.getRoleCode()+"%");
		model.setMenuCode("%"+model.getMenuCode()+"%");
		model.setPageOn(true);
		Map<String,Object> map=new HashMap<>();
		map.put("list", jurisdictionService.getList(model));
		map.put("count", jurisdictionService.selectCount(model));
		response.setContentType("application/json;charset=UTF-8");
		return new JSONObject(map).toString();
	}
	//删除
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	private String delete(JurisdictionModel model){
		return jurisdictionService.delete(model);
	}
	//添加权限
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	private String userReg(JurisdictionModel model,HttpServletRequest request){
    	return jurisdictionService.insert(model);
	}


}
