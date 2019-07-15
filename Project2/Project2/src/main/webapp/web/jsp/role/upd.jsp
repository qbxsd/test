<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<%@ include file="/web/common/js/header.jsp"%>
</head>
<body>
    <fieldset class="layui-elem-field" style="margin: 20px;padding:15px;">
        <legend>员工信息维护</legend>
    <form class="layui-form" lay-filter="formA" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">职位编号</label>
            <div class="layui-input-inline">
                <input type="text" name="roleCode" lay-verify="required" placeholder="请输入编号" autocomplete="off" class="layui-input" readonly>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">职位名称</label>
            <div class="layui-input-inline">
                <input type="text" name="roleName" placeholder="请输入职位编号" autocomplete="off"
                    class="layui-input">
            </div>
        </div>
        
 <div class="layui-form-item">
    <div class="layui-input-item">
     <input type="reset" class="layui-btn"  value="重置"> 
       <input class="layui-btn" type="button" value="确定"  lay-filter="upd" lay-submit>
       <input type="button" class="layui-btn" onclick="closeThis()" value="取消" />
    </div>
  </div>
    </form>
    </fieldset>
<script type="text/javascript">

init();
function init(){ 
	var roleCode = '<%=request.getParameter("roleCode")%>';
	$.ajax({
        url:"/Project2/RoleController/get",
        data : {roleCode:roleCode},
        dataType : 'json',
        type : 'post',
        success : function(data) {
        	form.val("formA", {roleCode: data.roleCode,roleName:data.roleName})
            form.render();
        }
    })
	formSubmit('/RoleController/updateActive', 'submit(upd)', 'text', function(data) {
		if (data == 1) {
	        layer.msg('修改成功');
	        closeThis(3000);
	    } else {
	        layer.msg('修改失败');
	    }
	})
}
</script>
</body>
</html>