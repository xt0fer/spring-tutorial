<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <a href="/comments/delete/${newsindex}/${status.index}.do" class="btn btn-danger">Sterge</a>
                </sec:authorize>
            </div>
        </div>
    </div>
    <hr>
</c:forEach>

<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
    <a href="/comments/add/${newsindex}.do" class="btn">Adauga comentariu</a>
</sec:authorize>

<jsp:include page="template/footer.jsp" />
