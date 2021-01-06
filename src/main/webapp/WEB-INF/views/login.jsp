<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>欢迎使用爱博网OA</title>
    <meta name="keywords" content="HTML5 Bootstrap 3 Admin Template UI Theme" />
    <meta name="description" content="AbsoluteAdmin - A Responsive HTML5 Admin UI Framework">
    <meta name="author" content="AbsoluteAdmin">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/oa/assets/skin/default_skin/css/theme.css">
    <link rel="stylesheet" type="text/css" href="/oa/assets/admin-tools/admin-forms/css/admin-forms.css">
    <link rel="shortcut icon" href="/oa/assets/img/favicon.ico">
</head>
<body class="external-page external-alt sb-l-c sb-r-c">
<div id="main" class="animated fadeIn">
    <section id="content_wrapper">
        <section id="content">
            <div class="admin-form theme-info mw500" id="login">
                <div class="content-header">
                    <h1> 爱博网OA</h1>
                    <p class="lead">欢迎使用爱博网自动化管理系统</p>
                    <p style="color: red;">${mes}</p>
                </div>
                <div class="panel mt30 mb25">
                    <form method="post" action="/oa/login.do" id="contact">
                        <div class="panel-body bg-light p25 pb15">
                            <div class="section">
                                <label for="sn" class="field-label text-muted fs18 mb10">工号</label>
                                <label for="sn" class="field prepend-icon">
                                    <input type="text" name="eId" id="sn" class="gui-input" placeholder="请输入工号...">
                                    <label for="sn" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="section">
                                <label for="password" class="field-label text-muted fs18 mb10">密码</label>
                                <label for="password" class="field prepend-icon">
                                    <input type="password" name="password" id="password" class="gui-input" placeholder="请输入密码...">
                                    <label for="password" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="panel-footer clearfix">
                            <button type="submit" class="button btn-primary mr10 pull-middle">登陆</button>
<%--                            <label class="switch ib switch-primary mt10">--%>

<%--                            </label>--%>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </section>
</div>
<script src="/oa/vendor/jquery/jquery-1.11.1.min.js"></script>
<script src="/oa/vendor/jquery/jquery_ui/jquery-ui.min.js"></script>
<script src="/oa/assets/js/utility/utility.js"></script>
<script src="/oa/assets/js/demo/demo.js"></script>
<script src="/oa/assets/js/main.js"></script>
</body>
</html>
