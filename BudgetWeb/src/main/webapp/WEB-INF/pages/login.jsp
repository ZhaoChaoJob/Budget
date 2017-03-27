<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <%@include file="base.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="format-detection" content= "telephone=no" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0">
    <link href="${ctx}/css/Cardtable.css" rel="stylesheet" type="text/css">
    <script src="${ctx}/js/jquery-2.2.3.min.js" type="text/javascript"></script>
    <title>商户服务登录</title>
</head>
<body style="background-color:#fafafa;">
<div class="container">
    <img src="${ctx}/images/logo-1.png" class="logo">
    <div class="UserPage_title"><span class="grayLine" ></span>用户登陆<span class="grayLine" style="float:right;"></span></div>
    <div class="table_box table-shadow">
        <form >
            <table class="tableUser">
                <tr>
                    <td class="tdUser_top_left" width="60">商户号</td>
                    <td  align="left" colspan="2" class="tdUser_top_right" >
                        <input class="td_input" type="text" placeholder="请输入商户号" >
                    </td>
                </tr>
                <tr>
                    <td class="tdUser_left" width="60">用户名</td>
                    <td  align="center" class="tdUser_right" colspan="2">
                        <input class="td_input" type="text" placeholder="请输入用户名" >
                    </td>
                </tr>
                <tr>
                    <td class="tdUser_left" width="60">密<span style="margin-left:14px;font-size:14px;">码</span></td>
                    <td  align="center" class="tdUser_right" colspan="2">
                        <input class="td_input" type="text" placeholder="请输入密码" >
                    </td>
                </tr>
                <tr>
                    <td class="tdUser_bottom_left " width="60">验证码</td>
                    <td  align="center" class="tdUser_bottom_center" >
                        <input class="td_input" type="text" placeholder="请输入验证码" >
                    </td>
                    <td width="80" class="tdUser_bottom_right">
                        <span class="yama "><img src="${ctx}/images/yanma.png"/></span>
                    </td>
                </tr>
            </table>
    <div class="table_box">
        <span class="errorTip" id="errorMsg">请先登录</span>
    </div>
    </form>
    <input id="table_Userbut" class="table_Userbut" type="button" value="登录" >
    <div class="table_box">
        <a href="#" class="forgetPass" onclick="">忘记密码</a>
    </div>
</div>
    </div>
</body>
</html>
