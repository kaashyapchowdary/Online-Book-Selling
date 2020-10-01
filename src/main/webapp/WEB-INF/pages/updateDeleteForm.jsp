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
        background-image: url("https://www.xmple.com/wallpaper/purple-linear-white-gradient-1920x1080-c2-ee82ee-f0f8ff-a-300-f-14.svg");
        background-repeat: no-repeat;
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
            <td><a href="updateBook/${book.bookId}">Update</a></td>
            <td><a href="deleteBookData/${book.bookId}">Delete</a> </td>
        </tr>
    </c:forEach>
</table>
<%--${listOfStudents}--%>
