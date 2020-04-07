<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公告信息列表</title>
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
        <a href="">公告信息管理</a>
        <a><cite>公告信息</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;float:right"
       href="/notice/noticeShow" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
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
            <th>公告内容</th>
            <th>发布时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="notice">
            <tr>
                <td>
                    <input type="checkbox" name="id" value="${notice.id}" lay-skin="primary">
                </td>
                <td>${notice.content}</td>
                <td>${notice.publis_time}</td>
                <td class="td-manage">

                    <a title="编辑"
                       onclick="xadmin.open('编辑','${pageContext.request.contextPath}/notice/editPage?id=${notice.id}',700,400)">
                        <i class="layui-icon">&#xe642;</i>
                    </a>

                    <a title="删除" onclick="member_del(this,'${notice.id}')">
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


    /*公告-删除*/
    function member_del(obj, id) {
        layer.confirm('是否确认', {icon: 5}, function (index) {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/notice/delNotice",
                data: {id: id},
                dataType: "json",
                success: function (data) {
                    if(data.type == "success"){
                        alert(data.msg);
                        setTimeout(function () {
                            location.href= '/notice/noticeShow'
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
                url: "${pageContext.request.contextPath}/notice/delmanyNotice",
                data: {ids: ids},
                dataType: "json",
                success: function (data) {
                    if(data.type == "success"){
                        alert(data.msg);
                        setTimeout(function () {
                            location.href= '/notice/noticeShow'
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
