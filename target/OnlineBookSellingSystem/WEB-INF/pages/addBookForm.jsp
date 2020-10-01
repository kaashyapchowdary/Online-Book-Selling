<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
    .error {
        color: white;
    }
    body{
        background-image:url("https://cdn.wallpapersafari.com/85/43/sV9YnT.jpg");
        background-repeat: no-repeat;
        background-size: 1350px 650px;
    }
</style>
<c:url value="/booksAdding" var="formUrl"/>
<form:form modelAttribute="book" action="${formUrl}" method="post" >
    <%--<form:errors path="*" cssClass="errorblock" element="div" />--%>
    <a href="index.jsp">Home</a>
    <h3 align="center">Add New Book Form</h3>
    <table align="center">
        <tr>
            <td>Book Id:</td>
            <td><form:input type="number" path="bookId" readonly="true"/></td>
            <td><form:errors path="bookId" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Book Name:</td>
            <td><form:input path="bookName"/></td>
            <td><form:errors path="bookName" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Book Description:</td>
            <td><form:input path="bookDescription"/></td>
            <td><form:errors path="bookDescription" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Book AuthorName:</td>
            <td><form:input path="bookAuthorName"/></td>
            <td><form:errors path="bookAuthorName" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Book Price[INR]:</td>
            <td><form:input path="inrPrice"/></td>
            <td><form:errors path="inrPrice" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Book Price[USD]:</td>
            <td><form:input path="usdPrice"/></td>
            <td><form:errors path="usdPrice" cssClass="error" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="AddBook"></td>
        </tr>
    </table>
</form:form>
