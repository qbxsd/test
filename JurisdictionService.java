package situ.crm.grant.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import situ.crm.grant.mapper.JurisdictionMapper;
import situ.crm.grant.model.JurisdictionModel;


@Service
public class JurisdictionService {
	@Autowired
	private JurisdictionMapper jurisdictionMapper;
	
	//查询全部 带分页
	public List<JurisdictionModel> getList(JurisdictionModel model) {
		return jurisdictionMapper.selectList(model);
	}
	//查询全部 分页
	public int selectCount(JurisdictionModel um) {
		return jurisdictionMapper.selectCount(um);
	}
	//删除
	public String delete(JurisdictionModel um) {
		if (jurisdictionMapper.deleteModel(um) != 0) {
			return "1";
		} else {
			return "3";
		}
	}
	//判断添加
	public String insert(JurisdictionModel u) {
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
	public JurisdictionModel selectModel(JurisdictionModel u) {
		JurisdictionModel ul = new JurisdictionModel();
		ul.setMenuCode(u.getMenuCode());
		ul.setRoleCode(u.getRoleCode());
		List<JurisdictionModel> list = jurisdictionMapper.selectAll(ul);
		return (list == null || list.isEmpty()) ? null : list.get(0);
	}
	//添加员工
	public int addModel(JurisdictionModel u) {
		return jurisdictionMapper.insert(u);
	}
}
