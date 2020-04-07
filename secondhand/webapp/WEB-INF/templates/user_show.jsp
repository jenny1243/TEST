
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户信息</title>
    <link rel="stylesheet" href="/static/css/font.css">
    <link rel="stylesheet" href="/static/css/xadmin.css">
    <script src="../static/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../static/js/xadmin1.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
</head>
<body class="layui-anim layui-anim-up">
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">用户管理</a>
        <a><cite>用户信息</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;float:right"
       href="/user/userShow" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<hr class="hr15">
<div class="x-body">
    <div class="layui-row">
        <xblock>
            <div class="layui-input-inline layui-show-xs-block">
                <input type="text" id="key" placeholder="请输入用户名" autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-input-inline layui-show-xs-block">
                <button class="layui-btn layui-btn-radius" id="search"><i class="layui-icon">&#xe615;</i>查找
                </button>
            </div>
            <div class="layui-input-inline layui-show-xs-block">
                <a href="/user/toExcel">
                    <button type="button" class="layui-btn layui-btn-radius"><i class="iconfont">&#xe714;</i>Excle 导出
                    </button>
                </a>
                <button class="layui-btn layui-btn-danger layui-btn-radius" onclick="delAll()"><i
                        class="layui-icon"></i>批量删除
                </button>
            </div>
        </xblock>
        <hr class="hr15">
    </div>
    <xblock>

        <span class="x-right" style="line-height:40px">共有数据：${pageInfo.total} 条</span>
    </xblock>
    <table class="layui-table layui-form">
        <thead>
        <tr>
            <th>
                <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                <span>全选</span>
            </th>
            <th>用户名</th>
            <th>昵称</th>
            <th>联系电话</th>
            <th>账号创建时间</th>
            <th>最近登录时间</th>
            <th>账号状态</th>
            <th>发布的商品数量</th>
            <th>信用分</th>
            <th>邮箱</th>
            <th>密码</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="user">
            <tr>
                <td>
                    <input type="checkbox" name="id" value="${user.userId}" lay-skin="primary">
                </td>
                <td>${user.username}</td>
                <td>${user.nickname}</td>
                <td>${user.phone}</td>
                <td>${user.create_time}</td>
                <td>${user.last_login_time}</td>
                <td>${user.status}</td>
                <td>${user.goods_num}</td>
                <td>${user.credit_score}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td class="td-manage">

                    <a title="编辑"
                       onclick="xadmin.open('编辑','${pageContext.request.contextPath}/user/editPage?id=${user.userId}',700,400)">
                        <i class="layui-icon">&#xe642;</i>
                    </a>

                    <a title="删除" onclick="member_del(this,'${user.userId}')">
                        <i class="layui-icon">&#xe640;</i>
                    </a>

                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <div class="page">
        <div>

            <c:if test="${pageInfo.hasPreviousPage}">
                <a class="prev" href="${url}${pageInfo.prePage}">&lt;&lt;</a>
            </c:if>
            <c:forEach items="${pageInfo.navigatepageNums}" var="p">
                <c:if test="${pageInfo.pageNum==p}">
                    <span class="current">${p}</span>
                </c:if>
                <c:if test="${pageInfo.pageNum!=p}">
                    <a class="num" href="${url}${p}">${p}</a>
                </c:if>
            </c:forEach>
            <c:if test="${pageInfo.hasNextPage}">
                <a class="next" href="${url}${pageInfo.nextPage}">&gt;&gt;</a>
            </c:if>

        </div>
    </div>

</div>
<script>
    layui.use(['laydate', 'form'], function () {
        var laydate = layui.laydate;
        var form = layui.form;
        // 监听全选
        form.on('checkbox(checkall)', function (data) {

            if (data.elem.checked) {
                $('tbody input').prop('checked', true);
            } else {
                $('tbody input').prop('checked', false);
            }
            form.render('checkbox');
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });


    });

    $(function () {
        /**
         * 搜索功能
         */

        $("#search").click(function () {
            var key = $("#key").val();
            console.log(key);
            if (key == "") {
                layer.alert('搜索内容不能为空(⊙﹏⊙)', {
                    skin: 'layui-layer-molv'
                    , closeBtn: 0
                    , anim: 4 //动画类型
                });

            } else {
                window.location.href = "/user/userfindByKey?key=" + key;
            }

        })

    });

    function check() {
        var file = $("#file").val();
        if (file == "") {
            layer.alert('未选择文件(⊙﹏⊙)', {
                skin: 'layui-layer-molv'
                , closeBtn: 0
                , anim: 4 //动画类型
            });
            return false;
        }
        var i = file.toString().lastIndexOf("xlsx");
        if (i == -1) {
            layer.alert('请从新选择Excil文件(⊙﹏⊙)', {
                skin: 'layui-layer-molv'
                , closeBtn: 0
                , anim: 4 //动画类型
            });
            return false;
        }


        return true;

    }


    /*用户-删除（注销）*/
    function member_del(obj, userId) {
        layer.confirm('是否确认', {icon: 5}, function (index) {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/user/delUser",
                data: {userId: userId},
                dataType: "json",
                success: function (data) {
                    if(data.type == "success"){
                        alert(data.msg);
                        setTimeout(function () {
                            location.href= '/user/userShow'
                        },1000)
                    }else {
                        alert(data.msg);
                    }
                }, error: function (data) {
                    alert("fail");
                }
            });
        });
    }

    /**
     * 批量删除
     */
    function delAll(argument) {
        var ids = [];
        // 获取选中的id
        $('tbody input').each(function (index, el) {
            if ($(this).prop('checked')) {
                ids.push($(this).val())
            }
        });
        ids = ids.join(",");
        layer.confirm('确认要删除吗？', function (index) {
            //捉到所有被选中的，发异步进行删除
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/user/delmanyUser",
                data: {ids: ids},
                dataType: "json",
                success: function (data) {
                    if(data.type == "success"){
                        alert(data.msg);
                        setTimeout(function () {
                            location.href= '/user/userShow'
                        },1000)
                    }else {
                        alert(data.msg);
                    }
                }, error: function (data) {
                    alert("fail");
                }
            });
        });
    }

</script>

</body>
</html>
