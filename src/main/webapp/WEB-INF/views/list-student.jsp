<%@ page import="java.util.List" %>
<%@ page import="com.ramin.model.student.Student" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body {background-color: powderblue;}
        h1   {color: blue;}
        p    {color: red;}

    </style>
</head>
<body>

<h1>Students List</h1>

<form:form action="/app/student/show-form">
    <input type="submit" value="Add New Student"/>
</form:form>

<table border="2" width="70%" cellpadding="2">
    <tr><th>ID</th><th>Name</th><th>LastName</th><th>Gender</th><th>Status(Active)</th>
        <th>Courses</th><th>Edit</th><th>Delete</th></tr>

    <c:forEach var="std" items="${studentList}">
        <tr>
            <td>${std.studentId}</td>
            <td>${std.name}</td>
            <td>${std.lastName}</td>
            <td>${std.gender}</td>
            <td>${std.activeStatus}</td>
            <td>
                <ul>
                    <c:forEach var="course" items="${std.courseList}">
                        <li>${course.toString()}</li>
                    </c:forEach>
                </ul>
            </td>
            <td><a href="edit-student/${std.id}">Edit</a></td>
            <td><a href="delete-student/${std.id}" onclick="return confirm('Are you sure?')">Delete</a></td>

        </tr>
    </c:forEach>
</table>




</body>
</html>
