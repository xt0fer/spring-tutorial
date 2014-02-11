<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="template/header.jsp"/>

<c:forEach items="${news}" var="item" varStatus="status">
    <div class="row-fluid">
        <div class="span3">
            <div><span class="label">${item.date}</span></div>
            <div><span class="badge badge-info">${fn:length(item.comments)}</span></div>
        </div>
        <div class="span9">
            <h2><a href="/news/${status.index}.do">${item.title}</a></h2>
            <div><c:out value="${item.content}"/></div>
            <div class="clearfix">
                <div class="pull-left">
                    <a href="/news/delete/${status.index}.do" class="btn btn-danger">Sterge</a>
                </div>
            </div>
        </div>
    </div>
</c:forEach>

<jsp:include page="template/footer.jsp"/>
