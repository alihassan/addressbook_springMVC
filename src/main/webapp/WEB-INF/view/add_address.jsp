<%--
  Created by IntelliJ IDEA.
  User: hassan
  Date: 07-Aug-21
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Form for Address Book</title>
</head>
<body>
<div class="col-md-4 offset-md-4">
<form:form action="save-Address" modelAttribute="person" method="POST">
    <h2 class="font-weight-bolder">Address Form</h2>
    <form:hidden path="id"/>
    <label>Name:</label>
    <form:input class="form-control" placeholder="Enter name" path="name" required="required"/> <br>
    <label>Email:</label>
    <form:input class="form-control" type="email" placeholder="Enter email" path="email" required="required"/> <br>
    <label>Gender:</label> <br>
    <form:radiobutton path="gender" value="Male" required="required"/> Male
    <form:radiobutton path="gender" value="Female"/> Female
    <br> <br>
    <label>Street Address:</label>
    <form:input class="form-control" placeholder="Enter Street Address" path="address" required="required"/> <br>
    Select your City:
    <form:select path="city" required="required">
        <form:option disabled="true" label="Your City" value="" selected="selected"/>
        <form:option value="Islamabad" label="Islamabad"/>
        <form:option value="Karachi" label="Karachi"/>
        <form:option value="Quetta" label="Quetta"/>
        <form:option value="Peshawar" label="Peshawar"/>
        <form:option value="Lahore" label="Lahore"/>
    </form:select>
    <br> <br>
    <div class="d-flex justify-content-around">
        <a href="dashboard"><button type="button" name="back" class="btn btn-secondary">Go Back</button></a>
        <button type="submit" name="submit" class="btn btn-primary">Submit</button>
    </div>
</form:form>
</div>


</body>
</html>
