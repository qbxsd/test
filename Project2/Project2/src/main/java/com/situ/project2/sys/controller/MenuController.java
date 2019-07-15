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

import com.situ.project2.sys.model.MenuModel;
import com.situ.project2.sys.service.MenuService;

@Controller
@RequestMapping("/MenuController")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	//查询
	@ResponseBody
	@RequestMapping(value="/search",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	private String getList(MenuModel model,HttpServletResponse response){
		model.setMenuCode("%"+model.getMenuCode()+"%");
		model.setMenuName("%"+model.getMenuName()+"%");
		model.setPageOn(true);
		Map<String,Object> map=new HashMap<>();
		map.put("list", menuService.getList(model));
    	map.put("count", menuService.selectCount(model));
    	response.setContentType("application/json;charset=UTF-8");
    	return new JSONObject(map).toString();
	}
	//删除
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	private String delete(MenuModel model){
		return menuService.delete(model);
	}
	//添加员工
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	private String userReg(MenuModel model,HttpServletRequest request){
    	return menuService.insert(model);
	}
}
