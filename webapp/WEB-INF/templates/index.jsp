<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>闲品HOME管理员后台</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="./static/css/font.css">
    <link rel="stylesheet" href="./static/css/xadmin.css">
    <!-- <link rel="stylesheet" href="./css/theme5.css"> -->
    <script src="./static/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./static/js/xadmin.js"></script>
    <script type="text/javascript" src="./static/js/xadmin1.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body class="index">
<!-- 顶部开始 -->
<div class="container">
    <div class="logo">
        <a href="/index">闲品HOME管理员后台</a></div>
    <div class="left_open">
        <a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
    </div>

    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">${admin.adminname}</a>
            <dl class="layui-nav-child">
                <!-- 二级菜单 -->
                <dd>
                    <a onclick="xadmin.open('个人信息','${pageContext.request.contextPath}/PersonalInfoPage',600,400)">个人信息</a></dd>
                <dd>
                    <a href="javascript:logout();">退出登录</a></dd>
            </dl>
        </li>

    </ul>
</div>

    <!-- 顶部结束 -->
    <!-- 中部开始 -->
    <!-- 左侧菜单开始 -->
    <div class="left-nav">
        <div id="side-nav">
            <ul id="nav">
                <li><a href="javascript:;"> <i class="iconfont">&#xe6b8;</i>
                    <cite>用户管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                    <ul class="sub-menu">
                        <li><a onclick="xadmin.add_tab('用户列表','/user/userShow')">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>用户列表</cite>
                        </a>
                        </li>
                    </ul>
                </li>

                <li><a href="javascript:;"> <i class="iconfont">&#xe689;</i>
                    <cite>商品管理</cite> <i class="iconfont nav_right">&#xe697;</i>
                </a>
                    <ul class="sub-menu">
                        <li><a onclick="xadmin.add_tab('商品列表','/goods/goodsShow')">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>商品列表</cite>
                        </a>
                        </li>
                    </ul>

                    <ul class="sub-menu">
                        <li><a onclick="xadmin.add_tab('发布商品','/goods/goodspublish')">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>发布商品</cite><!--链接到用户发布商品界面 -->
                        </a>
                        </li>
                    </ul>
                </li>

                <li><a href="javascript:;"> <i class="iconfont">&#xe6ce;</i>
                    <cite>订单管理</cite> <i class="iconfont nav_right">&#xe697;</i>
                </a>
                    <ul class="sub-menu">
                        <li><a onclick="xadmin.add_tab('订单列表','/order/ordersShow')">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>订单列表</cite>
                        </a>
                        </li>
                    </ul>
                </li>

                <li><a href="javascript:;"> <i class="iconfont">&#xe6b8;</i>
                    <cite>商品种类管理</cite> <i class="iconfont nav_right">&#xe697;</i>
                </a>
                    <ul class="sub-menu">
                        <li><a onclick="xadmin.add_tab('类型列表','/goodstype/goodstypeShow')">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>类型列表</cite>
                        </a>
                        </li>
                    </ul>
                </li>

                <li><a href="javascript:;"> <i class="iconfont">&#xe6b8;</i>
                    <cite>公告信息管理</cite> <i class="iconfont nav_right">&#xe697;</i>
                </a>
                    <ul class="sub-menu">
                        <li><a onclick="xadmin.add_tab('公告信息','/notice/noticeShow')">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>公告信息</cite>
                        </a>
                        </li>
                    </ul>
                    <ul class="sub-menu">
                        <li><a onclick="xadmin.add_tab('发布公告','/notice/addPage')">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>发布公告</cite>
                        </a>
                        </li>
                    </ul>
                </li>

                <li><a href="javascript:;"> <i class="iconfont">&#xe6b8;</i>
                    <cite>审核商品发布信息</cite> <i class="iconfont nav_right">&#xe697;</i>
                </a>
                    <ul class="sub-menu">
                        <li><a onclick="xadmin.add_tab('待审核','/goods/unconfirmShow')">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>待审核信息</cite>
                        </a>
                        </li>
                    </ul>
                    <ul class="sub-menu">
                        <li><a onclick="xadmin.add_tab('已审核','/goods/confirmShow')">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>已审核信息</cite>
                        </a>
                        </li>
                    </ul>
                </li>

                <li><a href="javascript:;"> <i class="iconfont">&#xe6b8;</i>
                    <cite>广告图片上传</cite> <i class="iconfont nav_right">&#xe697;</i>
                </a>
                    <ul class="sub-menu">
                        <li><a onclick="xadmin.add_tab('广告图片上传','/advertisement/uploadimage')">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>广告图片上传</cite>
                        </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div><!-- <div class="x-slide_left"></div> -->
        <!-- 左侧菜单结束 -->
        <!-- 右侧主体开始 -->
        <div class="page-content">
            <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
                <ul class="layui-tab-title">
                    <li class="home">
                        <i class="layui-icon">&#xe68e;</i>我的桌面
                    </li>
                </ul>
                <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
                    <dl>
                        <dd data-type="this">关闭当前</dd>
                        <dd data-type="other">关闭其它</dd>
                        <dd data-type="all">关闭全部</dd>
                    </dl>
                </div>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <iframe src='CityComprehensive/cityMap' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
                    </div>
                </div>
                <div id="tab_show"></div>
            </div>
        </div>

        <div class="page-content-bg"></div>
        <style id="theme_style"></style>


</div>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
<script>
    function logout() {
        layer.confirm('确定要退出吗？',function x(index) {
            location.href = "/logout";
        });
    }
</script>

</html>
