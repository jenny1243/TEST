layui.config({
    base: "js/"
}).use(['form', 'layer'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        $ = layui.jquery;
    //获取绝对路径
    var path = $("#path").val();
    //登录按钮事件
    form.on("submit(login)", function (data) {
        // $.ajaxSettings.async = false;
        $.post(path + "/sy/userAction_login.action", {
            user_name: $('#user_name').val(),
            pwd: $('#pwd').val()
        }, function (data) {
            console.log(data);
            if (data > 0) {//登录成功
                layer.msg("登录成功", {icon:1,time: 1000}, function () {
                    parent.location.href = path + '/index.jsp';
                })
            } else {
                layer.msg("登录失败,帐号或密码错误或帐号不可用", {icon:2,time: 1000}, function () {
                })
            }

        })
        return false;
    })
});

function refreshCode() {
    var captcha = document.getElementById("captcha");
    captcha.src = "/captcha.jpg?t=" + new Date().getTime();
}


