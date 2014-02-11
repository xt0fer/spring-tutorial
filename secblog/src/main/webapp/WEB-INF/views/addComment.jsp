<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="template/header.jsp"/>
<h1>Adauga comentariu</h1>

<form:form modelAttribute="comment" method="post" cssClass="form-horizontal">
    <div class="control-group">
        <label class="control-label">Autor<span class="required">*</span></label>

        <div class="controls">
            <form:input path="name"/>
            <form:errors path="name" cssClass="label label-important"/>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">Comentariu</label>

        <div class="controls">
            <form:textarea path="comment"/>
            <form:errors path="comment" cssClass="label label-important"/>
        </div>
    </div>

    <div class="controls">
        <button type="submit" class="btn btn-primary">Salveaza comentariu</button>
        <button type="reset" class="btn">Resetare campuri</button>
    </div>
</form:form>

<jsp:include page="template/footer.jsp"/>
