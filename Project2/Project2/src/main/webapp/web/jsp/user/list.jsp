<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/web/common/js/header.jsp"%>
	<title>Insert title here</title>
</head>
<body>
<div class="layui-collapse">
  <div class="layui-colla-item">
    <h2 class="layui-colla-title">员工信息-查询条件</h2>
    <div class="layui-colla-content layui-show">
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 0px; padding: 5px">
		<legend>用户信息-查询条件</legend>
		<form class="layui-form">
			<div class="layui-form-item">
				<label class="layui-form-label">账号</label>
				<div class="layui-input-inline">
					<input type="text" name="userCode" placeholder="请输入账号" autocomplete="off" class="layui-input">
				</div>
				<label class="layui-form-label">姓名</label>
				<div class="layui-input-inline">
					<input type="text" name="userName" placeholder="请输入姓名" autocomplete="off" class="layui-input">
				</div>
				<label class="layui-form-label">职位</label>
				<div class="layui-input-inline">
					<input type="text" name="roleName" placeholder="请输入职位" autocomplete="off" class="layui-input">
				</div>
				<label class="layui-form-label"></label> 
				<span> 
				<input type="button" value="查询" class="layui-btn"  lay-filter="search" lay-submit>
				<input type="reset" class="layui-btn" value="重置" /> 
				<input type="button" value="添加" class="layui-btn"  onclick="openAdd()">			
				</span>
			</div>
			<input type="hidden" name="pageIndex" value="1" />
			<input type="hidden" name="pageLimit" value="10" />
		</form>
	</fieldset>
	</div></div></div>
<form class="layui-form"  method="get">
		<div>
				<table class="layui-table">
					<colgroup>
						<col width="5%"><col width="10%">
						<col width="15%"><col width="15%">
						<col width="15%"><col width="10%">
						<col width="25%">
					</colgroup>
					<thead>
						<tr>
							<td>序号</td>
							<td>账号</td>
							<td>密码</td>
							<td>姓名</td>
							<td>职位</td>
							<td>上级编号</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="tbody"></tbody>
				</table>
				<div id="pageInfoUser" style="text-align: right">
				</div>
			</div>
		</form> 

		<script type="text/javascript">
			 $(function(){
				refresh();
				}) 
			 function refresh(){
				$("input[value='查询']").click();
			 }
			 formSubmit("/UserController/search","submit(search)","json",function(data){
				 var  curr=$("input[name='pageIndex']").val();
				 var  limit=$("input[name='pageLimit']").val();
				 var  laypage = layui.laypage  
					laypage.render({
				    elem: 'pageInfoUser',
				    count: data.count,
				    curr:curr,
				    limit:limit,
				    limits:[10,20,30,40],
				    layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
				    ,jump: function(obj,first){
				    	var  curr=$("input[name='pageIndex']").val(obj.curr);
				        var  limit=$("input[name='pageLimit']").val(obj.limit);
				        if(!first){
				    		 refresh();
				    	 } 
				    } 
				  }); 
				 /*  setPageInfo('pageInfoUser',data.count,curr,limit,) */
				  var html="";
				  $.each(data.list,function(index,dom){
				 	  html+="<tr><td>"+((index+1)+(curr-1)*limit)+"</td><td>"
					  +(dom.userCode?dom.userCode:'')+"</td><td>"+(dom.userPass?dom.userPass:'')+"<td>"+
					  (dom.userName?dom.userName:'')+"</td><td>"+(dom.roleName?dom.roleName:'')+"<td>"+
					  (dom.parentName?dom.parentName:'')+"<td>"+
					  "<input type='button' class='layui-btn' onclick='openUpd(\""+dom.userCode+"\")' value='修改' />&nbsp;"+
					  "<input type='button' class='layui-btn' onclick='del(\""+dom.userCode+"\")' value='删除' />&nbsp;"+
					  "<input type='button' class='layui-btn' onclick='openPass(\""+dom.userCode+"\")' value='修改密码' />&nbsp;"+
					  "</td></tr>"    
					  
				  })
				  $("#tbody").html(html); 
			  }) 
              
			 
			 function del(userCode){
					openConfirm(function(index){
						ajax('/UserController/delete', {userCode:userCode}, 'text', function(data){
					        if (data == 1) {
					            layer.msg('删除成功');
					            $("input[name='pageIndex']").val(1);
					            refresh();
					        } else if (data == 2){
					            layer.msg('删除失败--账号已被使用');
					        } else if (data == 3){
				                layer.msg('删除失败--当前账号不允许删除');
				            }
					    })
					})
				}
			 
			 function openUpd(userCode){
					openLayer('/web/system/sys/user/upd.jsp?usercode='+userCode,refresh)
				}
			 //添加
			 function openAdd(){
					openLayer('/web/jsp/user/add.jsp',refresh)
				}
			 
			 function openPass(usercode){
					openLayer('/web/system/sys/user/UpdPassword.jsp?usercode='+usercode,refresh)
				}
			 form.render();
		</script>
</body>
</html>