package com.situ.project2.communal;

public class common extends Pager{

	private Integer id;          // 自增主键
    private String  createTime;  // 创建时间
    private String  updateTime;  // 更新时间
    private String 	createBy;    // 创建人（一般为用户表主键）
    private String 	updateBy;    // 更新人（一般为用户表主键）
    private Integer deleted = 0; // 删除标志（0=未删，1=已删）
    private Integer state   = 0; // 状态标志（0=可用，1=禁用）
    private Double  order;       // 排序序号（小数类型）
    private String  name;        // 名称
    private String  code;        // 编码
    private String  descr;       // 描述
    private String 	type;        // 类型（一般为字典表主键）
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Double getOrder() {
		return order;
	}
	public void setOrder(Double order) {
		this.order = order;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "common [id=" + id + ", createTime=" + createTime + ", updateTime=" + updateTime + ", createBy="
				+ createBy + ", updateBy=" + updateBy + ", deleted=" + deleted + ", state=" + state + ", order=" + order
				+ ", name=" + name + ", code=" + code + ", descr=" + descr + ", type=" + type + "]";
	}
	
    
}
