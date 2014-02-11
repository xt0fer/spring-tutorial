<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp" />
<h1>${news.title}</h1>
<div>${news.content}</div>
<hr>
<c:forEach items="${news.comments}" var="comment" varStatus="status">
    <div>
        <div class="clearfix">
            <div class="pull-left">${comment.name}</div>
            <div class="pull-right">${comment.date}</div>
        </div>
        <c:out value="${comment.comment}"/>

        <div class="clearfix">
            <div class="pull-left">
                <a href="/comments/delete/${newsindex}/${status.index}.do" class="btn btn-danger">Sterge</a>
            </div>
        </div>
    </div>
    <hr>
</c:forEach>
<a href="/comments/${newsindex}/add.do" class="btn">Adauga comentariu</a>

<jsp:include page="template/footer.jsp" />
