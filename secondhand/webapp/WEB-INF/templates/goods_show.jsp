
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品信息</title>
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
        <a href="">商品管理</a>
        <a><cite>商品信息</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;float:right"
       href="/goods/goodsShow" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<hr class="hr15">
<div class="x-body">
    <div class="layui-row">
        <xblock>
            <div class="layui-input-inline layui-show-xs-block">
                <input type="text" id="key" placeholder="请输入商品名" autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-input-inline layui-show-xs-block">
                <button class="layui-btn layui-btn-radius" id="search"><i class="layui-icon">&#xe615;</i>查找
                </button>
            </div>
            <div class="layui-input-inline layui-show-xs-block">
                <a href="/goods/toGoodsExcel">
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
            <th>发布者</th>
            <th>商品名称</th>
            <th>出售价格</th>
            <th>原价</th>
            <th>发布时间</th>
            <th>商品状态</th>
            <th>商品库存量</th>
            <th>下架时间</th>
            <th>描述</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="goods">
            <tr>
                <td>
                    <input type="checkbox" name="id" value="${goods.id}" lay-skin="primary">
                </td>
                <td>${goods.user.username}</td>
                <td>${goods.name}</td>
                <td>${goods.price}</td>
                <td>${goods.real_price}</td>
                <td>${goods.release_date}</td>
                <td>${goods.goodstate.state}</td>
                <td>${goods.repertory}</td>
                <td>${goods.remove_date}</td>
                <td>${goods.describle}</td>
                <td class="td-manage">

                    <a title="编辑"
                       onclick="xadmin.open('编辑','${pageContext.request.contextPath}/user/editPage?id=${goods.id}',700,400)">
                        <i class="layui-icon">&#xe642;</i>
                    </a>

                    <a title="删除" onclick="member_del(this,'${goods.id}')">
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
                window.location.href = "/goods/goodsfindByKey?key=" + key;
            }

        })

    });



    /*商品-删除*/
    function member_del(obj, id) {
        layer.confirm('是否确认', {icon: 5}, function (index) {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/goods/delGoods",
                data: {id: id},
                dataType: "json",
                success: function (data) {
                    if(data.type == "success"){
                        alert(data.msg);
                        setTimeout(function () {
                            location.href= '/goods/goodsShow'
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
                url: "${pageContext.request.contextPath}/goods/delmanyGoods",
                data: {ids: ids},
                dataType: "json",
                success: function (data) {
                    if(data.type == "success"){
                        alert(data.msg);
                        setTimeout(function () {
                            location.href= '/goods/goodsShow'
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
