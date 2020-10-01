<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
    .error {
        color: red;
    }
    body{
        background-color: lavender;
    }
</style>
<c:url value="/updateBookData" var="formUrl"/>
<form:form modelAttribute="update" action="${formUrl}" method="post" >
    <%--<form:errors path="*" cssClass="errorblock" element="div" />--%>
    <a href="../index.jsp">Home</a>
    <h3 align="center">Update Book Data Form</h3>
    <table align="center">
        <tr>
            <td>BookId:</td>
            <td><form:input path="bookId" readonly="true"/></td>
            <td><form:errors path="bookId" cssClass="error"/></td>
        </tr>
        <tr>
            <td>BookName:</td>
            <td><form:input path="bookName"/></td>
            <td><form:errors path="bookName" cssClass="error" /></td>
        </tr>
        <tr>
            <td>BookDescription:</td>
            <td><form:input path="bookDescription"/></td>
            <td><form:errors path="bookDescription" cssClass="error" /></td>
        </tr>
        <tr>
            <td>BookAuthorName:</td>
            <td><form:input path="bookAuthorName"/></td>
            <td><form:errors path="bookAuthorName" cssClass="error" /></td>
        </tr>
        <tr>
            <td>BookPrice[INR]:</td>
            <td><form:input path="inrPrice"/></td>
            <td><form:errors path="inrPrice" cssClass="error" /></td>
        </tr>
        <tr>
            <td>BookPrice[USD]:</td>
            <td><form:input path="usdPrice"/></td>
            <td><form:errors path="usdPrice" cssClass="error" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update Book"></td>
        </tr>
    </table>
</form:form>
