<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/web/common/js/header.jsp"%>
<title>登录</title>
<style>
.window {
	width: 400px;
	position: absolute;
	margin-left: -200px;
	margin-top: -80px;
	top: 50%;
	left: 50%;
	display: block;
	z-index: 2000;
	background: #fff;
	padding: 20 0;
}
</style>
</head>
<body style="background: #f1f1f1;">
	<div class="window">
		<fieldset class="layui-elem-field" style="margin: 10px;">
			<legend>登录</legend>
			<div class="layui-field-box">
				<form class="layui-form layui-form-pane" method="post">
					<div class="layui-form-item">
						<label class="layui-form-label">账号：</label>
						<div class="layui-input-inline">
							<input type="text" name="userCode" required 
							    lay-verify="required" placeholder="请输入账号"
								autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">密码：</label>
						<div class="layui-input-inline">
							<input type="password" name="userPass" required 
							    lay-verify="required" placeholder="请输入密码"
								autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">
							<img src='/Project2/UserController/AutoCode' 
	     						onclick="this.src='/Project2/UserController/AutoCode?'+Math.random();">
						</label>
						<div class="layui-input-inline">
							<input type="text" name="yanzhengma" required 
							     placeholder="请输入验证码" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-form-item">
							<div class="layui-input-inline">
								<input type="button" class="layui-btn" value="登录" 
								lay-submit lay-filter="login" /> 
								<input type="reset" class="layui-btn layui-btn-primary" value="重置" />
							</div>
						</div>
					</div>
					<input type="hidden" name="action" value="login" />
				</form>
			</div>
		</fieldset>
	</div>
	<script type="text/javascript">	
		formSubmit("/UserController/login","submit(login)","text",function(data){
			if(data==0){
				layer.msg("账号不存在");
			}else if(data==1){
				location.href="/Project2/web/jsp/user/list.jsp";		//员工
			}else if(data==2){
				location.href="/Project2/web/jsp/user/list.jsp";		//管理员
			}else if(data==3){
				layer.msg("密码不对"); 
			}else if(data==4){
				layer.msg("验证码错误"); 
			}
		})
		form.render();
	</script>
</body>
		
</html>