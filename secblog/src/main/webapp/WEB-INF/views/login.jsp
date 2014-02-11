<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="template/header.jsp"/>

<form method="post">
    <fieldset>
        <legend>Please Login</legend>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <label for="username">Username</label>
        <input type="text" id="username" name="username"/>

        <label for="password">Password</label>
        <input type="password" id="password" name="password"/>

        <div class="form-actions">
            <button type="submit" class="btn">Log in</button>
        </div>
    </fieldset>
</form>


<jsp:include page="template/footer.jsp"/>
