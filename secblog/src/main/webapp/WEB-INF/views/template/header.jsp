<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bootstrap 101 Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>

<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="/index.do">Blog</a>
        <ul class="nav pull-right">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li><a href="/news/add.do">Add news</a></li>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
                <li><a href="/login.do">Login</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li><a href="/logout">Logout</a></li>
            </sec:authorize>
        </ul>
    </div>
</div>