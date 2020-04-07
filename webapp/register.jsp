<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="en">
<head>
    <title>Admin Register</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="<%=basePath%>static/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="static/layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>static/css/bootstrap-responsive.min.css"/>
    <link rel="stylesheet" href="<%=basePath%>static/css/font-awesome.css"/>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="static/layui/layui.js"></script>
</head>

<body>
<div class="login-main">

    <header class="layui-elip" style="width: 85%">管理员注册</header>

    <form class="layui-form">

        <!--输入用户名-->

        <div class="layui-input-inline">

            <div class="layui-inline" style="width: 85%">

                <input type="text" name="adminname" id="adminname" required  lay-verify="required" placeholder="用户名" autocomplete="off" class="layui-input">

            </div>

        </div>

        <!--输入密码-->

        <div class="layui-input-inline">

            <div class="layui-inline" style="width: 85%">

                <input type="password" name="adminpwd" id="adminpwd" required  lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input">

            </div>

        </div>

        <div class="layui-input-inline login-btn" style="width: 85%">

            <button type="submit" lay-submit lay-filter="register" class="layui-btn" lay->注册</button>

        </div>

        <br/>

        <p style="width: 85%">

            <a href="pages/login.html" class="fl">已有账号？立即登录</a>

            <a href="javascript:;" class="fr">忘记密码？</a>

        </p>

    </form>

</div>

<script type="text/javascript">
    $(function () {
        layui.use('form', function () {
            var form = layui.form;
            //监听提交
            form.on('submit(register)', function (data) {
                var adminame = $("#adminname").val();
                var adminpwd = $("#adminpwd").val();
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/admin/register",
                    data: {
                        adminname: adminame,
                        adminpwd: adminpwd
                    },
                    dataType: "json",
                    success: function (data) {
                        if(data.type=="success"){
                            layer.msg("注册成功")
                        }else{
                            layer.msg("注册失败")
                        }

                    }

                });
                return false;
            });
        });

    })

</script>


</body>

</html>

