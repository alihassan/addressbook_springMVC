<%--
  Created by IntelliJ IDEA.
  User: hassan
  Date: 07-Aug-21
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Address Book Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="d-flex justify-content-between">
        <h1>Address Book Dashboard</h1>
        <h3><a href="newAddress">
            <button type="button" class="btn btn-info">Add new Address</button>
        </a></h3>
    </div>
    <%
        //check if msg == null then don't print
        String msg = request.getParameter("msg");
        if(msg == null || msg.length() == 0){} else {
    %>
    <h4 class="row justify-content-center text-success"><%=request.getParameter("msg")%></h4><%}%>
    <table class="table table-bordered table-striped">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Street Address</th>
            <th>City</th>
            <th>Actions</th>
        </tr>
            <c:forEach var="per" items="${address}">
        <tr>
            <td>${per.id}</td>
            <td>${per.name}</td>
            <td>${per.email}</td>
            <td>${per.gender}</td>
            <td>${per.address}</td>
            <td>${per.city}</td>
            <td><a href='updateForm?id=${per.id}'>update |</a>
                <a href='DeleteAddress?id=${per.id}' onclick="if(!(confirm('Do you want to delete?'))){ return false}"> delete</a></td>
        </tr>
            </c:forEach>
    </table>
</div>
</body>
</html>
