
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品种类</title>
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
            <label for="typename" class="layui-form-label">
                <span class="x-red">*</span>种类名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="typename" required="" lay-verify="nikename"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" style="margin-left: 550px">
            <button class="layui-btn" id="add">
                添加
            </button>
        </div>

    </xblock>
</div>


<script>

    /**
     * 添加用户信息
     */
    $("#add").click(function () {
        var typename = $("#typename").val();

        if (typename == "") {
            layer.alert('您需要将信息填完才能提交哦😯', {
                skin: 'layui-layer-molv'
                , closeBtn: 0
                , anim: 4 //动画类型
            });
        }else {
            $.ajax({
                url: "/goodstype/addGoodstype",
                type: "post",
                data: {
                    typename:typename,
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
