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
    <label class="layui-form-label">账号</label>
    <div class="layui-input-inline">
      <input type="text"  name="userCode" placeholder="请输入账号"  class="layui-input" lay-verify="required" required>
    </div>
  </div>
  <div class="layui-form-item" >
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-inline">
      <input type="text"  name="userName" placeholder="请输入姓名"  class="layui-input" lay-verify="required" required>
    </div>
  </div>
  <div class="layui-form-item" >
    <label class="layui-form-label">密码</label>
    <div class="layui-input-inline">
      <input type="password"  name="userPass" placeholder="请输入密码"  class="layui-input" lay-verify="required" required>
    </div>
  </div>
  <div class="layui-form-item" >
    <label class="layui-form-label">职位</label>
    <div class="layui-input-inline">
    	<select name="roleCode" lay-filter="roleCode"></select>
    </div>
  </div>
  <div class="layui-form-item" >
    <label class="layui-form-label">上级领导</label>
    <div class="layui-input-inline">
    	<select name="parentCode" lay-filter="parentCode"></select>	
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
	init();
	function init(){
		ajax('/RoleController/inquire',{action:'all'},'json',function(data){
			var html=""
			$.each(data,function(i,d){
				html+=laytpl($("#opt").html()).render(d);
			})
			$("select[name='roleCode']").html(html);
			form.render();
		})
	}
	form.on('select(roleCode)', function(data){
		$.ajax({  
			url:"/Project2/UserController/thirdGet",
			data:{roleCode:data.value},	//参数
			dataType:"json",
			type: "post",
			success :function(msg){
				var html='';
				$.each(msg,function(i,d){
					html+=laytpl($('#opt1').html()).render(d);
				})
				$("select[name='parentCode']").html(html);
				form.render();  
			}
		})
	}); 
		formSubmit("/UserController/add","submit(add)","text",function(data){
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
	<script type="text/html" id="opt">
		<option value='{{d.roleCode}}'>{{d.roleName}}</option>
	</script>
	<script type="text/html" id="opt1">
		<option value='{{d.userCode}}'>{{d.userName}}</option>
	</script>
</body>
</html>