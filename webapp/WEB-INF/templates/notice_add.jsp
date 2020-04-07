
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布公告</title>
    <link rel="stylesheet" href="/static/css/font.css">
    <link rel="stylesheet" href="/static/css/xadmin.css">
    <script src="../static/layui/layui.js" charset="utf-8"></script>
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
            <label for="content" class="layui-form-label">
                <span class="x-red">*</span>公告内容
            </label>
            <div class="layui-input-inline">
                <input type="textarea" id="content" required="" lay-verify="nikename"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" style="margin-left: 550px">
            <button class="layui-btn" id="pub">
                发布
            </button>
        </div>

    </xblock>
</div>


<script>

    /**
     * 发布公告
     */
    $("#pub").click(function () {
        var date=new Date();
        var y=date.getFullYear();
        var m=(date.getMonth()+1);
        var d=date.getDate();
        var publis_time=y+'-'+m+'-'+d;
        var content = $("#content").val();

        if (content == "") {
            layer.alert('您需要填写公告内容😯', {
                skin: 'layui-layer-molv'
                , closeBtn: 0
                , anim: 4 //动画类型
            });
        }else {
            $.ajax({
                url: "/notice/noticePub",
                type: "post",
                data: {
                    content:content,
                    publis_time:publis_time
                },
                dataType: "json",
                success: function (data) {
                    if (data.type=="success") {
                        layer.alert("添加成功！", {icon: 6}, function () {
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
