
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户</title>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="../static/css/font.css">
    <link rel="stylesheet" href="../static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="/static/layui/layui.js"></script>
    <script type="text/javascript" src="../static/js/xadmin1.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <style>
        #mybody{
            margin-top: 20px;
        }
        .layui-form-item{
            float: left;
            margin-left: 20px;
            width: 320px;
            clear: none;
        }
        .layui-form-label{
            text-align: left;
        }
    </style>
</head>

<body>
<div id="mybody" class="x-body layui-anim layui-anim-up">
    <xblock>
        <div class="layui-form-item">
            <label for="username" class="layui-form-label">
                <span class="x-red">*</span>用户名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="username" required="" lay-verify="nikename"
                       autocomplete="off" class="layui-input" value="${user.username}">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="nickname" class="layui-form-label">
                <span class="x-red">*</span>昵称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="nickname" required="" lay-verify="nikename"
                       autocomplete="off" class="layui-input" value="${user.nickname}">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="phone" class="layui-form-label">
                <span class="x-red">*</span>联系电话
            </label>
            <div class="layui-input-inline">
                <input type="text" id="phone" required="" lay-verify="nikename"
                       autocomplete="off" class="layui-input" value="${user.phone}">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="create_time" class="layui-form-label">
                <span class="x-red">*</span>账号创建时间
            </label>
            <div class="layui-input-inline">
                <input type="text" id="create_time" required="" lay-verify="nikename"
                       autocomplete="off" class="layui-input" value="${user.create_time}">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="last_login_time" class="layui-form-label">
                <span class="x-red">*</span>最近登录时间
            </label>
            <div class="layui-input-inline">
                <input type="text" id="last_login_time" required="" lay-verify="nikename"
                       autocomplete="off" class="layui-input" value="${user.last_login_time}">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="goods_num" class="layui-form-label">
                <span class="x-red">*</span>发布的商品数量
            </label>
            <div class="layui-input-inline">
                <input type="text" id="goods_num" required="" lay-verify="nikename"
                       autocomplete="off" class="layui-input" value="${user.goods_num}">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="status" class="layui-form-label">
                <span class="x-red">*</span>账号状态
            </label>
            <div class="layui-input-inline">
                <input type="text" id="status" required="" lay-verify="nikename"
                       autocomplete="off" class="layui-input" value="${user.status}">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="credit_score" class="layui-form-label">
                <span class="x-red">*</span>信用分
            </label>
            <div class="layui-input-inline">
                <input type="text" id="credit_score" required="" lay-verify="nikename"
                       autocomplete="off" class="layui-input" value="${user.credit_score}">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="email" class="layui-form-label">
                <span class="x-red">*</span>邮箱
            </label>
            <div class="layui-input-inline">
                <input type="text" id="email" required="" lay-verify="nikename"
                       autocomplete="off" class="layui-input" value="${user.email}">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="password" class="layui-form-label">
                <span class="x-red">*</span>密码
            </label>
            <div class="layui-input-inline">
                <input type="text" id="password" required="" lay-verify="nikename"
                       autocomplete="off" class="layui-input" value="${user.password}">
            </div>
        </div>
        <div class="layui-form-item" style="margin-left: 550px">
            <button class="layui-btn" id="edit">
                保存修改
            </button>
        </div>

    </xblock>
</div>


<script>

    /**
     * 修改用户信息
     */
    $("#edit").click(function () {
        var userId = '${user.userId}';
        var username = $("#username").val();
        var nickname = $("#nickname").val();
        var phone = $("#phone").val();
        var create_time = $("#create_time").val();
        var last_login_time = $("#last_login_time").val();
        var goods_num = $("#goods_num").val();
        var status = $("#status").val();
        var credit_score = $("#credit_score").val();
        var email = $("#email").val();
        var password=$("#password").val();

        if (username == "" || nickname == "" || phone == "" || status == "" || credit_score == "" ||email == "" ||create_time == "" ||last_login_time == "" ||goods_num == ""||password == "") {
            layer.alert('您需要将信息填完才能提交哦😯', {
                skin: 'layui-layer-molv'
                , closeBtn: 0
                , anim: 4 //动画类型
            });
        }else if(phone.length != 11){
            layer.alert('请输入正确的电话位数：11位',{
                skin: 'layui-layer-molv',
                closeBtn : 0,
                anim : 4
            });
        }else {
            $.ajax({
                url: "/user/editUser",
                type: "post",
                data: {
                    userId:userId,
                    username:username,
                    nickname:nickname,
                    phone:phone,
                    create_time:create_time,
                    last_login_time:last_login_time,
                    goods_num:goods_num,
                    status:status,
                    credit_score:credit_score,
                    email:email,
                    password:password,
                },
                dataType: "json",
                success: function (data) {
                    if (data.type=="success") {
                        layer.alert("修改成功！", {icon: 6}, function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                            parent.location.replace(parent.location.href);
                        });
                    } else {
                        layer.msg("请求失败！")
                    }
                }
            });

        }

    })


</script>

</body>
</html>
