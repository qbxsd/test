<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>系统管理</title>
	<%@ include file="/web/common/js/header.jsp"%>
<style type="text/css">
.bottom{
text-align: center;
}
</style>
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">**公司管理系统</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> 
				<img src="javascript:initImage()" class="layui-nav-img" alt="无头像"> 用户：${user1.username}
				</a>
				</li>
				<li class="layui-nav-item"><a href="javascript:goLogout2();">注销</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;">用户管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:openUrl('/Project2/web/jsp/user/list.jsp');">用户信息维护</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item layui-nav-itemed">
					<a class="" href="javascript:;">职位管理</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="javascript:openUrl('/Project2/web/jsp/role/list.jsp');">职位信息维护</a>
						</dd>
					</dl></li>
					<li class="layui-nav-item layui-nav-itemed"><a class=""
					href="javascript:;">菜单管理</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="javascript:openUrl('/Project2/web/jsp/menu/list.jsp');">菜单信息维护</a>
						</dd>
					</dl></li>
					<li class="layui-nav-item layui-nav-itemed"><a class=""
					href="javascript:;">权限管理</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="javascript:openUrl('/Project2/web/jsp/jurisdiction/list.jsp');">权限信息维护</a>
						</dd>
					</dl></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<iframe name="rightframe" width="99%" height="99%" src="/Project2/web/jsp/user/list.jsp"></iframe>
			<!-- <div style="padding: 15px;">内容主体区域</div> -->
		</div>
		<div class="layui-footer">
			<!-- 底部固定区域 -->
			<div class="bottom">**公司管理系统</div>
		</div>
	</div>
	<script>
		function openUrl(url) {
			window.open(url, "rightframe");
		}
		function initImage(){
			var image = '${user.image}';
			image = image?"/picture/image/"+image:''
			 $('img[class="layui-nav-img"]').attr('src',image) 
		}
		function openUser(){
			openLayer('/web/system/user/upd.jsp?employeeCode=${user.employeeCode}'
				,function(){location.reload();})
		}
		function openPic(){
		    openLayer('/web/system/sys/user/Updjsp?employeeCode=${user.employeeCode}'
		        ,function(){location.reload();})
		}
		function openUpd(){
	        openLayer('/web/system/sys/user/UpdPassword.jsp?employeeCode=${user.employeeCode}'
	       		,function(){})
	    }
	</script>
	<script type="text/javascript" src="/Project2/web/common/layui/layui.all.js"></script>
</body>
</html>