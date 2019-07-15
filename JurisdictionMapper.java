package situ.crm.grant.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import situ.crm.grant.model.JurisdictionModel;


@Repository
public interface JurisdictionMapper {
	
	//添加
	int insert(JurisdictionModel t);
	//删除
	int delete(JurisdictionModel id);
	//删除
	int deleteModel(JurisdictionModel t);
	//修改
	int update(JurisdictionModel t);
	//修改
	int updateActive(JurisdictionModel t);
	//查找，凭Id
	JurisdictionModel selectId(JurisdictionModel t);
	//查找全部
	List<JurisdictionModel>selectAll(JurisdictionModel t);
	//查找全部 分页
	List<JurisdictionModel>selectList(JurisdictionModel t);
	//查找全部  超过分页
	List<JurisdictionModel>selectModel(JurisdictionModel t);
	//分页
	int selectCount(JurisdictionModel t);	
	
}
