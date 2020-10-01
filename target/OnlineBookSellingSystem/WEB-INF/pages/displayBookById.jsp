<%--
  Created by IntelliJ IDEA.
  User: Trainee
  Date: 3/3/2020
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table align="center" cellspacing="0" style="border: brown" border="5">
    <tr>
        <th>BookId</th>
        <th>BookName</th>
        <th>BookDescription</th>
        <th>BookAuthorName</th>
       <th>InrPrice</th>
        <th>UsdPrice</th>
    </tr>
    <tr>
        <td>${getBook.bookId}</td>
        <td>${getBook.bookName}</td>
        <td>${getBook.bookDescription}</td>
        <td>${getBook.bookAuthorName}</td>
        <td>${getBook.inrPrice}</td>
        <td>${getBook.usdPrice}</td>
    </tr>
</table>
<a href="../index.jsp">Home</a>
