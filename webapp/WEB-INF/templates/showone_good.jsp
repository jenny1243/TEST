
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情页</title>
    <link rel="stylesheet" href="/static/css/font.css">
    <link rel="stylesheet" href="/static/css/xadmin.css">
    <script src="../static/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../static/js/xadmin1.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
</head>
<body>
<h1>商品详情</h1>
<hr>
    <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
        <tr>
            <!-- 商品详情 -->
            <td width="70%" valign="top">
                <table>
                    <tr>
                        <td rowspan="4"><img src="images/${goods.img}" width="200" height="160"/></td>
                    </tr>

                    <tr>
                        <td><B></B></td>
                    </tr>


                    <tr>
                        <td>原价：${goods.real_price}</td>
                    </tr>
                    <tr>
                        <td>价格：${goods.getPic()}￥</td>
                    </tr>


                </table>

            </td>
        </tr>
    </table>
</body>
</html>
