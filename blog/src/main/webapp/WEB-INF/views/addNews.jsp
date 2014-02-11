<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="template/header.jsp"/>
<h1>Adauga noutate</h1>

<form:form modelAttribute="news" method="post" cssClass="form-horizontal">
    <div class="control-group">
        <label class="control-label">Titlu<span class="required">*</span></label>

        <div class="controls">
            <form:input path="title"/>
            <form:errors path="title" cssClass="label label-important"/>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label">Continut</label>

        <div class="controls">
            <form:textarea path="content"/>
        </div>
    </div>

    <div class="controls">
        <button type="submit" class="btn btn-primary">Salveaza noutate</button>
        <button type="reset" class="btn">Resetare campuri</button>
    </div>
</form:form>

<jsp:include page="template/footer.jsp"/>
