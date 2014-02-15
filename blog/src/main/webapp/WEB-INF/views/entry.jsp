<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp" />
<h1>${entry.title}</h1>
<div>
    ${entry.content}
</div>

<hr>

<h2>Comments</h2>
<c:forEach items="${comments}" var="comment">
    <div>
        <div class="clearfix">
            <div class="pull-left">
                ${comment.date}
            </div>
            <div class="pull-right">
                <a href="/blog/entry/${entry.id}/comment/${comment.id}/delete" class="btn btn-danger btn-xs">Sterge</a>
            </div>
        </div>
        <c:out value="${comment.content}"/>
    </div>
    <hr>
</c:forEach>
<a href="/blog/entry/${entry.id}/comment/add" class="btn btn-default">Adauga comentariu</a>

<jsp:include page="template/footer.jsp" />
