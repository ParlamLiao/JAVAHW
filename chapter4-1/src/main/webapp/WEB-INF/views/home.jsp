<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="false" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>首页</title>
<link href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>

<body> gradle task view
<nav class="navbar navbar-light bg-light">
<div class="navar-header"><a class="navbr-brand" href="#">欢迎来到华萌</a></div>
<form class="form-inline my-2 my-lg-0">
  <label for="userName" class="mr-sm-2">用户名：</label>
  <input class="form-control mr-sm-2" type="search" placeholder="用户名" id="userName" aria-label="用户名：">
    <label for="userName" class="mr-sm-2">密码：</label>
  <input class="form-control mr-sm-2" type="password" placeholder="用户名" id="userName" aria-label="用户名：">
  <button type="submit" class="btn btn-primary mb-2">登陆</button>
</form>
</nav>
<div class="row">
<form class="form-inline">
<div class="col-xs-9">
<input type="text" class="form-control form-inline col-xs-9" placeholder="输入不超过100字的消息"/>
</div>
<button type="button"></button>
<button type="submit" class="btn btn-primary mb-2">发消息</button>
</form>
</div>
<div class="row">

</div>

<a href="<c:url value="/HquerMsgList"/>">消息列表</a>
<a href="<c:url value="/Hquer/register"/>">注册</a>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous" type="text/javascript"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>