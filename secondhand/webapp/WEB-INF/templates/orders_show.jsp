<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单信息</title>
    <link rel="stylesheet" href="/static/css/font.css">
    <link rel="stylesheet" href="/static/css/xadmin.css">
    <script src="/static/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/static/js/xadmin.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
</head>
<body class="layui-anim layui-anim-up">
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">订单管理</a>
        <a><cite>订单信息</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;float:right"
       href="/order/ordersShow" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<hr class="hr15">
<div class="x-body">
    <div class="layui-row">
        <xblock>
            <div class="layui-input-inline layui-show-xs-block">
                <input type="text" id="key" placeholder="请输入订单号" autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-input-inline layui-show-xs-block">
                <button class="layui-btn layui-btn-radius" id="search"><i class="layui-icon">&#xe615;</i>查找
                </button>
            </div>
            <div class="layui-input-inline layui-show-xs-block">
                <form action="/Campusafety/fileUpload" method="post" enctype="multipart/form-data">
                    <div class="layui-btn layui-btn-radius"><i class="iconfont">&#xe718;</i>
                        <input type="file"
                               class="layui-btn"
                               name="uploadFile"
                               id="file"
                               style="font-size: 0px ; opacity:0;-ms-filter: 'alpha(opacity=0)'"/>导入Excle

                    </div>

                    <input
                            class="layui-btn layui-btn-radius" id="up" onclick="return check()" type="submit"
                            value=" 确定导入 "/>

                </form>

            </div>
            <div class="layui-input-inline layui-show-xs-block">
                <a href="/Campusafety/toExcel">
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
            <th>买家</th>
            <th>订单编号</th>
            <th>订单总价</th>
            <th>订单状态</th>
            <th>订单创建时间</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="orders">
            <tr>
                <td>
                    <input type="checkbox" name="id" value="${orders.id}" lay-skin="primary">
                </td>
                <td>${orders.user.username}</td>
                <td>${orders.order_num}</td>
                <td>${orders.order_price}</td>
                <td>${orders.orderstate.state}</td>
                <td>${orders.order_date}</td>
                <td>${orders.order_message}</td>
                <td class="td-manage">

                    <a title="编辑"
                       onclick="xadmin.open('编辑','${pageContext.request.contextPath}/order/editPage?id=${orders.id}',700,400)">
                        <i class="layui-icon">&#xe642;</i>
                    </a>

                    <a title="删除" onclick="member_del(this,'${orders.id}')">
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
                window.location.href = "/order/orderfindByKey?key=" + key;
            }

        })

    });



    /*商品-删除*/
    function member_del(obj, id) {
        layer.confirm('是否确认', {icon: 5}, function (index) {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/order/delOrders",
                data: {id: id},
                dataType: "json",
                success: function (data) {
                    if(data.type == "success"){
                        alert(data.msg);
                        setTimeout(function () {
                            location.href= '/order/ordersShow'
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
                url: "${pageContext.request.contextPath}/order/delmanyOrders",
                data: {ids: ids},
                dataType: "json",
                success: function (data) {
                    if(data.type == "success"){
                        alert(data.msg);
                        setTimeout(function () {
                            location.href= '/order/ordersShow'
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
