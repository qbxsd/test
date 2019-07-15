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
            <label class="layui-form-label">账号</label>
            <div class="layui-input-inline">
                <input type="text" name="usercode" lay-verify="required" placeholder="请输入编号" autocomplete="off" class="layui-input" readonly>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input type="text" name="username" placeholder="请输入名称" autocomplete="off"
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
	var usercode = '<%=request.getParameter("usercode")%>';
	$.ajax({
        url:"/Project_01/UserController/get.do",
        data : {usercode:usercode},
        dataType : 'json',
        type : 'post',
        success : function(data) {
        	form.val("formA", {usercode: data.usercode,username:data.username})
            form.render();
        }
    })
	formSubmit('/UserController/updateActive.do', 'submit(upd)', 'text', function(data) {
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