
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>待审核商品</title>
    <link rel="stylesheet" href="/static/css/font.css">
    <link rel="stylesheet" href="/static/css/xadmin.css">
    <script src="../static/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../static/js/xadmin1.js"></script>
    <script type="text/javascript" src="../static/js/xadmin.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
</head>
<body>
<div class="container goods">
    <div class="row goods-list">
        <c:forEach items="${list}" var="goods" begin="0" end="2">

            <div class="col-sm-6 col-md-3 goods">
                <div class="thumbnail">
                    <a href="${pageContext.request.contextPath}/confirm/showoneGood?id=${goods.id}">
                        <img class="good-img" src="${pageContext.request.contextPath}/${goods.img}" alt="${goods.name}">
                    </a>
                    <h3 class="goods-title">${goods.name}</h3>
                </div>
            </div>

        </c:forEach>

    </div>
</div>

</body>
</html>
