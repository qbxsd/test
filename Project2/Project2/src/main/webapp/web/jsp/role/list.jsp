<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/web/common/js/header.jsp"%>
	<title>Insert title here</title>
</head>
<body>
<div class="layui-collapse">
  <div class="layui-colla-item">
    <h2 class="layui-colla-title">职位信息-查询条件</h2>
    <div class="layui-colla-content layui-show">
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 0px; padding: 5px">
		<legend>职位信息-查询条件</legend>
		<form class="layui-form">
			<div class="layui-form-item">
				<label class="layui-form-label">职位编号</label>
				<div class="layui-input-inline">
					<input type="text" name="roleCode" placeholder="请输入账号" autocomplete="off" class="layui-input">
				</div>
				<label class="layui-form-label">职位名称</label>
				<div class="layui-input-inline">
					<input type="text" name="roleName" placeholder="请输入姓名" autocomplete="off" class="layui-input">
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
						<col width="10%"><col width="20%">
						<col width="20%"><col width="50%">
					</colgroup>
					<thead>
						<tr>
							<td>序号</td>
							<td>职位编号</td>
							<td>职位名称</td>
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
			form.render();
			 $(function(){
				refresh();
			}) 
			 formSubmit("/RoleController/search","submit(search)","json",function(data){
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
					  +(dom.roleCode?dom.roleCode:'')+"</td><td>"+(dom.roleName?dom.roleName:'')+"<td>"+
					  "<input type='button' class='layui-btn' onclick='openUpd(\""+dom.roleCode+"\")' value='修改' />&nbsp;"+
					  "<input type='button' class='layui-btn' onclick='del(\""+dom.roleCode+"\")' value='删除' />&nbsp;"+
					  "</td></tr>"    
					  
				  })
				  $("#tbody").html(html); 
			  }) 
             function refresh(){
				$("input[value='查询']").click();
			 } 
			 
			 function del(roleCode){
					openConfirm(function(index){
						ajax('/RoleController/delete', {roleCode:roleCode}, 'text', function(data){
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
			 
			 function openUpd(roleCode ){
					openLayer('/web/jsp/role/upd.jsp?roleCode='+roleCode,refresh)
				}
			 //添加
			 function openAdd(){
					openLayer('/web/jsp/role/add.jsp',refresh)
				}
		</script>
</body>
</html>