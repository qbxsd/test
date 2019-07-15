<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<%@ include file="/web/common/js/header.jsp"%>
</head>
<body>
<fieldset class="layui-elem-field">
<legend>添加：</legend>
<div class="layui-field-box">
    <form class="layui-form layui-form-pane" method="get">
<div style="position :relative; left:30%"> 
 <div class="layui-form-item" >
    <label class="layui-form-label">菜单编号：</label>
    <div class="layui-input-inline">
      <input type="text"  name="menuCode" placeholder="请输入菜单编号"  class="layui-input" lay-verify="required" required>
    </div>
  </div>
  <div class="layui-form-item" >
    <label class="layui-form-label">菜单名称：</label>
    <div class="layui-input-inline">
      <input type="text"  name="menuName" placeholder="请输入菜单名称"  class="layui-input" lay-verify="required" required>
    </div>
  </div>
   <div class="layui-form-item" >
    <label class="layui-form-label">菜单路径：</label>
    <div class="layui-input-inline">
      <input type="text"  name="menuUrl" placeholder="请输入菜单路径"  class="layui-input" lay-verify="required" required>
    </div>
  </div>
  <div class="layui-form-item" >
    <label class="layui-form-label">上级菜单编号：</label>
    <div class="layui-input-inline">
      <input type="text"  name="parentCode" placeholder="请输入上级菜单编号"  class="layui-input" lay-verify="required" required>
    </div>
  </div>
    <div class="layui-form-item">
    <div class="layui-input-item">
     <input type="reset" class="layui-btn"  value="重置"> 
       <input class="layui-btn" type="button" value="确定"  lay-filter="add" lay-submit>
       <input type="button" class="layui-btn" onclick="closeThis()" value="取消" />
    </div>
  </div>
   </div> 
  </form>
  </div>
  	</fieldset>
<script type="text/javascript">
		formSubmit("/MenuController/add","submit(add)","text",function(data){
			  if(data==0){
				  layer.msg('添加成功');
			      closeThis(3000);
			  }else if(data==1){
				  layer.msg("账号已存在"); 
			  }else if(data==2){
				  layer.msg("操作失败,验证码错误");
			  }
			  else{
				  layer.msg("添加失败"); 
			  }
		  })
	</script>
	
</body>
</html>