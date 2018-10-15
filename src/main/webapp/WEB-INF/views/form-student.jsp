<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body {background-color: powderblue;}
        h1   {color: blue;}
        p    {color: red;}
        .container {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }

    </style>
    <title>Add Student</title>
</head>
<body>

<div class="container">
    <form:form modelAttribute="student" method="post" action="/app/student/add-student">
    <table >
        <tr>
            <td>ID : </td>
            <td><form:input path="studentId"/></td>
        </tr>
        <tr>
            <td>Name : </td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Last Name :</td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td>Gender: </td>
            <td><form:select path="gender" id="genderOptions">
                <form:option value="">Select Gender</form:option>
                <form:option value="MALE">Male</form:option>
                <form:option value="FEMALE">Female</form:option>
            </form:select></td>
        </tr>
        <tr>
            <td>Status :</td>
            <td>Yes<form:radiobutton path="activeStatus" value="true"/>
                No<form:radiobutton path="activeStatus" value="false"/></td>
        </tr>
        <tr>
            <td>Course List :</td>
            <td><form:input path="courseList"/></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>


    </table>
    </form:form>

    <br><br>
    <form:form action="/app/student/list">
        <input type="submit" value="Student List" onclick="return confirm('Student Added successfully')"/>
    </form:form>
</div>
</body>
</html>

