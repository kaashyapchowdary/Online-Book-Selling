<%--
  Created by IntelliJ IDEA.
  User: Trainee
  Date: 2/26/2020
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    body{
        background-image: url("https://png.pngtree.com/thumb_back/fw800/back_pic/03/60/72/8057a6909bb7d0d.jpg");
        background-repeat: no-repeat;
        background-size: 1350px 650px;
    }
</style>
<a href="index.jsp">Home</a>
<h3 align="center">All Book Details</h3>
<table align="center" cellspacing="0" style="border: brown" border="5" border="2" width="70%" cellpadding="2">
    <tr>
        <th>BookId</th>
        <th>BookName</th>
        <th>BookDescription</th>
        <th>BookAuthorName</th>
        <th>INRPrice</th>
        <th>USDPrice</th>
    </tr>
    <c:forEach items="${listOfBooks}" var="book">
        <tr>
            <td>${book.bookId}</td>
            <td>${book.bookName}</td>
            <td>${book.bookDescription}</td>
            <td>${book.bookAuthorName}</td>
            <td>${book.inrPrice}</td>
            <td>${book.usdPrice}</td>
        </tr>
    </c:forEach>
</table>
<%--${listOfStudents}--%>
