<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <title>Admin Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="static/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="static/css/matrix-login.css"/>
    <link rel="stylesheet" href="static/css/bootstrap-responsive.min.css"/>
    <link rel="stylesheet" href="static/css/font-awesome.css"/>
</head>
<body>
<div id="loginbox">
    <h1 style="text-align:center;">闲品HOME管理员登录</h1>
    <form id="loginform" class="form-vertical"  method="post" role="form">
        <div class="control-group normal_text">
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="main_input_box">
                    <span class="add-on bg_lg"><i class="icon-user"></i> </span> <input
                        type="text" name="adminname" id="adminname"
                        class="required" value="" placeholder="用户名"/>
                </div>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <div class="main_input_box">
                    <span class="add-on bg_ly"><i class="icon-lock"></i> </span>
                    <input type="password" placeholder="密码" name="adminpwd" id="adminpwd"/>
                </div>
            </div>
        </div>
        <div class="form-actions">
            <button id="login" class="btn btn-success" style="margin-left:80%">登录</button>
            <button id="register" class="btn btn-success" style="margin-left:80%">注册</button>
<%--            <input type="submit" class="btn btn-success" value="Login" id="login1" style="margin-left:80%">--%>
        </div>
    </form>
</div>
<script src="static/js/jquery.min.js"></script>
<script src="static/js/matrix.login.js" type="text/javascript" charset="utf-8"></script>


<script type="text/javascript">
    $(function () {
        $('#login').click(function () {
            var adminame = $("#adminname").val();
            var adminpwd = $("#adminpwd").val();
            if(adminame == "" || adminpwd == ""){
                alert("用户名和密码不能为空");
            }else {
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/admin/login",
                    data: {
                        adminname: adminame,
                        adminpwd: adminpwd
                    },
                    dataType: "json",
                    success: function (data) {
                        if(data.type == "success"){
                            alert(data.msg);
                            setTimeout(function () {
                                window.location.href= '${pageContext.request.contextPath}/toindex'
                            },1000)
                        }else {
                            alert(data.msg);
                        }
                    }, error: function (data) {
                        alert("fail");
                    }
                });
            }
            return false;
        });

    })
</script>


</body>
</html>